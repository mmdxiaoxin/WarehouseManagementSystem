package com.yangtze.flooring.wms.ui.notifications;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.yangtze.flooring.wms.model.DataBean;

import java.util.List;

public class NotificationsViewModel extends ViewModel {
    private DataBean dataBean;
    private final MutableLiveData<List<DataBean>> dataBeanList;

    public NotificationsViewModel() {
        dataBeanList = new MutableLiveData<>();
    }

    public LiveData<List<DataBean>> getDataBeanList() {
        return dataBeanList;
    }

    public void setDataBeanList(List<DataBean> dataBeanList) {
        this.dataBeanList.setValue(dataBeanList);
    }
}
