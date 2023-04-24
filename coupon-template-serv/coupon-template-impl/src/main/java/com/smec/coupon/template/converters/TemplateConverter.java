package com.smec.coupon.template.converters;

import com.smec.coupon.template.api.beans.CouponTemplateInfo;
import com.smec.coupon.template.api.beans.rules.Discount;
import com.smec.coupon.template.api.beans.rules.TemplateRule;
import com.smec.coupon.template.dao.dtos.CouponTypeDto;
import com.smec.coupon.template.dao.dtos.DiscountDto;
import com.smec.coupon.template.dao.dtos.TemplateRuleDto;
import com.smec.coupon.template.dao.entities.CouponTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * @Author 魏启恒
 * @Description //TODO
 * @Date 2023-04-20  18:50
 */
@Component
public class TemplateConverter {

//    @Resource
//    RuleDtoConverter ruleDtoConverter;
//
//    @Resource
//    RuleConverter ruleConverter;

//    @Resource
//    DiscountDtoConverter discountDtoConverter;
//
//    @Resource
//    DiscountConverter discountConverter;

    public CouponTemplate templateInfo2template(CouponTemplateInfo templateInfo){
         return CouponTemplate.builder()
                    .templateRule(TemplateRuleDto.builder()
                            .discount(DiscountDto.builder()
                                    .quota(templateInfo.getRule().getDiscount().getQuota())
                                    .threshold(templateInfo.getRule().getDiscount().getThreshold())
                                    .build())
                            .limitation(templateInfo.getRule().getLimitation())
                            .deadline(templateInfo.getRule().getDeadline())
                            .build())
                    .shopId(templateInfo.getShopId())
                    .name(templateInfo.getName())
                    .type(CouponTypeDto.convert(templateInfo.getCode()))
                    .available(true)
                    .description(templateInfo.getDes()).build();
    }

    public CouponTemplateInfo template2templateInfo(CouponTemplate template){
        return CouponTemplateInfo.builder()
                .code(template.getType().getCode())
                .id(template.getId())
                .shopId(template.getShopId())
                .name(template.getName())
                .rule(TemplateRule.builder()
                        .discount(Discount.builder()
                                .quota(template.getTemplateRule().getDiscount().getQuota())
                                .threshold(template.getTemplateRule().getDiscount().getThreshold())
                                .build())
                        .limitation(template.getTemplateRule().getLimitation())
                        .deadline(template.getTemplateRule().getDeadline())
                        .build())
                .available(template.getAvailable())
                .des(template.getDescription()).build();
    }
}
