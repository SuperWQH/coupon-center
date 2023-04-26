package com.smec.coupon.customer.feign;

import com.smec.coupon.template.api.beans.CouponTemplateInfo;
import io.swagger.annotations.ApiOperation;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @Author 魏启恒
 * @Description //TODO
 * @Date 2023-04-26  16:12
 */
@FeignClient(value = "coupon-template-serv", path = "/template")
public interface TemplateService {

    // 读取优惠券
    @GetMapping("/get/{id}")
    CouponTemplateInfo getTemplateInfoById(@PathVariable("id") Long id);
}
