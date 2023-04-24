package com.smec.coupon.template.service.impl;

import com.smec.coupon.template.api.beans.PagedCouponTemplateInfo;
import com.smec.coupon.template.api.beans.TemplateSearchParams;
import com.smec.coupon.template.dao.dtos.CouponTypeDto;
import com.smec.coupon.template.service.CouponTemplateService;
import com.smec.coupon.template.converters.TemplateConverter;
import com.smec.coupon.template.api.beans.CouponTemplateInfo;
import com.smec.coupon.template.dao.CouponTemplateDao;
import com.smec.coupon.template.dao.entities.CouponTemplate;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @Author 魏启恒
 * @Description //TODO
 * @Date 2023-04-20  16:50
 */
@Service
@Slf4j
public class CouponTemplateServiceImpl implements CouponTemplateService {

    @Autowired
    CouponTemplateDao couponTemplateDao;

    @Autowired
    TemplateConverter templateConverter;

    @Override
    public CouponTemplateInfo addCouponTemplateService(CouponTemplateInfo request) {
        // log.info("进入添加优惠券模板的Service");
        // 单个门店最多创建100张优惠券
        if (request.getShopId() != null) {
            Integer count = couponTemplateDao.countByShopIdAndAvailable(request.getShopId(), true);
            if (count >= 100) {
                // log.error("优惠券最多只能100张，无法添加");
                throw new UnsupportedOperationException("优惠券最多只能100张，无法添加");
            }
        }
        CouponTemplate template = templateConverter.templateInfo2template(request);
        CouponTemplate saveTemplate = couponTemplateDao.save(template);
        return templateConverter.template2templateInfo(saveTemplate);
    }

    @Override
    public CouponTemplateInfo getTemplateInfoById(Long id) {
        CouponTemplate template = couponTemplateDao.findById(id).orElse(null);
        if (template != null) {
            return templateConverter.template2templateInfo(template);
        }
        // log.error("该消费券模板id有问题");
        return null;
    }

    @Override
    public Map<Long, CouponTemplateInfo> getBatchTemplateInfoByIds(Collection<Long> ids) {
        List<CouponTemplate> batchCouponTemplates = couponTemplateDao.findAllById(ids);
        return batchCouponTemplates.stream().map(template -> templateConverter.template2templateInfo(template))
                .collect(Collectors.toMap(CouponTemplateInfo::getId, couponTemplateInfo -> couponTemplateInfo));
    }

    @Override
    public PagedCouponTemplateInfo getPagedTemplateInfoByConditions(TemplateSearchParams searchParams) {
        CouponTemplate template = CouponTemplate.builder()
                .type(CouponTypeDto.convert(searchParams.getCode()))
                .name(searchParams.getName())
                .shopId(searchParams.getShopId())
                .available(searchParams.getAvailable())
                .build();
        Pageable page = PageRequest.of(searchParams.getPage(), searchParams.getPageSize());
        Page<CouponTemplate> pagedCouponTemplate = couponTemplateDao.findAll(Example.of(template), page);
        List<CouponTemplateInfo> couponTemplateInfoList = pagedCouponTemplate.stream().map(couponTemplate -> templateConverter.template2templateInfo(couponTemplate)).collect(Collectors.toList());
        return PagedCouponTemplateInfo.builder()
                    .templates(couponTemplateInfoList)
                    .page(searchParams.getPage())
                    .total(pagedCouponTemplate.getTotalElements())
                    .build();
    }
}
