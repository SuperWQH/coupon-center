package com.smec.coupon.calculation.template.impl;

import com.smec.coupon.calculation.template.AbstractRuleTemplate;
import com.smec.coupon.calculation.template.RuleTemplate;
import org.springframework.stereotype.Component;

/**
 * @Author 魏启恒
 * @Description //TODO
 * @Date 2023-04-24  08:09
 */
@Component
public class DiscountTemplate extends AbstractRuleTemplate implements RuleTemplate {
    @Override
    protected Long calculateNewPrice(Long orderTotalAmount, Long shopTotalAmount, Long quota) {
        // benefitAmount: 扣减的价格
        double newPrice = shopTotalAmount * (quota.doubleValue() / 100);
        return convertToDecimal(newPrice);
    }
}
