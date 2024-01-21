package com.yangtze.flooring.wms.ui.notifications.adapter;


import com.yangtze.flooring.wms.ui.notifications.model.DataBean;

/**
 * 父布局Item点击监听接口
 */

public interface ItemClickListener {
    /**
     * 展开子Item
     * @param bean
     */
    void onExpandChildren(DataBean bean);

    /**
     * 隐藏子Item
     * @param bean
     */
    void onHideChildren(DataBean bean);
}
