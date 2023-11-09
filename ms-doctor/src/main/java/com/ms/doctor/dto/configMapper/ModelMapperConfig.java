package com.ms.doctor.dto.configMapper;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ModelMapperConfig {

    @Bean
    public ModelMapper modelMapper() {
        ModelMapper modelMapper = new ModelMapper();

        // Defina a estratégia de correspondência, que determina como os campos são mapeados por nome
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);

        // Adicione outras configurações personalizadas, se necessário

        return modelMapper;
    }
}

