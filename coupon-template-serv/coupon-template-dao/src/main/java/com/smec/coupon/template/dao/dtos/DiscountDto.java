package com.smec.coupon.template.dao.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author 魏启恒
 * @Description //定义了使用优惠券的规则
 * @Date 2023-04-20  13:45
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class DiscountDto {

    // 对于满减券 - quota是减掉的钱数，单位是分
    // 对于打折券 - quota是折扣(以100表示原价)，90就是打9折,  95就是95折
    // 对于随机立减券 - quota是最高的随机立减额
    // 对于晚间特别优惠券 - quota是日间优惠额，晚间优惠翻倍
    private Long quota;

    // 订单最低要达到多少钱才能用优惠券，单位为分
    private Long threshold;
}
