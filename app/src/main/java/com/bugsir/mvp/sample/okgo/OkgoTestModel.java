package com.bugsir.mvp.sample.okgo;

import com.bugsir.mvp.base.AbsCallback;
import com.bugsir.mvp.sample.bean.BaseBean;

import java.util.Map;

/**
 *@author: BUG SIR
 *@date: 2019/4/22 16:02
 *@description: 正常逻辑普通model实现
 */
public    class OkgoTestModel<T extends BaseBean> extends OkgoCommonModel   {

    protected void getTestData(String url, Map params, AbsCallback callback)
    {

    }

}
