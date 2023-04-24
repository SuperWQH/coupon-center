package com.smec.coupon.template.api.beans;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.Valid;
import java.util.List;

//import javax.validation.constraints.NotNull;

/**
 * 创建优惠券模板
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ApiModel(value = "PagedCouponTemplateInfo", description = "消费券模板的分页信息")
public class PagedCouponTemplateInfo {

    @ApiModelProperty(value = "消费券模板信息的列表")
    public List<CouponTemplateInfo> templates;

    @ApiModelProperty(value = "页码，即第几页")
    public int page;

    @ApiModelProperty(value = "消费券模板的数量")
    public long total;

}
