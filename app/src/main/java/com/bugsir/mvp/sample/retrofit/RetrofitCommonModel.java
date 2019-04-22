package com.bugsir.mvp.sample.retrofit;

import com.bugsir.mvp.base.AbsCallback;
import com.bugsir.mvp.base.MVPModel;
import com.bugsir.mvp.sample.bean.BaseBean;

import java.util.Map;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 *@author: BUG SIR
 *@date: 2019/4/22 15:12
 *@description: 
 */
public    class RetrofitCommonModel<T extends BaseBean> extends MVPModel<T>   {
    @Override
    protected void getRequest(String url, AbsCallback callback) {

    }

    @Override
    protected void getRequest(String url, Map params, AbsCallback callback) {

    }

    @Override
    protected void postRequest(String url, Map params, final AbsCallback callback) {

        Retrofit retrofit=new Retrofit.Builder().baseUrl("").addConverterFactory
                (GsonConverterFactory.create()).build();

        NetApiService api=retrofit.create(NetApiService.class);
        //以上都是一些注册配置，懒得写。。。勿怪（一般在application创建的时候已全初始化完了）
        Call<ResponseBody> body=api.get("",null);
        body.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                try {
                    //这里开始自己写解析，转为对应的实体类T
                    //解析成功时
                    callback.onSuccess("");
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                callback.onFailure("");
            }
        });
    }
}
