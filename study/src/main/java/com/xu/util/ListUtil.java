package com.xu.util;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: canjin
 * @Date: 2021/6/18
 * 说明: 将用户平均分配的util
 */
public class ListUtil {

    /**
     * 将list切分
     * @param list 总的list
     * @param pageSize 每一份的数量
     * @param <T>
     * @return
     */
    public static <T> List<List<T>> splitList(List<T> list, int pageSize){
        int listSize=list.size();
        //(100+19)/20=5;  (100+18)/19=6  保证能把list全部分完，不会有遗漏。
        int page = (listSize + (pageSize - 1)) / pageSize;
        List<List<T>> listArray=new ArrayList<>();
        for(int i=0;i<page;i++) {
            List<T> subList = new ArrayList<>();
            for (int j = 0; j < listSize; j++) {
                int pageIndex = ((j + 1) + (pageSize - 1)) / pageSize;
                if (pageIndex == (i + 1)) {
                    subList.add(list.get(j));
                }
                if ((j + 1) == ((i + 1) * pageSize)) {
                    break;
                }
            }
            listArray.add(subList);
        }
        return listArray;
    }
}
