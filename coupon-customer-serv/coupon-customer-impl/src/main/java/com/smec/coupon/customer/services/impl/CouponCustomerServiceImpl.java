package com.smec.coupon.customer.services.impl;

import com.google.common.collect.Lists;
import com.smec.coupon.calculation.api.beans.ShoppingCart;
import com.smec.coupon.calculation.services.CouponCalculationService;
import com.smec.coupon.customer.api.beans.RequestCoupon;
import com.smec.coupon.customer.api.enums.CouponStatus;
import com.smec.coupon.customer.converters.CouponConverter;
import com.smec.coupon.customer.dao.CouponDao;
import com.smec.coupon.customer.dao.entities.Coupon;
import com.smec.coupon.customer.services.CouponCustomerService;
import com.smec.coupon.template.api.CouponInfo;
import com.smec.coupon.template.api.beans.CouponTemplateInfo;
import com.smec.coupon.template.service.CouponTemplateService;
import org.apache.commons.lang3.BooleanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.Calendar;

/**
 * @Author 魏启恒
 * @Description //TODO
 * @Date 2023-04-24  13:37
 */
@Service
public class CouponCustomerServiceImpl implements CouponCustomerService {

    @Autowired
    private CouponTemplateService templateService;

    @Autowired
    private CouponCalculationService calculationService;

    @Autowired
    private CouponDao couponDao;

    /**
     * 顾客申请优惠券
     *
     * @param requestCoupon
     * @return
     */
    @Override
    public Coupon requestCoupon(RequestCoupon requestCoupon) {
        CouponTemplateInfo templateInfo = templateService.getTemplateInfoById(requestCoupon.getCouponTemplateId());

        if (templateInfo == null) {
            // todo 如果模板不存在，则报错
        }

        long currentTime = Calendar.getInstance().getTimeInMillis();
        Long expTime = templateInfo.getRule().getDeadline();
        // （过期时间不为空，且此时没有过期）或者（此时模板还可以用）
        if ((expTime != null && currentTime < expTime) || BooleanUtils.isFalse(templateInfo.getAvailable())) {
            // todo 报错
        }
        // 判断用户领券数量是否超过上限
        Long count = couponDao.countByUserIdAndTemplateId(requestCoupon.getUserId(), requestCoupon.getCouponTemplateId());
        if (templateInfo.getRule().getLimitation() <= count) {
            // todo 此时用户领券数量已达上线，报错
        }
        Coupon coupon = Coupon.builder().
                status(CouponStatus.AVAILABLE)
                .shopId(templateInfo.getShopId())
                .templateId(requestCoupon.getCouponTemplateId())
                .userId(requestCoupon.getUserId())
                .build();
        Coupon couponSave = couponDao.save(coupon);
        return couponSave;
    }

    @Override
    public void deleteCoupon(Long userId, Long couponId) {
        Coupon example = Coupon.builder().id(couponId)
                .userId(userId)
                .status(CouponStatus.AVAILABLE)
                .build();
        Coupon coupon = couponDao.findAll(Example.of(example)).stream().findFirst().orElse(null);
        if (coupon == null) {
            // todo 如果找不到优惠券，抛出异常
        }
        coupon.setStatus(CouponStatus.INACTIVE);
        couponDao.save(coupon);
    }

    @Override
    public ShoppingCart checkoutCoupon(ShoppingCart cart) {
        if (CollectionUtils.isEmpty(cart.getProducts())) {
            // todo 如果购物车没有商品，那么就抛出异常
        }
        Coupon coupon = null;
        // 进入if语句块，意味着有优惠券，需要使用
        if (null != cart.getCouponId()) {
            Coupon example = Coupon.builder().id(cart.getCouponId())
                    .userId(cart.getUserId())
                    .status(CouponStatus.AVAILABLE)
                    .build();
            coupon = couponDao.findAll(Example.of(example)).stream().findFirst().orElse(null);
            if (null == coupon) {
                // todo 如果找不到优惠券，那么就抛出异常
            }
            CouponInfo couponInfo = CouponConverter.convert2CouponInfo(coupon);
            couponInfo.setTemplateInfo(templateService.getTemplateInfoById(coupon.getTemplateId()));
            cart.setCouponInfos(Lists.newArrayList(couponInfo));
        }
        ShoppingCart newCart = calculationService.calculateOrderNewPrice(cart);
        if (null != coupon) { // 说明有优惠券
            if (CollectionUtils.isEmpty(newCart.getCouponInfos())) { // 如果couponInfos为空，那么就说明不满足优惠条件
                // todo 抛出异常，不满足优惠条件
            }
            coupon.setStatus(CouponStatus.USED);
            couponDao.save(coupon);
        }
        return cart;
    }
}
