package com.crmmaster.be.repository;

import com.crmmaster.be.domain.Invoice;
import com.crmmaster.be.domain.Sale;
import com.crmmaster.be.service.dto.SaleDTO;

import java.util.List;
import java.util.Optional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

/**
 * Spring Data MongoDB repository for the Sale entity.
 */
@Repository
public interface SaleRepository extends MongoRepository<Sale, String> {
   @Query("{}")
    Page<Sale> findAllWithEagerRelationships(Pageable pageable);

    @Query("{}")
    List<Sale> findAllWithEagerRelationships();

    @Query("{'id': ?0}")
    Optional<Sale> findOneWithEagerRelationships(String id);
    
    List<SaleDTO>findAllByInvoice(Invoice invoice);
    
}
