package com.smec.coupon.template.dao.converters;

import com.smec.coupon.template.dao.dtos.CouponTypeDto;

import javax.persistence.AttributeConverter;

/**
 * @Author 魏启恒
 * @Description //TODO
 * @Date 2023-04-20  14:59
 */
public class CouponTypeDtoConverter implements AttributeConverter<CouponTypeDto, String> {
    @Override
    public String convertToDatabaseColumn(CouponTypeDto couponTypeDto) {
        return couponTypeDto.getCode();
    }

    @Override
    public CouponTypeDto convertToEntityAttribute(String code) {
        return CouponTypeDto.convert(code);
    }
}
