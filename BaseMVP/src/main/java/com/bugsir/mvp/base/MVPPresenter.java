package com.bugsir.mvp.base;

import java.lang.ref.WeakReference;

/**
 *@author: BUG SIR
 *@date: 2019/4/18 11:45
 *@description: MVP基础P层
 */
public  abstract   class MVPPresenter<T> implements IRequestMgr {

    /**
     * View层接口的弱引用
     */
    private WeakReference<T> mViewRef;

    /**
     *
     * @param view view层的接口引用
     */
    public void onAttach(T view) {
        mViewRef = new WeakReference<T>(view);
    }

    public T getView() {
        if (isAttach()) {
            return mViewRef.get();
        } else {
            return null;
        }
    }

    public boolean isAttach() {
        return null != mViewRef && null != mViewRef.get();
    }


    /**
     * 释放view引用
     */
    public void onDetach() {
        if (null != mViewRef) {
            mViewRef.clear();
            mViewRef = null;
        }
    }
}
