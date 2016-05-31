package ua.nure.dss.administration;

import org.lightadmin.api.config.AdministrationConfiguration;
import org.lightadmin.api.config.builder.EntityMetadataConfigurationUnitBuilder;
import org.lightadmin.api.config.builder.PersistentFieldSetConfigurationUnitBuilder;
import org.lightadmin.api.config.unit.EntityMetadataConfigurationUnit;
import org.lightadmin.api.config.unit.FieldSetConfigurationUnit;
import org.lightadmin.api.config.utils.EnumElement;

import ua.nure.dss.domain.Criterion;

public class CriterionAdministration extends AdministrationConfiguration<Criterion> {

    @Override
    public EntityMetadataConfigurationUnit configuration(EntityMetadataConfigurationUnitBuilder configurationBuilder) {
        return configurationBuilder
                .nameField("name")
                .singularName("Criterion")
                .pluralName("Criterions")
                .build();
    }

    public FieldSetConfigurationUnit formView(final PersistentFieldSetConfigurationUnitBuilder fragmentBuilder) {
        return fragmentBuilder
                .field("name").caption("Name")
                .field("range").caption("Range")
                .field("weight").caption("Weight")
                .field("unit").caption("Unit")
                .field("scaleType").caption("Scale type")
                .field("criterionType").caption("Criterion type").enumeration(
                        EnumElement.element("QUALITATIVE", "Qualitative"),
                        EnumElement.element("QUANTITATIVE", "Quantitative")
                )
                .field("criterionOptimType").caption("Optimal type").enumeration(
                        EnumElement.element("MIN", "Minimum"),
                        EnumElement.element("MAX", "Maximum")
                ).build();
    }

}