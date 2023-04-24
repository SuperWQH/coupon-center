package com.smec.coupon.template.controller;

import com.smec.coupon.template.api.beans.PagedCouponTemplateInfo;
import com.smec.coupon.template.api.beans.TemplateSearchParams;
import com.smec.coupon.template.service.CouponTemplateService;
import com.smec.coupon.template.api.beans.CouponTemplateInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Collection;
import java.util.Map;

/**
 * @Author 魏启恒
 * @Description //TODO
 * @Date 2023-04-20  16:26
 */
@RestController
@RequestMapping("/template")
@Slf4j
@Api(value = "消费券模板控制器", description = "消费券模板控制器")
public class CouponTemplateController {

    @Autowired
    CouponTemplateService couponTemplateService;

    // 添加消费券
    @PostMapping("/add")
    @ApiOperation(value = "addCouponTemplate", notes = "添加消费券模板")
    @ApiImplicitParam(value = "优惠券模板信息")
    public CouponTemplateInfo addCouponTemplate(@Valid @RequestBody CouponTemplateInfo couponTemplate) {
        // log.info("进入添加消费券模板的Controller");
        return couponTemplateService.addCouponTemplateService(couponTemplate);
    }

    @GetMapping("/get/{id}")
    @ApiOperation(value = "getTemplateInfoById", notes = "根据消费券模板id获取消费券模板")
    public CouponTemplateInfo getTemplateInfoById(@PathVariable("id") Long id) {
        // log.info("进入根据模板id获取消费券模板的Controller");
        return couponTemplateService.getTemplateInfoById(id);
    }

    @GetMapping("/get/batch")
    @ApiOperation(value = "getBatchTemplateInfoByIds", notes = "根据模板id批量获取消费券模板")
    @ApiImplicitParam(value = "模板id的列表")
    public Map<Long, CouponTemplateInfo> getBatchTemplateInfoByIds(@RequestParam("ids")Collection<Long> ids) {
        // log.info("进入批量获取消费券模板的Controller");
        return couponTemplateService.getBatchTemplateInfoByIds(ids);
    }

    @PostMapping("/search")
    public PagedCouponTemplateInfo searchPagedTemplateInfo(@RequestBody TemplateSearchParams searchParams) {
        // log.info("进入根据查询条件搜索消费券模板的分页信息");
        return couponTemplateService.getPagedTemplateInfoByConditions(searchParams);
    }
}
