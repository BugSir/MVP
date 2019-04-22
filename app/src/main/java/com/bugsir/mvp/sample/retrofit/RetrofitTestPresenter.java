package com.bugsir.mvp.sample.retrofit;

import com.bugsir.mvp.base.MVPPresenter;
import com.bugsir.mvp.sample.ITestView;
import com.bugsir.mvp.sample.bean.TestBean;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * @author: BUG SIR
 * @description:
 */
public class RetrofitTestPresenter extends MVPPresenter<ITestView> {
    RetrofitCommonModel<TestBean> mBaseModel;
    RetrofitCommonModel2<TestBean> mModel2;

    public RetrofitTestPresenter() {
        mBaseModel = new RetrofitCommonModel<>();
        mModel2 = new RetrofitCommonModel2<>();
    }

    @Override
    public void stopRequest() {
        mBaseModel.stopRequest();
        mModel2.stopRequest();
    }

    public void getData() {
        mBaseModel.postRequest("", null, new RetrofitCallback<TestBean>() {
            @Override
            public void onSuccess(TestBean data) {

            }

            @Override
            public void onFailure(String msg) {

            }
        });

    }

    public void getData2() {
        Retrofit retrofit = new Retrofit.Builder().baseUrl("").addConverterFactory
                (GsonConverterFactory.create()).build();

        NetApiService api = retrofit.create(NetApiService.class);
        //以上都是一些注册配置，懒得写。。。勿怪（一般在application创建的时候已全初始化完了）
        mModel2.postRequest(api.testPost(null), null, new RetrofitCallback<TestBean>() {
            @Override
            public void onSuccess(TestBean data) {

            }

            @Override
            public void onFailure(String msg) {

            }
        });
    }
}
