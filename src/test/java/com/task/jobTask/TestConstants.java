package com.task.jobTask;

import com.task.jobTask.dto.OrganizationUnitDto;
import com.task.jobTask.model.OrganizationUnit;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class TestConstants {
     public static final LocalDate DATE1=null;
     public static final LocalDate DATE2 = LocalDate.parse("2020-02-02");
     public static final Integer ID1 = 1;
     public static final Integer ID2 = 2;
     public static final Integer PRNT_ID1 = 0;
     public static final Integer PRNT_ID2 = 1;
     public static final Integer LEVEL1 = 0;
     public static final Integer LEVEL2 = 1;
     public static final String NAME1 = "Вышестоящая организация";
     public static final String NAME2 = "Нижестоящая организация";
     public static final OrganizationUnit UNIT1 = new OrganizationUnit();
     public static final OrganizationUnit UNIT2 = new OrganizationUnit();
     public static final List<OrganizationUnit> LIST1 = new ArrayList<>();
     public static final List<OrganizationUnit> LIST2 = new ArrayList<>();

     public static final List<OrganizationUnit> LIST3 = new ArrayList<>();



}
