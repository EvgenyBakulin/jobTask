package com.task.jobTask.dto;

import com.task.jobTask.model.OrganizationUnit;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.Objects;

@Getter
@Setter
@AllArgsConstructor
public class OrganizationUnitDto {
    private Integer id;
    private Integer prnt_id;
    private String name;
    private Integer level;
    private List<OrganizationUnit> org_units;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof OrganizationUnitDto that)) return false;
        return Objects.equals(getId(), that.getId()) && Objects.equals(getPrnt_id(), that.getPrnt_id()) && Objects.equals(getName(), that.getName()) && Objects.equals(getLevel(), that.getLevel()) && Objects.equals(getOrg_units(), that.getOrg_units());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getPrnt_id(), getName(), getLevel(), getOrg_units());
    }

    @Override
    public String toString() {
        return "OrganizationUnitDto{" +
                "id=" + id +
                ", prnt_id=" + prnt_id +
                ", name='" + name + '\'' +
                ", level=" + level +
                ", org_units=" + org_units +
                '}';
    }
}
