package com.smec.coupon.customer.services.impl;

import com.smec.coupon.customer.api.beans.RequestCoupon;
import com.smec.coupon.customer.api.enums.CouponStatus;
import com.smec.coupon.customer.dao.CouponDao;
import com.smec.coupon.customer.dao.entities.Coupon;
import com.smec.coupon.customer.services.CouponCustomerService;
import com.smec.coupon.template.api.beans.CouponTemplateInfo;
import com.smec.coupon.template.service.CouponTemplateService;
import org.apache.commons.lang3.BooleanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
}
