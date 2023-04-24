package com.smec.coupon.template.dao.dtos;

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
public class TemplateRuleDto {

    // 可以享受的折扣
    private DiscountDto discount;

    // 每个人最多可以的领券数量
    private Integer limitation;

    // 过期时间
    private Long deadline;
}
