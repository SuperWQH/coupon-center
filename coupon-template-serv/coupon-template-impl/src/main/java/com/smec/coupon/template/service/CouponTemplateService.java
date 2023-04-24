package com.smec.coupon.template.service;

import com.smec.coupon.template.api.beans.CouponTemplateInfo;
import com.smec.coupon.template.api.beans.PagedCouponTemplateInfo;
import com.smec.coupon.template.api.beans.TemplateSearchParams;

import java.util.Collection;
import java.util.Map;

/**
 * @Author 魏启恒
 * @Description //TODO
 * @Date 2023-04-20  16:47
 */
public interface CouponTemplateService {

    CouponTemplateInfo addCouponTemplateService(CouponTemplateInfo couponTemplate);

    CouponTemplateInfo getTemplateInfoById(Long id);

    Map<Long, CouponTemplateInfo> getBatchTemplateInfoByIds(Collection<Long> ids);

    PagedCouponTemplateInfo getPagedTemplateInfoByConditions(TemplateSearchParams searchParams);
}
