package com.barclaycardus.reports.ccd.bindings;

import com.barclaycardus.reports.ccd.config.ReportServiceConfigHolder;
import org.codehaus.jackson.map.DeserializationConfig;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.annotate.JsonSerialize;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.File;
import java.io.IOException;

/**
 * Created by abhishek on 18/01/16.
 */
@Configuration
public class ServiceBindings {

//    @Bean
//    public static File jerseyServiceConfigDir() {
//        return new File(System.getProperty("org.abhishek.service.config"));
//    }

//    @Bean
//    public File jerseyServiceConfigFile() {
//        return new File(jerseyServiceConfigDir(), "jersey-service-config.json");
//    }

    @Bean
    public ObjectMapper objectMapper() {
        ObjectMapper objectMapper = new ObjectMapper();

        // Enable DeserializationFeature
        objectMapper.enable(DeserializationConfig.Feature.ACCEPT_EMPTY_STRING_AS_NULL_OBJECT);
        objectMapper.enable(DeserializationConfig.Feature.ACCEPT_SINGLE_VALUE_AS_ARRAY);

        // Disable DeserializationFeature
        objectMapper.disable(DeserializationConfig.Feature.FAIL_ON_NULL_FOR_PRIMITIVES);
        objectMapper.disable(DeserializationConfig.Feature.FAIL_ON_UNKNOWN_PROPERTIES);

        objectMapper.setSerializationInclusion(JsonSerialize.Inclusion.NON_NULL);

        return objectMapper;
    }

    @Bean(initMethod = "init")
    public ReportServiceConfigHolder reportServiceConfigHolder() throws IOException {
        ReportServiceConfigHolder reportServiceConfigHolder = new ReportServiceConfigHolder();
        reportServiceConfigHolder.setObjectMapper(objectMapper());
//        reportServiceConfigHolder.setServiceConfigFile(jerseyServiceConfigFile().getAbsolutePath());
        return reportServiceConfigHolder;
    }

}
