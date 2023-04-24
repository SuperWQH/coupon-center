package com.smec.coupon.calculation.api.beans;

import com.google.common.collect.Maps;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Map;

/**
 * @Author 魏启恒
 * @Description //TODO
 * @Date 2023-04-23  14:26
 */
@Data
@NoArgsConstructor
@ApiModel(value = "SimulationResponse", description = "订单试算结果")
public class SimulationResponse {

    @ApiModelProperty("最佳的消费券id")
    private Long bestCouponId;

    @ApiModelProperty(value = "消费券对应的订单价格")
    private Map<Long, Long> coupon2OrderPrice = Maps.newHashMap();
}
