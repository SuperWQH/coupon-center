package com.smec.coupon.template.dao;

import com.smec.coupon.template.dao.entities.CouponTemplate;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.awt.print.Pageable;
import java.util.List;

/**
 * @Author 魏启恒
 * @Description //TODO
 * @Date 2023-04-20  15:15
 */

public interface CouponTemplateDao extends JpaRepository<CouponTemplate, Long> {

    // 根据商店id去查该商店的所有券
    List<CouponTemplate> findAllByShopId(Long shopId);

    // 根据多个消费券id去查消费券
    // Page<CouponTemplate> findAllByIdIn(List<Long> Ids, Pageable page);

    // 根据shop ID + 可用状态查询店铺有多少券模板
    Integer countByShopIdAndAvailable(Long shopId, Boolean available);

    // 将优惠券设置为不可用
    @Query("update CouponTemplate c set c.available = 0 where c.id = :id")
    int makeCouponUnavailable(@Param("id") Long id);
}
