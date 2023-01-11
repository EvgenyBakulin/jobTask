package com.task.jobTask;

import com.task.jobTask.dto.OrganizationUnitDto;
import com.task.jobTask.repository.OrganizationUnitRepository;
import com.task.jobTask.service.implementation.OrganizationUnitServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static com.task.jobTask.TestConstants.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class OrganizationUnitServiceTest {
    @Mock
    private OrganizationUnitRepository organizationUnitRepository;
    @InjectMocks
    private OrganizationUnitServiceImpl organizationUnitService;

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

        LIST2.add(UNIT1);

        LIST3.add(UNIT1);
        LIST3.add(UNIT2);
    }

    @Test
    void getOrganisationsCorrectWorkWhenParametrIsFalse() {
        OrganizationUnitDto actualDto = new OrganizationUnitDto(0,null,"Организационная структура учреждений", -1,LIST2);
        when(organizationUnitRepository.findAll()).thenReturn(LIST1);
        OrganizationUnitDto expectedDto = organizationUnitService.getOrganizations(false);
        assertEquals(expectedDto,actualDto);
    }

    @Test
    void getOrganisationsCorrectWorkWhenParametrIsTrue() {
        OrganizationUnitDto actualDto = new OrganizationUnitDto(0,null,"Организационная структура учреждений", -1,LIST3);
        when(organizationUnitRepository.findAll()).thenReturn(LIST1);
        OrganizationUnitDto expectedDto = organizationUnitService.getOrganizations(true);
        assertEquals(expectedDto,actualDto);
    }
}
