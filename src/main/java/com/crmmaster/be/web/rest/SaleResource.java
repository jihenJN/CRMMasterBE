package com.crmmaster.be.web.rest;

import com.crmmaster.be.repository.SaleRepository;
import com.crmmaster.be.service.SaleService;
import com.crmmaster.be.service.dto.SaleDTO;
import com.crmmaster.be.web.rest.errors.BadRequestAlertException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tech.jhipster.web.util.HeaderUtil;
import tech.jhipster.web.util.ResponseUtil;

/**
 * REST controller for managing {@link com.crmmaster.be.domain.Sale}.
 */
@RestController
@RequestMapping("/api")
public class SaleResource {

    private final Logger log = LoggerFactory.getLogger(SaleResource.class);

    private static final String ENTITY_NAME = "sale";

    @Value("${jhipster.clientApp.name}")
    private String applicationName;

    private final SaleService saleService;

    private final SaleRepository saleRepository;

    public SaleResource(SaleService saleService, SaleRepository saleRepository) {
        this.saleService = saleService;
        this.saleRepository = saleRepository;
    }

    /**
     * {@code POST  /sales} : Create a new sale.
     *
     * @param saleDTO the saleDTO to create.
     * @return the {@link ResponseEntity} with status {@code 201 (Created)} and with body the new saleDTO, or with status {@code 400 (Bad Request)} if the sale has already an ID.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PostMapping("/sales")
    public ResponseEntity<SaleDTO> createSale(@RequestBody SaleDTO saleDTO) throws URISyntaxException {
        log.debug("REST request to save Sale : {}", saleDTO);
        if (saleDTO.getId() != null) {
            throw new BadRequestAlertException("A new sale cannot already have an ID", ENTITY_NAME, "idexists");
        }
        SaleDTO result = saleService.save(saleDTO);
        return ResponseEntity
            .created(new URI("/api/sales/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(applicationName, false, ENTITY_NAME, result.getId()))
            .body(result);
    }

    /**
     * {@code PUT  /sales/:id} : Updates an existing sale.
     *
     * @param id the id of the saleDTO to save.
     * @param saleDTO the saleDTO to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated saleDTO,
     * or with status {@code 400 (Bad Request)} if the saleDTO is not valid,
     * or with status {@code 500 (Internal Server Error)} if the saleDTO couldn't be updated.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PutMapping("/sales/{id}")
    public ResponseEntity<SaleDTO> updateSale(@PathVariable(value = "id", required = false) final String id, @RequestBody SaleDTO saleDTO)
        throws URISyntaxException {
        log.debug("REST request to update Sale : {}, {}", id, saleDTO);
        if (saleDTO.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        if (!Objects.equals(id, saleDTO.getId())) {
            throw new BadRequestAlertException("Invalid ID", ENTITY_NAME, "idinvalid");
        }

        if (!saleRepository.existsById(id)) {
            throw new BadRequestAlertException("Entity not found", ENTITY_NAME, "idnotfound");
        }

        SaleDTO result = saleService.update(saleDTO);
        return ResponseEntity
            .ok()
            .headers(HeaderUtil.createEntityUpdateAlert(applicationName, false, ENTITY_NAME, saleDTO.getId()))
            .body(result);
    }

    /**
     * {@code PATCH  /sales/:id} : Partial updates given fields of an existing sale, field will ignore if it is null
     *
     * @param id the id of the saleDTO to save.
     * @param saleDTO the saleDTO to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated saleDTO,
     * or with status {@code 400 (Bad Request)} if the saleDTO is not valid,
     * or with status {@code 404 (Not Found)} if the saleDTO is not found,
     * or with status {@code 500 (Internal Server Error)} if the saleDTO couldn't be updated.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PatchMapping(value = "/sales/{id}", consumes = { "application/json", "application/merge-patch+json" })
    public ResponseEntity<SaleDTO> partialUpdateSale(
        @PathVariable(value = "id", required = false) final String id,
        @RequestBody SaleDTO saleDTO
    ) throws URISyntaxException {
        log.debug("REST request to partial update Sale partially : {}, {}", id, saleDTO);
        if (saleDTO.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        if (!Objects.equals(id, saleDTO.getId())) {
            throw new BadRequestAlertException("Invalid ID", ENTITY_NAME, "idinvalid");
        }

        if (!saleRepository.existsById(id)) {
            throw new BadRequestAlertException("Entity not found", ENTITY_NAME, "idnotfound");
        }

        Optional<SaleDTO> result = saleService.partialUpdate(saleDTO);

        return ResponseUtil.wrapOrNotFound(
            result,
            HeaderUtil.createEntityUpdateAlert(applicationName, false, ENTITY_NAME, saleDTO.getId())
        );
    }

    /**
     * {@code GET  /sales} : get all the sales.
     *
     * @param eagerload flag to eager load entities from relationships (This is applicable for many-to-many).
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the list of sales in body.
     */
    @GetMapping("/sales")
    public List<SaleDTO> getAllSales(@RequestParam(required = false, defaultValue = "false") boolean eagerload) {
        log.debug("REST request to get all Sales");
        return saleService.findAll();
    }

    
    
    
    
    /**
     * {@code GET  /sales/:id} : get the "id" sale.
     *
     * @param id the id of the saleDTO to retrieve.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the saleDTO, or with status {@code 404 (Not Found)}.
     */
    @GetMapping("/sales/{id}")
    public ResponseEntity<SaleDTO> getSale(@PathVariable String id) {
        log.debug("REST request to get Sale : {}", id);
        Optional<SaleDTO> saleDTO = saleService.findOne(id);
        return ResponseUtil.wrapOrNotFound(saleDTO);
    }

    /**
     * {@code DELETE  /sales/:id} : delete the "id" sale.
     *
     * @param id the id of the saleDTO to delete.
     * @return the {@link ResponseEntity} with status {@code 204 (NO_CONTENT)}.
     */
    @DeleteMapping("/sales/{id}")
    public ResponseEntity<Void> deleteSale(@PathVariable String id) {
        log.debug("REST request to delete Sale : {}", id);
        saleService.delete(id);
        return ResponseEntity.noContent().headers(HeaderUtil.createEntityDeletionAlert(applicationName, false, ENTITY_NAME, id)).build();
    }
}
