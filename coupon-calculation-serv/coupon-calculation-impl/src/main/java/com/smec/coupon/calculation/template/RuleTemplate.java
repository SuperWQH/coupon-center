package com.smec.coupon.calculation.template;

import com.smec.coupon.calculation.api.beans.ShoppingCart;

/**
 * @Author 魏启恒
 * @Description //TODO
 * @Date 2023-04-23  16:59
 */
public interface RuleTemplate {
    // 计算优惠券
    ShoppingCart calculate(ShoppingCart cart);
}
