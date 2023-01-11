package com.task.jobTask.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.Objects;

@Entity
@Setter
@Getter
public class OrganizationUnit {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer unit_id;
    private Integer prnt_unit_id;
    private String unit_name;
    private Integer level;
    private LocalDate not_active_from;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof OrganizationUnit that)) return false;
        return Objects.equals(getUnit_id(), that.getUnit_id()) && Objects.equals(getPrnt_unit_id(), that.getPrnt_unit_id()) && Objects.equals(getUnit_name(), that.getUnit_name()) && Objects.equals(getLevel(), that.getLevel()) && Objects.equals(getNot_active_from(), that.getNot_active_from());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getUnit_id(), getPrnt_unit_id(), getUnit_name(), getLevel(), getNot_active_from());
    }

    @Override
    public String toString() {
        return "OrganisationUnit{" +
                "id=" + unit_id +
                ", prnt_id=" + prnt_unit_id +
                ", name='" + unit_name + '\'' +
                ", level=" + level +
                ", not_active_from=" + not_active_from +
                '}';
    }
}
