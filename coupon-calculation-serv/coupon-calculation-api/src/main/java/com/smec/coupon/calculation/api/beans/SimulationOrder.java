package com.smec.coupon.calculation.api.beans;

import com.smec.coupon.template.api.CouponInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @Author 魏启恒
 * @Description //TODO
 * @Date 2023-04-23  14:11
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel(value = "SimulationOrder", description = "价格试算的订单类")
public class SimulationOrder {

    @ApiModelProperty(value = "试算订单的商品")
    private List<Product> products;

    @ApiModelProperty(value = "优惠券id列表")
    private List<Long> couponIds;

    @ApiModelProperty(value = "优惠券信息列表")
    private List<CouponInfo> couponInfos;

    @ApiModelProperty(value = "用户id")
    private Long userId;
}
