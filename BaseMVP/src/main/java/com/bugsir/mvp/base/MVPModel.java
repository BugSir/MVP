package com.bugsir.mvp.base;

import java.util.Map;

/**
 *@author: BUG SIR
 *@date: 2019/4/18 11:33
 *@description: 这里写最基础的请求，其它特殊请求在各自的model个别处理
 * T callback回调的最终解析实体类，E请求传入的具体东西，okgo String url，retrofit url或是Call等自行拓展
 */
public abstract class MVPModel<T,E> implements IRequestMgr{

//    enum REQUEST
//    {
//        POST,
//        GET
//    }

    @Override
    public void stopRequest() {
        //这里调用网络工具类进行相关tag取消请求
    }

//    //统一入口或是以下一一拓展都OK
//    protected abstract void request(REQUEST request,String url,Map params,AbsCallback<T>callback);

    // 执行Get网络请求
    protected abstract void getRequest(E request,AbsCallback<T> callback);
    // 执行Get网络请求
    protected abstract void getRequest(E request,Map params,AbsCallback<T> callback);

    // 执行Post网络请求
    protected abstract void postRequest(E request, Map params, AbsCallback<T> callback);
    //更多请求自行拓展
}
