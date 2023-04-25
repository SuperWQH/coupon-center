package com.smec.coupon.template.api;

import com.smec.coupon.template.api.beans.CouponTemplateInfo;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

/**
 * @Author 魏启恒
 * @Description //TODO
 * @Date 2023-04-23  13:51
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@ApiModel(value = "CouponInfo", description = "优惠券信息")
@Builder
public class CouponInfo {

    @ApiModelProperty(value = "优惠券id")
    private Long id;

    @ApiModelProperty(value = "优惠券模板id")
    private Long templateId;

    @ApiModelProperty(value = "用户id")
    private Long userId;

    @ApiModelProperty(value = "商户id")
    private Long shopId;

    @ApiModelProperty(value = "优惠券状态，是否核销")
    private Integer status;

    @ApiModelProperty(value = "优惠券模板信息")
    private CouponTemplateInfo templateInfo;
}
