package com.bugsir.mvp.sample.retrofit;

import com.bugsir.mvp.base.AbsCallback;
import com.bugsir.mvp.base.MVPModel;
import com.bugsir.mvp.sample.bean.BaseBean;

import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * @author: BUG SIR
 * @description:
 */
public class RetrofitCommonModel2<T extends BaseBean> extends MVPModel<T, Call<T>> {
    @Override
    protected void getRequest(Call<T> request, AbsCallback<T> callback) {

    }

    @Override
    protected void getRequest(Call<T> request, Map params, AbsCallback<T> callback) {

    }

    @Override
    protected void postRequest(Call<T> request, Map params, final AbsCallback<T> callback) {
        request.enqueue(new Callback<T>() {
            @Override
            public void onResponse(Call<T> call, Response<T> response) {
                //这里开始自己写解析，转为对应的实体类T
//                    //解析成功时
                callback.onSuccess(null);
            }

            @Override
            public void onFailure(Call<T> call, Throwable t) {
                callback.onFailure("");
            }
        });

    }


}
