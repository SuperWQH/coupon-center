package com.smec.coupon.calculation.template.impl;

import com.smec.coupon.calculation.template.AbstractRuleTemplate;
import org.springframework.stereotype.Component;

import java.util.Random;

/**
 * @Author 魏启恒
 * @Description //TODO
 * @Date 2023-04-24  08:19
 */
@Component
public class RandomReductionTemplate extends AbstractRuleTemplate {
    @Override
    protected Long calculateNewPrice(Long orderTotalAmount, Long shopTotalAmount, Long quota) {
        Long maxBenefit = Math.min(shopTotalAmount, quota);
        // 获得一个满减的随机值，因为nextLong没有办法加入参数，所以使用nextInt
        Long reductionAmount = Long.valueOf(new Random().nextInt(maxBenefit.intValue()));
        return orderTotalAmount - reductionAmount;
    }
}
