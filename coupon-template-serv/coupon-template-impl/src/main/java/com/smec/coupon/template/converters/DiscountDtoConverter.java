package com.smec.coupon.template.converters;

import com.smec.coupon.template.api.beans.rules.Discount;
import com.smec.coupon.template.api.beans.rules.TemplateRule;
import com.smec.coupon.template.dao.dtos.DiscountDto;
import com.smec.coupon.template.dao.dtos.TemplateRuleDto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

/**
 * @Author 魏启恒
 * @Description //TODO
 * @Date 2023-04-20  18:36
 */
@Mapper(componentModel = "spring")
public interface DiscountDtoConverter {
    DiscountDtoConverter INSTANCES = Mappers.getMapper(DiscountDtoConverter.class);
    DiscountDto discount2DiscountDto(Discount discount);
}
