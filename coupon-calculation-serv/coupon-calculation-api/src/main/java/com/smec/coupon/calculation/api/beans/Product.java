package com.smec.coupon.calculation.api.beans;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ApiModel(value = "Product", description = "购物车中的商品")
public class Product {

    // 你可以试着搭建一个商品中心，用来存储商品信息，逐步完善这个应用
    @ApiModelProperty(value = "商品id")
    private Long productId;

    // 商品的价格
    @ApiModelProperty(value = "商品价格")
    private long price;

    // 商品在购物车里的数量
    @ApiModelProperty("商品的数量")
    private Integer count;

    // 商品销售的门店
    @ApiModelProperty("商户id")
    private Long shopId;

}
