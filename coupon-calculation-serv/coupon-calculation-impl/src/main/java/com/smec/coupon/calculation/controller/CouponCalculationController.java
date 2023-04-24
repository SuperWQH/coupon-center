package com.smec.coupon.calculation.controller;

import com.smec.coupon.calculation.api.beans.ShoppingCart;
import com.smec.coupon.calculation.api.beans.SimulationOrder;
import com.smec.coupon.calculation.api.beans.SimulationResponse;
import com.smec.coupon.calculation.services.CouponCalculationService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author 魏启恒
 * @Description //TODO
 * @Date 2023-04-24  08:47
 */
@RestController
@RequestMapping("/calculation")
@Api(value = "CouponCalculationController", description = "使用优惠券后价格计算的控制器")
public class CouponCalculationController {

    @Autowired
    CouponCalculationService calculationService;

    @PostMapping("/new-price")
    @ApiOperation(value = "calculateOrderNewPrice", notes = "计算订单使用优惠券后的价格")
    public ShoppingCart calculateOrderNewPrice(@RequestBody ShoppingCart cart) {
        return calculationService.calculateOrderNewPrice(cart);
    }

    @PostMapping("/simulation")
    @ApiOperation(value = "simulateOrder", notes = "给出使用各个优惠券后的价格，并给出最便宜的价格")
    public SimulationResponse simulateOrder(@RequestBody SimulationOrder simulationOrder) {
        return calculationService.simulateOrder(simulationOrder);
    }
}
