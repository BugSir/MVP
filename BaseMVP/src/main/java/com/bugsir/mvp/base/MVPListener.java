package com.bugsir.mvp.base;

/**
 * @author: BUG SIR
 * @date: 2019/4/18 11:34
 * @description: 最基础的mvp 回调M层层请求结果.T正常请求成功的数据返回结构
 */
public interface MVPListener<T> {
    /**
     * 数据请求成功
     * @param data 请求到的数据
     */
    void onSuccess(T data);
    /**
     *  请求成功，业务逻辑上返回的错误
     */
    void onFailure(String msg);
    /**
     * 网络请求失败返回各种错误，或是请求成功但是业务逻辑失败统一抛出错误
     */
    void onError(Throwable exception);

    /**
     * 无论请求结果是成功，失败或是抛出异常都会执行此方法，告诉用户所有请求操作已完成
     */
    void onFinish();
}
