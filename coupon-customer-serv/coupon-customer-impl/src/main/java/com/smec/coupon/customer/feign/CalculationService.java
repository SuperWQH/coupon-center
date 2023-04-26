package com.smec.coupon.customer.feign;

import com.smec.coupon.calculation.api.beans.ShoppingCart;
import io.swagger.annotations.ApiOperation;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * @Author 魏启恒
 * @Description //TODO
 * @Date 2023-04-26  16:19
 */
@FeignClient(value = "coupon-calculation-serv", path = "/calculation")
public interface CalculationService {
    @PostMapping("/new-price")
    ShoppingCart calculateOrderNewPrice(@RequestBody ShoppingCart cart);
}
