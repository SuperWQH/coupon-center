package com.smec.coupon.template.api.beans;

import com.smec.coupon.template.api.beans.rules.TemplateRule;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

/**
 * @Author 魏启恒
 * @Description //优惠券的模板
 * @Date 2023-04-20  13:56
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ApiModel(value = "CouponTemplateInfo", description = "消费券模板信息")
public class CouponTemplateInfo {

    // 优惠券模板id
    @ApiModelProperty(name = "id", value = "消费券模板id")
    private Long id;

    // 优惠券模板名称
    @NotNull
    @ApiModelProperty(name = "name", value = "消费券模板的名称", required = true)
    private String name;

    // 优惠券描述,即CouponType中的description
    @NotNull
    @ApiModelProperty(name = "des", value = "消费券模板的描述", required = true)
    private String des;

    // 优惠券类型编码，即CouponType中的code
    @NotNull
    @ApiModelProperty(name = "code", value = "优惠券类型编码，即CouponType中的code", required = true)
    private String code;

    // 优惠券适用门店,若为空，即为所有都适用
    @ApiModelProperty(name = "shopId", value = "优惠券适用门店,若为空，即为所有都适用", required = true)
    private Long shopId;

    // 优惠券使用规则
    @NotNull
    @ApiModelProperty(name = "rule", value = "优惠券使用规则", required = true)
    private TemplateRule rule;

    @ApiModelProperty(name = "available", value = "消费券模板是否可用", required = true)
    private Boolean available;
}
