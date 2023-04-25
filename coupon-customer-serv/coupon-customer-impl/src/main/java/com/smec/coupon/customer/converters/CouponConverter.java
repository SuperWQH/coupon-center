package com.smec.coupon.customer.converters;

import com.smec.coupon.customer.dao.entities.Coupon;
import com.smec.coupon.template.api.CouponInfo;

/**
 * @Author 魏启恒
 * @Description //TODO
 * @Date 2023-04-24  17:03
 */
public class CouponConverter {
    public static CouponInfo convert2CouponInfo(Coupon coupon) {
        return CouponInfo.builder()
                .id(coupon.getId())
                .status(coupon.getStatus().getCode())
                .templateId(coupon.getTemplateId())
                .shopId(coupon.getShopId())
                .userId(coupon.getUserId())
                .build();
    }
}
