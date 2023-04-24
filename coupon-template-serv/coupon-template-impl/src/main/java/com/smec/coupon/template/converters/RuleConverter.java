package com.smec.coupon.template.converters;

import com.smec.coupon.template.api.beans.rules.TemplateRule;
import com.smec.coupon.template.dao.dtos.TemplateRuleDto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;


/**
 * @Author 魏启恒
 * @Description //TODO
 * @Date 2023-04-20  19:02
 */
@Mapper(componentModel = "spring")
public interface RuleConverter {
    RuleConverter INSTANCES = Mappers.getMapper(RuleConverter.class);
    TemplateRule ruleDto2Rule(TemplateRuleDto ruleDto);
}
