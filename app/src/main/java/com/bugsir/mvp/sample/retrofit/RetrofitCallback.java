package com.bugsir.mvp.sample.retrofit;
import com.bugsir.mvp.base.AbsCallback;
import com.bugsir.mvp.sample.bean.BaseBean;

/**
 *@author: BUG SIR
 *@description: 实际使用回调的基础类拓展
 */
public  abstract   class RetrofitCallback<T extends BaseBean> extends AbsCallback<T>   {

    @Override
    public void onError(Throwable exception) {
        //这里可以统一请求失败或是其它错误的处理方式不可处理的
        //比如，token过期，这时候要弹出重新登录提示等
    }

    @Override
    public void onFinish() {
    }
}
