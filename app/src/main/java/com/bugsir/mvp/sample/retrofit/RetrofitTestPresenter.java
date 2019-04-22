package com.bugsir.mvp.sample.retrofit;

import com.bugsir.mvp.base.MVPPresenter;
import com.bugsir.mvp.sample.ITestView;
import com.bugsir.mvp.sample.bean.TestBean;

/**
 *@author: BUG SIR
 *@description:
 */
public    class RetrofitTestPresenter extends MVPPresenter<ITestView>   {
    RetrofitCommonModel<TestBean> mBaseModel;
    public RetrofitTestPresenter()
    {
        mBaseModel=new RetrofitCommonModel<>();
    }

    @Override
    public void stopRequest() {
        mBaseModel.stopRequest();
    }

    public void getData()
    {
        mBaseModel.postRequest("", null, new RetrofitCallback<TestBean>() {
            @Override
            public void onSuccess(TestBean data) {

            }

            @Override
            public void onFailure(String msg) {

            }
        });
    }
}
