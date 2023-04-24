package com.smec.coupon.customer.dao.entities;

import com.smec.coupon.customer.api.enums.CouponStatus;
import com.smec.coupon.customer.dao.converters.CouponStatusConverter;
import com.smec.coupon.template.api.beans.CouponTemplateInfo;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.util.Date;

/**
 * @Author 魏启恒
 * @Description //TODO
 * @Date 2023-04-24  12:05
 */
// 使用了lomkob注解自动生成建造者代码和getter、setter
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@EntityListeners(AuditingEntityListener.class)
@Table(name = "coupon")
// 用户领取到的优惠券
public class Coupon {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    // 对应的模板ID - 不使用one to one映射
    @Column(name = "template_id", nullable = false)
    private Long templateId;

    // 拥有这张优惠券的用户的ID
    @Column(name = "user_id", nullable = false)
    private Long userId;

    // 冗余一个shop id方便查找
    @Column(name = "shop_id")
    private Long shopId;

    // 自动生成时间戳
    @CreatedDate
    @Column(name = "created_time", nullable = false)
    private Date createdTime;

    @LastModifiedDate
    @Column(name = "updated_time", nullable = false)
    private Date UpdatedTime;

    // CouponStatusConverter实现了AttributeConverter接口
    // 将数据库value转化为CouponStatus类
    @Column(name = "status", nullable = false)
    @Convert(converter = CouponStatusConverter.class)
    private CouponStatus status;

    @Transient
    private CouponTemplateInfo templateInfo;
}