package com.smec.coupon.template.dao.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.stream.Stream;

/**
 * @Author 魏启恒
 * @Description //TODO
 * @Date 2023-04-20  13:10
 */
@AllArgsConstructor
@Getter
public enum CouponTypeDto {

    UNKNOWN("未知", "0"),
    MONEY_OFF("满减券", "1"),
    DISCOUNT("打折券", "2"),
    RANDOM_DISCOUNT("随机减券", "3"),
    LONELY_NIGHT_MONEY_OFF("晚间双倍优惠券", "4");

    // 描述
    private String description;
    // 编码
    private String code;

    @Override
    public String toString() {
        return "CouponType{" +
                "description='" + description + '\'' +
                ", code='" + code + '\'' +
                '}';
    }

    public static CouponTypeDto convert(String code) {
        return Stream.of(values())
                .filter(couponType->couponType.code.equalsIgnoreCase(code))
                .findFirst()
                .orElse(UNKNOWN);
    }
}

