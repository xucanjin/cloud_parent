package com.xu.test.design.chain;

/**
 * @Author: canjin
 * @Date: 2021/4/11
 * 说明:
 */
public abstract class Handler {

    protected Handler chain;

    public void next(Handler handler){
        this.chain=handler;
    }

    public abstract void doHandler(Member member);
}
