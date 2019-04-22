package com.bugsir.mvp.sample.okgo;

import com.bugsir.mvp.base.AbsCallback;
import com.bugsir.mvp.base.MVPModel;
import com.bugsir.mvp.sample.bean.BaseBean;
import com.lzy.okgo.OkGo;
import com.lzy.okgo.model.Response;

import java.util.Map;

/**
 *@author: BUG SIR
 *@description: 公用的MODEL，这里只是写一个okgo的调用简单例子，更多拓展自己发挥
 */
public    class OkgoCommonModel<T extends BaseBean> extends MVPModel<T,String>   {

    private Object mTag;
    public void  setTag(Object tag)
    {
        this.mTag=tag;
    }

    public Object getTag()
    {
        return this.mTag;
    }


    @Override
    protected void getRequest(String url, AbsCallback callback) {

    }

    @Override
    protected void getRequest(String url, Map params, AbsCallback callback) {

    }

    @Override
    protected void postRequest(String url, Map params, final AbsCallback callback) {
        OkGo.<T>post(url).tag(getTag()).execute(new com.lzy.okgo.callback.AbsCallback<T>() {
            @Override
            public void onSuccess(Response<T> response) {
                callback.onSuccess(response.body());
            }

            @Override
            public T convertResponse(okhttp3.Response response) throws Throwable {
                /**
                 * 解析T的类型，根据不同的类型执行不同,有时候数据是有加密解密的也在这里处理
                 */

                return null;
            }

            @Override
            public void onError(Response<T> response) {
                super.onError(response);
                callback.onError(response.getException());
            }
        });
    }

    @Override
    public void stopRequest() {
        if (mTag!=null)
        OkGo.getInstance().cancelTag(mTag);
    }
}
