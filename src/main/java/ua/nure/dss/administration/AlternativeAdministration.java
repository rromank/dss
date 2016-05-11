package ua.nure.dss.administration;

import org.lightadmin.api.config.AdministrationConfiguration;
import org.lightadmin.api.config.builder.EntityMetadataConfigurationUnitBuilder;
import org.lightadmin.api.config.unit.EntityMetadataConfigurationUnit;
import ua.nure.dss.domain.Alternative;

public class AlternativeAdministration extends AdministrationConfiguration<Alternative> {

    @Override
    public EntityMetadataConfigurationUnit configuration(EntityMetadataConfigurationUnitBuilder configurationBuilder) {
        return configurationBuilder
                .nameField("name")
                .singularName("Alternative")
                .pluralName("Alternatives")
                .build();
    }

}