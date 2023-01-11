package com.task.jobTask.service.implementation;

import com.task.jobTask.dto.OrganizationUnitDto;
import com.task.jobTask.model.OrganizationUnit;
import com.task.jobTask.repository.OrganizationUnitRepository;
import com.task.jobTask.service.OrganizationUnitService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Comparator;
import java.util.List;

@Service
public class OrganizationUnitServiceImpl implements OrganizationUnitService {
    private final OrganizationUnitRepository organizationUnitRepository;
    Logger logger = LoggerFactory.getLogger(OrganizationUnitServiceImpl.class);

    public OrganizationUnitServiceImpl(OrganizationUnitRepository organizationUnitRepository) {
        this.organizationUnitRepository = organizationUnitRepository;
    }

    /**
     * Возвращает все организации, ранжированные по уровню подчинённости.
     *
     * @return json-объект класса OrganizationUnitDto со списком организаций.
     */
    @Override
    @Transactional
    public OrganizationUnitDto getOrganizations(boolean showNotActive) {
        List<OrganizationUnit> listOfOrganization;
        if (showNotActive) {
            listOfOrganization = organizationUnitRepository.findAll().stream()
                    .sorted(Comparator.comparing(OrganizationUnit::getLevel)).toList();

        } else {
            listOfOrganization = organizationUnitRepository.findAll().stream()
                    .filter(org -> org.getNot_active_from() == null).sorted(Comparator.comparing(OrganizationUnit::getLevel)).toList();
        }
        logger.info("Метод getOrganizations отработал");
        return new OrganizationUnitDto(0, null, "Организационная структура учреждений", -1, listOfOrganization);
    }
}
