package com.bugsir.mvp.sample.okgo;

import com.bugsir.mvp.base.MVPPresenter;
import com.bugsir.mvp.sample.ITestView;
import com.bugsir.mvp.sample.bean.TestBean;

/**
 *@author: BUG SIR
 *@description:
 */
public    class OkgoTestPresenter extends MVPPresenter<ITestView>   {
    OkgoCommonModel<TestBean> okGoBaseModel;
    OkgoTestModel<TestBean> testModel;
    public OkgoTestPresenter()
    {
        okGoBaseModel=new OkgoCommonModel<>();
        okGoBaseModel.setTag(OkgoTestPresenter.class);
        testModel=new OkgoTestModel<>();
        testModel.setTag(OkgoTestModel.class);
    }

    @Override
    public void stopRequest() {
        okGoBaseModel.stopRequest();
    }

    public void getData()
    {
        okGoBaseModel.getRequest("", new OkgoCallback<TestBean>() {
            @Override
            public void onSuccess(TestBean data) {
                if (isAttach())
                {
                    getView().requestSuccess();
                }
            }

            @Override
            public void onFailure(String msg) {

            }
        });

        testModel.getTestData("", null, new OkgoCallback<TestBean>() {
            @Override
            public void onSuccess(TestBean data) {

            }

            @Override
            public void onFailure(String msg) {

            }
        });
    }
}
