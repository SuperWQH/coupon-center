package com.smec.coupon.calculation.template.impl;

import com.smec.coupon.calculation.api.beans.ShoppingCart;
import com.smec.coupon.calculation.template.AbstractRuleTemplate;
import com.smec.coupon.calculation.template.RuleTemplate;
import org.springframework.stereotype.Component;

/**
 * @Author 魏启恒
 * @Description //TODO
 * @Date 2023-04-24  08:42
 */
@Component
public class DummyTemplate extends AbstractRuleTemplate implements RuleTemplate {
    @Override
    protected Long calculateNewPrice(Long orderTotalAmount, Long shopTotalAmount, Long quota) {
        return orderTotalAmount;
    }

    @Override
    public ShoppingCart calculate(ShoppingCart cart) {
        Long totalPrice = getTotalPrice(cart.getProducts());
        cart.setCost(totalPrice);
        return cart;
    }
}
