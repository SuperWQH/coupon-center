package com.smec.coupon.customer.controller;

import com.smec.coupon.calculation.api.beans.ShoppingCart;
import com.smec.coupon.customer.dao.entities.Coupon;
import com.smec.coupon.customer.services.CouponCustomerService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.*;
import com.smec.coupon.customer.api.beans.RequestCoupon;
/**
 * @Author 魏启恒
 * @Description //TODO
 * @Date 2023-04-24  12:59
 */
@RestController
@Slf4j
@RequestMapping("/customer")
@Api(value = "CouponCustomerController", description = "顾客的控制器")
@RefreshScope
public class CouponCustomerController {

    @Autowired
    CouponCustomerService customerService;

    @Value("${disableCouponRequest:false}")
    private Boolean disableCoupon;

    @PostMapping("/request/coupon")
    @ApiOperation(value = "requestCoupon", notes = "顾客申请优惠券")
    public Coupon requestCoupon(@RequestBody RequestCoupon requestCoupon) {
        if (disableCoupon) {
            log.info("暂停领券");
            return null;
        }
        return customerService.requestCoupon(requestCoupon);
    }

    @DeleteMapping("/delete/{uid}/{cid}")
    @ApiOperation(value = "deleteCoupon", notes = "根据用户id和消费券id来逻辑删除优惠券")
    public void deleteCoupon(@PathVariable("uid") Long userId, @PathVariable("cid") Long couponId) {
        customerService.deleteCoupon(userId, couponId);
    }

    @PostMapping("/checkout")
    @ApiOperation(value = "checkout", notes = "下单、结算")
    public ShoppingCart checkout(@RequestBody ShoppingCart cart) {
        ShoppingCart newCart = customerService.checkoutCoupon(cart);
        return newCart;
    }
}
