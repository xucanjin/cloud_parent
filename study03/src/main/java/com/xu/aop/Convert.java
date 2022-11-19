package com.xu.aop;

/**
 * @author xucanjin
 * @date 2022/11/19
 * @description
 */
public interface Convert<PARAM> {

    OperateLog convert(PARAM param);
}
