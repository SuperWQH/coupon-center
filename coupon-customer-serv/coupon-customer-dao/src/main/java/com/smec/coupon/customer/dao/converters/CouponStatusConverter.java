package com.smec.coupon.customer.dao.converters;

import com.smec.coupon.customer.api.enums.CouponStatus;
import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

/**
 * @Author 魏启恒
 * @Description //TODO
 * @Date 2023-04-24  12:33
 */
@Converter
public class CouponStatusConverter implements AttributeConverter<CouponStatus, Integer> {
    @Override
    public Integer convertToDatabaseColumn(CouponStatus couponStatus) {
        return couponStatus.getCode();
    }

    @Override
    public CouponStatus convertToEntityAttribute(Integer code) {
        return CouponStatus.convert(code);
    }
}
