package com.smec.coupon.customer.controller;

import com.smec.coupon.customer.dao.entities.Coupon;
import com.smec.coupon.customer.services.CouponCustomerService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.smec.coupon.customer.api.beans.RequestCoupon;
/**
 * @Author 魏启恒
 * @Description //TODO
 * @Date 2023-04-24  12:59
 */
@RestController
@RequestMapping("/customer")
@Api(value = "CouponCustomerController", description = "顾客的控制器")
public class CouponCustomerController {

    @Autowired
    CouponCustomerService customerService;

    @PostMapping("/request/coupon")
    @ApiOperation(value = "requestCoupon", notes = "顾客申请优惠券")
    public Coupon requestCoupon(@RequestBody RequestCoupon requestCoupon) {
        return customerService.requestCoupon(requestCoupon);
    }

    @DeleteMapping("/delete/{uid}/{cid}")
    public void deleteCoupon(@PathVariable("uid") Long userId, @PathVariable("cid") Long couponId) {
        customerService.deleteCoupon(userId, couponId);
    }
}
