package com.smec.coupon.calculation.services.impl;

import com.google.common.collect.Lists;
import com.smec.coupon.calculation.api.beans.ShoppingCart;
import com.smec.coupon.calculation.api.beans.SimulationOrder;
import com.smec.coupon.calculation.api.beans.SimulationResponse;
import com.smec.coupon.calculation.services.CouponCalculationService;
import com.smec.coupon.calculation.template.CouponTemplateFactory;
import com.smec.coupon.calculation.template.RuleTemplate;
import com.smec.coupon.template.api.CouponInfo;
import com.smec.coupon.template.api.beans.CouponTemplateInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @Author 魏启恒
 * @Description //TODO
 * @Date 2023-04-24  08:52
 */
@Service
public class CouponCalculationServiceImpl implements CouponCalculationService {

    @Autowired
    private CouponTemplateFactory templateFactory;

    @Override
    public ShoppingCart calculateOrderNewPrice(ShoppingCart cart) {
        // 根据购物车获取规则模板，默认取第一个
        RuleTemplate ruleTemplate = templateFactory.getRuleTemplate(cart);
        // 根据规则，计算新价格
        ShoppingCart newCart = ruleTemplate.calculate(cart);
        return newCart;
    }

    @Override
    public SimulationResponse simulateOrder(SimulationOrder simulationOrder) {
        SimulationResponse simulationResponse = new SimulationResponse();
        Long minOrderPrice = Long.MAX_VALUE;
        // 获取多个优惠券信息
        List<CouponInfo> couponInfos = simulationOrder.getCouponInfos().stream().collect(Collectors.toList());
        // 遍历优惠券，计算每个优惠券所对应的金额
        for (CouponInfo couponInfo : couponInfos) {
            // 根据优惠券信息构建购物车
            ShoppingCart cart = ShoppingCart.builder()
                    .couponId(couponInfo.getId())
                    .couponInfos(Lists.newArrayList(couponInfo))
                    .userId(simulationOrder.getUserId())
                    .products(simulationOrder.getProducts())
                    .build();
            ShoppingCart newCart = templateFactory.getRuleTemplate(cart).calculate(cart);
            Long couponId = couponInfo.getId();
            Long newPrice = newCart.getCost();
            simulationResponse.getCoupon2OrderPrice().put(couponId, newPrice);
            minOrderPrice = Math.min(minOrderPrice, newPrice);
        }
        simulationResponse.setBestCouponId(minOrderPrice);
        return simulationResponse;
    }

}
