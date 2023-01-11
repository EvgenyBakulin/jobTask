package com.task.jobTask.controller;

import com.task.jobTask.dto.OrganizationUnitDto;
import com.task.jobTask.service.OrganizationUnitService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/organization")
public class OrganizationUnitController {
    private final OrganizationUnitService organizationUnitService;
    Logger logger = LoggerFactory.getLogger(OrganizationUnitController.class);

    public OrganizationUnitController (OrganizationUnitService organizationUnitService) {
        this.organizationUnitService = organizationUnitService;
    }
    /**
     * Возвращает json-объект класса OrganizationUnitDto со списком организаций.
     */
    @GetMapping("/all")
    @Operation(summary = "Получить список организаций, ранжированный по уровню подчинённости", responses =
            {@ApiResponse(responseCode = "200", description = "Список организаций успешно получен")
            , @ApiResponse(responseCode = "404", description = "Не найдено")})
    public ResponseEntity<OrganizationUnitDto> getOrganizationStructure(@RequestParam(name = "showNotActive", required = false, defaultValue = "false") boolean showNotActive) {
         logger.info("Отрабатывает метод getOrganizationStructure");
         OrganizationUnitDto organizationStructure = organizationUnitService.getOrganizations(showNotActive);
         return ResponseEntity.ok(organizationStructure);
    }

}
