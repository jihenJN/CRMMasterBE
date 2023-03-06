package com.crmmaster.be.service;

import com.crmmaster.be.domain.Sale;
import com.crmmaster.be.repository.SaleRepository;
import com.crmmaster.be.service.dto.SaleDTO;
import com.crmmaster.be.service.mapper.SaleMapper;
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
 * Service Implementation for managing {@link Sale}.
 */
@Service
public class SaleService {

    private final Logger log = LoggerFactory.getLogger(SaleService.class);

    private final SaleRepository saleRepository;

    private final SaleMapper saleMapper;

    public SaleService(SaleRepository saleRepository, SaleMapper saleMapper) {
        this.saleRepository = saleRepository;
        this.saleMapper = saleMapper;
    }

    /**
     * Save a sale.
     *
     * @param saleDTO the entity to save.
     * @return the persisted entity.
     */
    public SaleDTO save(SaleDTO saleDTO) {
        log.debug("Request to save Sale : {}", saleDTO);
        Sale sale = saleMapper.toEntity(saleDTO);
        sale = saleRepository.save(sale);
        return saleMapper.toDto(sale);
    }

    /**
     * Update a sale.
     *
     * @param saleDTO the entity to save.
     * @return the persisted entity.
     */
    public SaleDTO update(SaleDTO saleDTO) {
        log.debug("Request to update Sale : {}", saleDTO);
        Sale sale = saleMapper.toEntity(saleDTO);
        sale = saleRepository.save(sale);
        return saleMapper.toDto(sale);
    }

    /**
     * Partially update a sale.
     *
     * @param saleDTO the entity to update partially.
     * @return the persisted entity.
     */
    public Optional<SaleDTO> partialUpdate(SaleDTO saleDTO) {
        log.debug("Request to partially update Sale : {}", saleDTO);

        return saleRepository
            .findById(saleDTO.getId())
            .map(existingSale -> {
                saleMapper.partialUpdate(existingSale, saleDTO);

                return existingSale;
            })
            .map(saleRepository::save)
            .map(saleMapper::toDto);
    }

    /**
     * Get all the sales.
     *
     * @return the list of entities.
     */
    public List<SaleDTO> findAll() {
        log.debug("Request to get all Sales");
        return saleRepository.findAll().stream().map(saleMapper::toDto).collect(Collectors.toCollection(LinkedList::new));
    }

    /**
     * Get all the sales with eager load of many-to-many relationships.
     *
     * @return the list of entities.
     */
    public Page<SaleDTO> findAllWithEagerRelationships(Pageable pageable) {
        return saleRepository.findAllWithEagerRelationships(pageable).map(saleMapper::toDto);
    }

    /**
     * Get one sale by id.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    public Optional<SaleDTO> findOne(String id) {
        log.debug("Request to get Sale : {}", id);
        return saleRepository.findOneWithEagerRelationships(id).map(saleMapper::toDto);
    }

    /**
     * Delete the sale by id.
     *
     * @param id the id of the entity.
     */
    public void delete(String id) {
        log.debug("Request to delete Sale : {}", id);
        saleRepository.deleteById(id);
    }
}
