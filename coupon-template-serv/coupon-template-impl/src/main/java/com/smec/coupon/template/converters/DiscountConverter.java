package com.smec.coupon.template.converters;

import com.smec.coupon.template.api.beans.rules.Discount;
import com.smec.coupon.template.dao.dtos.DiscountDto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

/**
 * @Author 魏启恒
 * @Description //TODO
 * @Date 2023-04-20  18:36
 */
@Mapper(componentModel = "spring")
public interface DiscountConverter {
    DiscountConverter INSTANCES = Mappers.getMapper(DiscountConverter.class);
    Discount discountDto2Discount(DiscountDto discountDto);
}
