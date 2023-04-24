package com.smec.coupon.calculation.api.beans;

import com.smec.coupon.template.api.CouponInfo;
import com.smec.coupon.template.api.beans.CouponTemplateInfo;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

import java.util.List;

/**
 * @Author 魏启恒
 * @Description //TODO
 * @Date 2023-04-23  13:33
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@ApiModel("购物车")
@Builder
public class ShoppingCart {

    @ApiModelProperty(value = "商品列表")
    private List<Product> products;

    @ApiModelProperty(value = "优惠券id")
    private Long couponId;

    @ApiModelProperty(value = "购物车总共花费")
    private Long cost;

    @ApiModelProperty(value = "优惠券信息列表")
    private List<CouponInfo> couponInfos;

    @ApiModelProperty("用户id")
    private Long userId;
}
