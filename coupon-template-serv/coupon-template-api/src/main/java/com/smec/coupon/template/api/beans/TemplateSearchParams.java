package com.smec.coupon.template.api.beans;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

//import javax.validation.constraints.NotNull;

/**
 * 创建优惠券模板
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ApiModel(value = "TemplateSearchParams", description = "消费券模板搜索参数")
public class TemplateSearchParams {

    @ApiModelProperty(value = "消费券模板id")
    private Long id;

    @ApiModelProperty(value = "消费券模板的名称")
    private String name;

    @ApiModelProperty(value = "消费券模板的编码")
    private String code;

    @ApiModelProperty(value = "商户id")
    private Long shopId;

    @ApiModelProperty(value = "该模板是否可以使用")
    private Boolean available;

    @ApiModelProperty(value = "页码，即第几页")
    private int page;

    @ApiModelProperty(value = "页大小，即页中有几条记录")
    private int pageSize;

}
