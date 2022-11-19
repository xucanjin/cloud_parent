package com.xu.aop;

/**
 * @author xucanjin
 * @date 2022/11/19
 * @description
 */
public class SaveOrderConvert implements Convert<SaveOrder>{

    @Override
    public OperateLog convert(SaveOrder order) {
        OperateLog log = new OperateLog();
        log.setOrderId(order.getId());
        return log;
    }
}
