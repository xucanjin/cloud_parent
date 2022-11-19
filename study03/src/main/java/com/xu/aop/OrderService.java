package com.xu.aop;

import com.xu.annotation.RecordOperate;
import org.springframework.stereotype.Service;

/**
 * @author xucanjin
 * @date 2022/11/19
 * @description
 */
@Service
public class OrderService {

    @RecordOperate(desc = "保存",convert = SaveOrderConvert.class)
    public Boolean saveOrder(SaveOrder order) {
        System.out.println("SaveOrder  id:" + order.getId());
        return true;
    }

    @RecordOperate(desc = "修改",convert = UpdateOrderConvert.class)
    public Boolean updateOrder(UpdateOrder order) {
        System.out.println("UpdateOrder  id:" + order.getOldId());
        return true;
    }
}
