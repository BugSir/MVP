package com.bugsir.mvp.base;

/**
 * @author: BUG SIR
 * @date: 2019/4/22 09:37
 * @description: 基础的View接口
 */
public interface IBaseVIew {

    /**
     * @param loadingType 用于多种loading加载模式的参数加载。比如：阻塞加载，非阻塞加载，dialog模式等
     */
    void showLoading(Object loadingType);
    void hideLoading();
}
