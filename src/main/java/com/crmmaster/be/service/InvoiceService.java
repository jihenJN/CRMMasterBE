package com.crmmaster.be.service;

import com.crmmaster.be.domain.Invoice;
import com.crmmaster.be.domain.Sale;
import com.crmmaster.be.repository.InvoiceRepository;
import com.crmmaster.be.repository.SaleRepository;
import com.crmmaster.be.service.dto.InvoiceDTO;
import com.crmmaster.be.service.dto.SaleDTO;
import com.crmmaster.be.service.mapper.InvoiceMapper;
import com.crmmaster.be.service.mapper.SaleMapper;

import java.io.Console;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

/**
 * Service Implementation for managing {@link Invoice}.
 */
@Service
public class InvoiceService {

    private final Logger log = LoggerFactory.getLogger(InvoiceService.class);

    private final InvoiceRepository invoiceRepository;

    private final InvoiceMapper invoiceMapper;
    
    private final SaleRepository saleRepository;

    private final SaleMapper saleMapper; 
    
    

    public InvoiceService(
    		InvoiceRepository invoiceRepository, 
    		InvoiceMapper invoiceMapper,
    		SaleRepository saleRepository,
    		SaleMapper saleMapper) {
        this.invoiceRepository = invoiceRepository;
        this.invoiceMapper = invoiceMapper;
        this.saleRepository = saleRepository;
        this.saleMapper = saleMapper;
    }

    /**
     * Save a invoice.
     *
     * @param invoiceDTO the entity to save.
     * @return the persisted entity.
     */
    public InvoiceDTO save(InvoiceDTO invoiceDTO) {
        
        Invoice invoice = invoiceMapper.toEntity(invoiceDTO);
        invoice = invoiceRepository.save(invoice);
        
        
        for(int i=0; i<invoiceDTO.getSales().size(); i++) {
        	
        	SaleDTO saleDTO = invoiceDTO.getSales().get(i);
        	saleDTO.setInvoice(invoiceMapper.toDto(invoice));
        	log.debug("Request to save Pfield : {}", saleDTO);
            Sale sale = saleMapper.toEntity(saleDTO);
            sale = saleRepository.save(sale);
        
        	
        }

        InvoiceDTO iMtoDTO = invoiceMapper.toDto(invoice) ;
        
       
        
        return iMtoDTO;
        
        
      
    }

    /**
     * Update a invoice.
     *
     * @param invoiceDTO the entity to save.
     * @return the persisted entity.
     */
    public InvoiceDTO update(InvoiceDTO invoiceDTO) {
        log.debug("Request to update Invoice : {}", invoiceDTO);
        Invoice invoice = invoiceMapper.toEntity(invoiceDTO);
        invoice = invoiceRepository.save(invoice);
        return invoiceMapper.toDto(invoice);
    }

    /**
     * Partially update a invoice.
     *
     * @param invoiceDTO the entity to update partially.
     * @return the persisted entity.
     */
    public Optional<InvoiceDTO> partialUpdate(InvoiceDTO invoiceDTO) {
        log.debug("Request to partially update Invoice : {}", invoiceDTO);

        return invoiceRepository
            .findById(invoiceDTO.getId())
            .map(existingInvoice -> {
                invoiceMapper.partialUpdate(existingInvoice, invoiceDTO);

                return existingInvoice;
            })
            .map(invoiceRepository::save)
            .map(invoiceMapper::toDto);
    }

    /**
     * Get all the invoices.
     *
     * @return the list of entities.
     */
    public List<InvoiceDTO> findAll() {
        log.debug("Request to get all Invoices");
        
      System.out.print("invoice-----------------"+invoiceRepository.findAll());
     
      List<InvoiceDTO> lidto = invoiceRepository.findAll().stream().map(invoiceMapper::toDto).collect(Collectors.toCollection(LinkedList::new));
      
      
      for (int i=0; i < lidto.size(); i++)
      {
      	lidto.get(i).setSales(saleRepository.findAllByInvoice(invoiceMapper.toEntity(lidto.get(i))));
      }
      return lidto;
              
       
    }

    /**
     * Get all the invoices with eager load of many-to-many relationships.
     *
     * @return the list of entities.
     */
    public Page<InvoiceDTO> findAllWithEagerRelationships(Pageable pageable) {
        return invoiceRepository.findAllWithEagerRelationships(pageable).map(invoiceMapper::toDto);
    }

    /**
     * Get one invoice by id.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    public InvoiceDTO findOne(String id) {
        log.debug("Request to get Invoice : {}", id);
        
        InvoiceDTO idto = invoiceRepository.findById(id).map(invoiceMapper::toDto).get();
       
        Invoice i = invoiceRepository.findById(id).get();
        
        idto.setSales(saleRepository.findAllByInvoice(i));
    
        return idto;
    
    
    
    
    
    }

 
 /*******************JN MODIFY DELETE INTO DELETE CASCADE BETWEEN INVOICE AND SALES*******/
    
    /**
     * Delete the invoice by id.
     *
     * @param id the id of the entity.
     */
    public void delete(String id) {
    	log.debug("Request to delete Invoice : {}", id);

        // Find the invoice by ID
        Optional<Invoice> invoiceOptional = invoiceRepository.findById(id);

        if (invoiceOptional.isPresent()) {
            Invoice invoice = invoiceOptional.get();

            // Delete the associated sales
            List<SaleDTO> sales = saleRepository.findAllByInvoice(invoice);
            for (SaleDTO saleDTO : sales) {
                saleRepository.deleteById(saleDTO.getId());
            }

            // Delete the invoice
            invoiceRepository.deleteById(id);
        }
       
    }
}
