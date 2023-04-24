package com.smec.coupon.template.api.beans.rules;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author 魏启恒
 * @Description //优惠券使用规则，包含了两个规则，一是领券规则，包括每个用户可领取的数量和券模板的过期时间；二是券模板的计算规则。
 * @Date 2023-04-20  13:43
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ApiModel(value = "TemplateRule", description = "模板规则")
public class TemplateRule {

    // 可以享受的折扣
    @ApiModelProperty(name = "discount", value = "可以享受的折扣", required = true)
    private Discount discount;

    // 每个人最多可以的领券数量
    @ApiModelProperty(name = "limitation", value = "每个人最多可以的领券数量", required = true)
    private Integer limitation;

    // 过期时间
    @ApiModelProperty(value = "过期时间", required = true)
    private Long deadline;
}
