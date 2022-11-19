package com.xu.aop;

/**
 * @author xucanjin
 * @date 2022/11/19
 * @description
 */
public class UpdateOrderConvert implements Convert<UpdateOrder> {

    @Override
    public OperateLog convert(UpdateOrder order) {
        OperateLog log = new OperateLog();
        log.setOrderId(order.getOldId());
        return log;
    }
}
