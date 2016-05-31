package ua.nure.dss.administration;

import org.lightadmin.api.config.AdministrationConfiguration;
import org.lightadmin.api.config.builder.EntityMetadataConfigurationUnitBuilder;
import org.lightadmin.api.config.builder.PersistentFieldSetConfigurationUnitBuilder;
import org.lightadmin.api.config.unit.EntityMetadataConfigurationUnit;
import org.lightadmin.api.config.unit.FieldSetConfigurationUnit;
import org.lightadmin.api.config.utils.EnumElement;

import ua.nure.dss.domain.Mark;

public class MarkAdministration extends AdministrationConfiguration<Mark> {

    @Override
    public EntityMetadataConfigurationUnit configuration(EntityMetadataConfigurationUnitBuilder configurationBuilder) {
        return configurationBuilder
                .nameField("name")
                .singularName("Mark")
                .pluralName("Marks")
                .build();
    }

    public FieldSetConfigurationUnit formView(final PersistentFieldSetConfigurationUnitBuilder fragmentBuilder) {
        return fragmentBuilder
                .field("criterion").caption("Criterion")
                .field("alternative").caption("Alternative")
                .field("value").caption("Value")
                .field("mark").caption("Mark").enumeration(
                        EnumElement.element(1, "F"),
                        EnumElement.element(2, "D"),
                        EnumElement.element(3, "C"),
                        EnumElement.element(4, "B"),
                        EnumElement.element(5, "A")
                ).build();
    }

}