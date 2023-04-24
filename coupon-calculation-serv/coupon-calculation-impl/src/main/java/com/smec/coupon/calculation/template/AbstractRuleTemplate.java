package com.smec.coupon.calculation.template;

import com.smec.coupon.calculation.api.beans.Product;
import com.smec.coupon.calculation.api.beans.ShoppingCart;
import com.smec.coupon.template.api.beans.CouponTemplateInfo;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @Author 魏启恒
 * @Description //TODO
 * @Date 2023-04-23  17:01
 */
public abstract class AbstractRuleTemplate implements RuleTemplate {

    @Override
    public ShoppingCart calculate(ShoppingCart cart) {
        // 获取订单总价
        Long orderTotalAmount = getTotalPrice(cart.getProducts());
        // 每个商户的总金额
        Map<Long, Long> sumAmount = getTotalPriceGroupByShop(cart.getProducts());
        // 优惠券模板
        CouponTemplateInfo templateInfo = cart.getCouponInfos().get(0).getTemplateInfo();
        // 最低消费限制
        Long threshold = templateInfo.getRule().getDiscount().getThreshold();
        // 折扣，优惠比例或者打折比例
        Long quota = templateInfo.getRule().getDiscount().getQuota();
        // 商户id
        Long shopId = templateInfo.getShopId();
        // 商户的总金额，接下来要计算折扣的金额
        Long shopTotalAmount = (shopId == null) ? orderTotalAmount : sumAmount.get(shopId);
        // 如果计算折扣的金额小于最低消费限制，那么就不打折
        if (shopTotalAmount == null || shopTotalAmount < threshold) {
            // 不打折，即原价
            cart.setCost(orderTotalAmount);
            // 优惠券不能用
            cart.setCouponInfos(Collections.emptyList());
            return cart;
        }
        // 子类中计算新的价格
        Long newCost = calculateNewPrice(orderTotalAmount, shopTotalAmount, quota);
        // 订单价格不能小于最低价格
        newCost = Math.max(newCost, minCost());
        cart.setCost(newCost);
        return cart;
    }

    // 每个订单最少一分钱
    protected long minCost() {
        return 1L;
    }

    protected abstract Long calculateNewPrice(Long orderTotalAmount, Long shopTotalAmount, Long quota);

    protected Map<Long, Long> getTotalPriceGroupByShop(List<Product> products) {
        return products.stream().collect(Collectors.groupingBy(Product::getShopId, Collectors.summingLong(product -> product.getPrice() * product.getCount())));
    }

    protected Long getTotalPrice(List<Product> products) {
        return products.stream().mapToLong(product -> product.getPrice() * product.getCount()).sum();
    }

    protected Long convertToDecimal(Double value) {
        return new Long(new BigDecimal(value).setScale(0, RoundingMode.HALF_UP).longValue());
    }
}
