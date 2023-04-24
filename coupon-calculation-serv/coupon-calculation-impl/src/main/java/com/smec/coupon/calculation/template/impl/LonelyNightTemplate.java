package com.smec.coupon.calculation.template.impl;

import com.smec.coupon.calculation.template.AbstractRuleTemplate;
import com.smec.coupon.calculation.template.RuleTemplate;
import org.springframework.stereotype.Component;

import java.util.Calendar;

/**
 * @Author 魏启恒
 * @Description //TODO
 * @Date 2023-04-24  08:12
 */
@Component
public class LonelyNightTemplate extends AbstractRuleTemplate implements RuleTemplate {
    @Override
    protected Long calculateNewPrice(Long orderTotalAmount, Long shopTotalAmount, Long quota) {
        Calendar calendar = Calendar.getInstance();
        int hour = calendar.get(Calendar.HOUR_OF_DAY);
        if (hour > 23 || hour < 2) {
            quota *= 2;
        }
        Long benefitAmount = Math.min(shopTotalAmount, quota);
        return orderTotalAmount - benefitAmount;
    }
}
