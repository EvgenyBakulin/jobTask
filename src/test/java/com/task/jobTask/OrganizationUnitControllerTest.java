package com.task.jobTask;

import com.task.jobTask.repository.OrganizationUnitRepository;
import org.hamcrest.core.IsNull;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import static com.task.jobTask.TestConstants.*;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class OrganizationUnitControllerTest {
    @Autowired
    private MockMvc mockMvc;
    @MockBean
    private OrganizationUnitRepository organizationUnitRepository;

    @BeforeEach
    public void setUp() {
        UNIT1.setUnit_id(ID1);
        UNIT1.setPrnt_unit_id(PRNT_ID1);
        UNIT1.setLevel(LEVEL1);
        UNIT1.setUnit_name(NAME1);
        UNIT1.setNot_active_from(DATE1);

        UNIT2.setUnit_id(ID2);
        UNIT2.setPrnt_unit_id(PRNT_ID2);
        UNIT2.setLevel(LEVEL2);
        UNIT2.setUnit_name(NAME2);
        UNIT2.setNot_active_from(DATE2);

        LIST1.add(UNIT1);
        LIST1.add(UNIT2);

    }

   @Test
   void getOrganizationStructureCorrectWorkWhenParametrIsFalse() throws Exception {
       when(organizationUnitRepository.findAll()).thenReturn(LIST1);
       mockMvc.perform(get("http://localhost:8080/organization/all"))
               .andExpect(status().isOk())
               .andExpect(jsonPath("$.id").value(0))
               .andExpect(jsonPath("$.prnt_id").value(IsNull.nullValue()))
               .andExpect(jsonPath("$.name").value("Организационная структура учреждений"))
               .andExpect(jsonPath("$.level").value(-1))
               .andExpect(jsonPath("$.org_units[0].unit_id").value(UNIT1.getUnit_id()))
               .andExpect(jsonPath("$.org_units[0].prnt_unit_id").value(UNIT1.getPrnt_unit_id()))
               .andExpect(jsonPath("$.org_units[0].unit_name").value(UNIT1.getUnit_name()))
               .andExpect(jsonPath("$.org_units[0].level").value(UNIT1.getLevel()))
               .andExpect(jsonPath("$.org_units[0].not_active_from").value(UNIT1.getNot_active_from()));
   }

    @Test
    void getOrganizationStructureCorrectWorkWhenParametrIsTrue() throws Exception {
        when(organizationUnitRepository.findAll()).thenReturn(LIST1);
        mockMvc.perform(get("http://localhost:8080/organization/all?showNotActive=true"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(0))
                .andExpect(jsonPath("$.prnt_id").value(IsNull.nullValue()))
                .andExpect(jsonPath("$.name").value("Организационная структура учреждений"))
                .andExpect(jsonPath("$.level").value(-1))
                .andExpect(jsonPath("$.org_units[0].unit_id").value(UNIT1.getUnit_id()))
                .andExpect(jsonPath("$.org_units[0].prnt_unit_id").value(UNIT1.getPrnt_unit_id()))
                .andExpect(jsonPath("$.org_units[0].unit_name").value(UNIT1.getUnit_name()))
                .andExpect(jsonPath("$.org_units[0].level").value(UNIT1.getLevel()))
                .andExpect(jsonPath("$.org_units[0].not_active_from").value(UNIT1.getNot_active_from()))
                .andExpect(jsonPath("$.org_units[1].unit_id").value(UNIT2.getUnit_id()))
                .andExpect(jsonPath("$.org_units[1].prnt_unit_id").value(UNIT2.getPrnt_unit_id()))
                .andExpect(jsonPath("$.org_units[1].unit_name").value(UNIT2.getUnit_name()))
                .andExpect(jsonPath("$.org_units[1].level").value(UNIT2.getLevel()))
                .andExpect(jsonPath("$.org_units[1].not_active_from").value(UNIT2.getNot_active_from().toString()));
    }
}
