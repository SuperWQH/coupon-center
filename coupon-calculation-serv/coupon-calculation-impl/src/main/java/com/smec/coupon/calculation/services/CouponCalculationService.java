package com.smec.coupon.calculation.services;

import com.smec.coupon.calculation.api.beans.ShoppingCart;
import com.smec.coupon.calculation.api.beans.SimulationOrder;
import com.smec.coupon.calculation.api.beans.SimulationResponse;

/**
 * @Author 魏启恒
 * @Description //TODO
 * @Date 2023-04-24  08:51
 */
public interface CouponCalculationService {
    ShoppingCart calculateOrderNewPrice(ShoppingCart cart);

    SimulationResponse simulateOrder(SimulationOrder simulationOrder);
}
