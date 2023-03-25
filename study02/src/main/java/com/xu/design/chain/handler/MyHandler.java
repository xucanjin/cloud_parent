package com.xu.design.chain.handler;

import com.xu.design.chain.Member;

/**
 * @author xucanjin
 * @date 2023/03/25
 * @description 责任链模式
 */
public abstract class MyHandler<T> {

    protected MyHandler chain;

    public void next(MyHandler handler){
        this.chain = handler;
    }

    public abstract void doHandler(Member member);

    public static class Builder<T> {
        private MyHandler<T> head;

        private MyHandler<T> tail;

        public Builder<T> addBuilder(MyHandler<T> handler) {
            if (this.head == null) {
                this.head = this.tail = handler;
                return this;
            }
            this.tail.next(handler);
            this.tail = handler;
            return this;
        }

        public MyHandler<T> build() {
            return this.head;
        }
    }
}
