package com.smec.coupon.customer.dao;

import com.smec.coupon.customer.dao.entities.Coupon;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @Author 魏启恒
 * @Description //TODO
 * @Date 2023-04-24  12:41
 */
public interface CouponDao extends JpaRepository<Coupon, Long> {
    Long countByUserIdAndTemplateId(Long userId, Long templateId);
}
