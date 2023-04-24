package com.smec.coupon.template.dao.entities;

import com.smec.coupon.template.dao.converters.CouponTypeDtoConverter;
import com.smec.coupon.template.dao.converters.TemplateRuleDtoConverter;
import com.smec.coupon.template.dao.dtos.CouponTypeDto;
import com.smec.coupon.template.dao.dtos.TemplateRuleDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * @Author 魏启恒
 * @Description //TODO
 * @Date 2023-04-20  14:34
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
@EntityListeners(AuditingEntityListener.class)
@Table(name = "coupon_template")
public class CouponTemplate implements Serializable {

    // 优惠券模板id
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    // 是否可用
    @Column(name = "available", nullable = false)
    private Boolean available;

    // 优惠券的名称
    @Column(name = "name", nullable = false)
    private String name;

    // 优惠券的描述
    @Column(name = "description", nullable = false)
    private String description;

    // 适用门店-如果为空，则为全店满减券
    @Column(name = "shop_id")
    private Long shopId;

    // 优惠券类型
    @Column(name = "type", nullable = false)
    @Convert(converter = CouponTypeDtoConverter.class)
    private CouponTypeDto type;

    // 创建时间，通过@CreateDate注解自动填值（需要配合@JpaAuditing注解在启动类上生效）
    @CreatedDate
    @Column(name = "created_time", nullable = false)
    private Date createdTime;

    // 更新时间
    @LastModifiedDate
    @Column(name = "updated_time", nullable = false)
    private Date updatedTime;

    // 优惠券核算规则，平铺成JSON字段
    @Column(name = "template_rule", nullable = false)
    @Convert(converter = TemplateRuleDtoConverter.class)
    private TemplateRuleDto templateRule;
}
