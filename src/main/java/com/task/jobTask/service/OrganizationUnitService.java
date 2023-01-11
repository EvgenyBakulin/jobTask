package com.task.jobTask.service;

import com.task.jobTask.dto.OrganizationUnitDto;

public interface OrganizationUnitService {
    OrganizationUnitDto getOrganizations(boolean showNotActive);
}
