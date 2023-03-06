package com.crmmaster.be.service.dto;

import static org.assertj.core.api.Assertions.assertThat;

import com.crmmaster.be.web.rest.TestUtil;
import org.junit.jupiter.api.Test;

class SaleDTOTest {

    @Test
    void dtoEqualsVerifier() throws Exception {
        TestUtil.equalsVerifier(SaleDTO.class);
        SaleDTO saleDTO1 = new SaleDTO();
        saleDTO1.setId("id1");
        SaleDTO saleDTO2 = new SaleDTO();
        assertThat(saleDTO1).isNotEqualTo(saleDTO2);
        saleDTO2.setId(saleDTO1.getId());
        assertThat(saleDTO1).isEqualTo(saleDTO2);
        saleDTO2.setId("id2");
        assertThat(saleDTO1).isNotEqualTo(saleDTO2);
        saleDTO1.setId(null);
        assertThat(saleDTO1).isNotEqualTo(saleDTO2);
    }
}
