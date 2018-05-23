package com.oyb.springbootmybatis.syn;


import java.util.concurrent.Future;

/**
 *springboot 异步处理
 */
public interface IAsynService {
    /**
     * 最简单的异步调用，返回值为void
     */
    public void asyncInvokeSimplest() ;

    /**
     * 带参数的异步调用 异步方法可以传入参数
     *
     * @param s
     */
    public void asyncInvokeWithParameter(String s) ;


    /**
     * 异常调用返回Future
     *
     * @param i
     * @return
     */
    public Future<String> asyncInvokeReturnFuture(int i) ;




}
