package com.smec.coupon.template.dao.converters;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.smec.coupon.template.dao.dtos.TemplateRuleDto;

import javax.persistence.AttributeConverter;
import java.io.IOException;

/**
 * @Author 魏启恒
 * @Description //TODO
 * @Date 2023-04-20  15:28
 */
public class TemplateRuleDtoConverter implements AttributeConverter<TemplateRuleDto, String> {

    ObjectMapper objectMapper = new ObjectMapper();
    @Override
    public String convertToDatabaseColumn(TemplateRuleDto templateRuleDto) {
        try {
            return objectMapper.writeValueAsString(templateRuleDto);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public TemplateRuleDto convertToEntityAttribute(String s) {
        TemplateRuleDto templateRuleDto = null;
        try {
            templateRuleDto = objectMapper.readValue(s,TemplateRuleDto.class);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return templateRuleDto;
    }
}
