package com.smec.coupon.customer.api.beans;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

/**
 * @Author 魏启恒
 * @Description //TODO
 * @Date 2023-04-24  13:24
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@ApiModel(value = "RequestCoupon", description = "申请优惠券")
public class RequestCoupon {
    // 用户领券
    @NotNull
    @ApiModelProperty("用户id")
    private Long userId;

    // 券模板ID
    @NotNull
    @ApiModelProperty("优惠券模板id")
    private Long couponTemplateId;
}
