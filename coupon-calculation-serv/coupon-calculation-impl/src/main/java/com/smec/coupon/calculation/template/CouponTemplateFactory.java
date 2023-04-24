package com.smec.coupon.calculation.template;

import com.smec.coupon.calculation.api.beans.ShoppingCart;
import com.smec.coupon.calculation.template.impl.*;
import com.smec.coupon.template.api.enums.CouponType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

/**
 * @Author 魏启恒
 * @Description //TODO
 * @Date 2023-04-24  08:55
 */
@Component
public class CouponTemplateFactory {
    @Autowired
    private MoneyOffTemplate moneyOffTemplate;

    @Autowired
    private DiscountTemplate discountTemplate;

    @Autowired
    private RandomReductionTemplate randomReductionTemplate;

    @Autowired
    private LonelyNightTemplate lonelyNightTemplate;

    @Autowired
    private DummyTemplate dummyTemplate;

    public RuleTemplate getRuleTemplate(ShoppingCart cart) {
        // 如果优惠券为空，那么返回原价，即为dummyTemplate(未知)
        if (CollectionUtils.isEmpty(cart.getCouponInfos())) {
            return dummyTemplate;
        }
        String couponTypeCode = cart.getCouponInfos().get(0).getTemplateInfo().getCode();
        CouponType couponType = CouponType.convert(couponTypeCode);
        switch (couponType) {
            case MONEY_OFF:
                return moneyOffTemplate;
            case DISCOUNT:
                return discountTemplate;
            case RANDOM_DISCOUNT:
                return randomReductionTemplate;
            case LONELY_NIGHT_MONEY_OFF:
                return lonelyNightTemplate;
            default:
                return dummyTemplate;
        }
    }
}
