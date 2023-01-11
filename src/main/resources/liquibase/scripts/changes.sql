-- liquibase formatted sql

-- changeset bakulin:1
ALTER TABLE organization_unit ALTER COLUMN level SET NOT NULL;
ALTER TABLE organization_unit ALTER COLUMN unit_name SET NOT NULL;

-- changeset bakulin:5
ALTER TABLE organization_unit ALTER COLUMN not_active_from SET DEFAULT NULL;
ALTER TABLE organization_unit ALTER COLUMN prnt_unit_id SET DEFAULT NULL;

-- changeset bakulin:7
ALTER TABLE organization_unit ADD CONSTRAINT fk_org_unit_parent FOREIGN KEY (prnt_unit_id) REFERENCES organization_unit (unit_id);



