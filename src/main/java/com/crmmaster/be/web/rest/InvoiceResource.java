package com.crmmaster.be.web.rest;

import com.crmmaster.be.repository.InvoiceRepository;
import com.crmmaster.be.service.InvoiceService;
import com.crmmaster.be.service.dto.InvoiceDTO;
import com.crmmaster.be.web.rest.errors.BadRequestAlertException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tech.jhipster.web.util.HeaderUtil;
import tech.jhipster.web.util.ResponseUtil;

/**
 * REST controller for managing {@link com.crmmaster.be.domain.Invoice}.
 */
@RestController
@RequestMapping("/api")
public class InvoiceResource {

    private final Logger log = LoggerFactory.getLogger(InvoiceResource.class);

    private static final String ENTITY_NAME = "invoice";

    @Value("${jhipster.clientApp.name}")
    private String applicationName;

    private final InvoiceService invoiceService;

    private final InvoiceRepository invoiceRepository;

    public InvoiceResource(InvoiceService invoiceService, InvoiceRepository invoiceRepository) {
        this.invoiceService = invoiceService;
        this.invoiceRepository = invoiceRepository;
    }

    /**
     * {@code POST  /invoices} : Create a new invoice.
     *
     * @param invoiceDTO the invoiceDTO to create.
     * @return the {@link ResponseEntity} with status {@code 201 (Created)} and with body the new invoiceDTO, or with status {@code 400 (Bad Request)} if the invoice has already an ID.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PostMapping("/invoices")
    public ResponseEntity<InvoiceDTO> createInvoice(@Valid @RequestBody InvoiceDTO invoiceDTO) throws URISyntaxException {
        log.debug("REST request to save Invoice : {}", invoiceDTO);
        if (invoiceDTO.getId() != null) {
            throw new BadRequestAlertException("A new invoice cannot already have an ID", ENTITY_NAME, "idexists");
        }
        InvoiceDTO result = invoiceService.save(invoiceDTO);
        return ResponseEntity
            .created(new URI("/api/invoices/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(applicationName, false, ENTITY_NAME, result.getId()))
            .body(result);
    }

    /**
     * {@code PUT  /invoices/:id} : Updates an existing invoice.
     *
     * @param id the id of the invoiceDTO to save.
     * @param invoiceDTO the invoiceDTO to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated invoiceDTO,
     * or with status {@code 400 (Bad Request)} if the invoiceDTO is not valid,
     * or with status {@code 500 (Internal Server Error)} if the invoiceDTO couldn't be updated.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PutMapping("/invoices/{id}")
    public ResponseEntity<InvoiceDTO> updateInvoice(
        @PathVariable(value = "id", required = false) final String id,
        @Valid @RequestBody InvoiceDTO invoiceDTO
    ) throws URISyntaxException {
        log.debug("REST request to update Invoice : {}, {}", id, invoiceDTO);
        if (invoiceDTO.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        if (!Objects.equals(id, invoiceDTO.getId())) {
            throw new BadRequestAlertException("Invalid ID", ENTITY_NAME, "idinvalid");
        }

        if (!invoiceRepository.existsById(id)) {
            throw new BadRequestAlertException("Entity not found", ENTITY_NAME, "idnotfound");
        }

        InvoiceDTO result = invoiceService.update(invoiceDTO);
        return ResponseEntity
            .ok()
            .headers(HeaderUtil.createEntityUpdateAlert(applicationName, false, ENTITY_NAME, invoiceDTO.getId()))
            .body(result);
    }

    /**
     * {@code PATCH  /invoices/:id} : Partial updates given fields of an existing invoice, field will ignore if it is null
     *
     * @param id the id of the invoiceDTO to save.
     * @param invoiceDTO the invoiceDTO to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated invoiceDTO,
     * or with status {@code 400 (Bad Request)} if the invoiceDTO is not valid,
     * or with status {@code 404 (Not Found)} if the invoiceDTO is not found,
     * or with status {@code 500 (Internal Server Error)} if the invoiceDTO couldn't be updated.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PatchMapping(value = "/invoices/{id}", consumes = { "application/json", "application/merge-patch+json" })
    public ResponseEntity<InvoiceDTO> partialUpdateInvoice(
        @PathVariable(value = "id", required = false) final String id,
        @NotNull @RequestBody InvoiceDTO invoiceDTO
    ) throws URISyntaxException {
        log.debug("REST request to partial update Invoice partially : {}, {}", id, invoiceDTO);
        if (invoiceDTO.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        if (!Objects.equals(id, invoiceDTO.getId())) {
            throw new BadRequestAlertException("Invalid ID", ENTITY_NAME, "idinvalid");
        }

        if (!invoiceRepository.existsById(id)) {
            throw new BadRequestAlertException("Entity not found", ENTITY_NAME, "idnotfound");
        }

        Optional<InvoiceDTO> result = invoiceService.partialUpdate(invoiceDTO);

        return ResponseUtil.wrapOrNotFound(
            result,
            HeaderUtil.createEntityUpdateAlert(applicationName, false, ENTITY_NAME, invoiceDTO.getId())
        );
    }

    /**
     * {@code GET  /StatusSent} : get all the invoices.
     *
     * * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the list of invoices in body.
     */
    @GetMapping("/StatusSent")
    public long countByStatusSent() {
       
        return invoiceService.countByStatusSent();
    }

    /**
     * {@code GET  /StatusReceived} : get all the invoices.
     *
     * * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the list of invoices in body.
     */
    @GetMapping("/StatusReceived")
    public long countByStatusReceived() {
        
        return invoiceService.countByStatusReceived();
    }
    
    
    /**
     * {@code GET  /StatusPaid} : get all the invoices.
     *
     * * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the list of invoices in body.
     */
    @GetMapping("/StatusPaid")
    public long countByStatusPaid() {
        
        return invoiceService.countByStatusPaid();
    }

    
    
    /**
     * {@code GET  /StatusPaid} : get all the invoices.
     *
     * * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the list of invoices in body.
     */
    @GetMapping("/StatusOverdue")
    public long countByStatusOverdue() {
        
        return invoiceService.countByStatusOverdue();
    }

    
    
    /**
     * {@code GET  /invoices} : get all the invoices.
     *
     * @param eagerload flag to eager load entities from relationships (This is applicable for many-to-many).
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the list of invoices in body.
     */
    @GetMapping("/invoices")
    public List<InvoiceDTO> getAllInvoices(@RequestParam(required = false, defaultValue = "false") boolean eagerload) {
        log.debug("REST request to get all Invoices");
        return invoiceService.findAll();
    }
    
    
    /**
     * {@code GET  /invoices/:id} : get the "id" invoice.
     *
     * @param id the id of the invoiceDTO to retrieve.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the invoiceDTO, or with status {@code 404 (Not Found)}.
     */
    @GetMapping("/invoices/{id}")
    public ResponseEntity<InvoiceDTO> getInvoice(@PathVariable String id) {
        log.debug("REST request to get Invoice : {}", id);
  
        Optional<InvoiceDTO> invoiceDTO = Optional.ofNullable(invoiceService.findOne(id));
        return ResponseUtil.wrapOrNotFound(invoiceDTO);
    }

    /**
     * {@code DELETE  /invoices/:id} : delete the "id" invoice.
     *
     * @param id the id of the invoiceDTO to delete.
     * @return the {@link ResponseEntity} with status {@code 204 (NO_CONTENT)}.
     */
    @DeleteMapping("/invoices/{id}")
    public ResponseEntity<Void> deleteInvoice(@PathVariable String id) {
        log.debug("REST request to delete Invoice : {}", id);
        invoiceService.delete(id);
        return ResponseEntity.noContent().headers(HeaderUtil.createEntityDeletionAlert(applicationName, false, ENTITY_NAME, id)).build();
    }
}
