package com.smec.coupon.customer.services;

import com.smec.coupon.customer.api.beans.RequestCoupon;
import com.smec.coupon.customer.dao.entities.Coupon;

/**
 * @Author 魏启恒
 * @Description //TODO
 * @Date 2023-04-24  13:36
 */
public interface CouponCustomerService {
    Coupon requestCoupon(RequestCoupon requestCoupon);
}
