package com.yangtze.flooring.wms.model;

/**
 * 实体类，模拟数据
 */

public class DataBean {

    public static final int PARENT_ITEM = 0;//父布局
    public static final int CHILD_ITEM = 1;//子布局

    private int type;// 显示类型
    private boolean isExpand;// 是否展开
    private DataBean childBean;

    private String ID;
    private String parentLeftTxtName;
    private String parentRightTxtCategory;
    private String parentRightTxtQuantity;
    private String childLeftTxt;
    private String childRightTxt;

    public String getParentLeftTxtName() {
        return parentLeftTxtName;
    }

    public void setParentLeftTxtName(String parentLeftTxtName) {
        this.parentLeftTxtName = parentLeftTxtName;
    }

    public String getChildRightTxt() {
        return childRightTxt;
    }

    public void setChildRightTxt(String childRightTxt) {
        this.childRightTxt = childRightTxt;
    }

    public String getChildLeftTxt() {
        return childLeftTxt;
    }

    public void setChildLeftTxt(String childLeftTxt) {
        this.childLeftTxt = childLeftTxt;
    }

    public String getParentRightTxtCategory() {
        return parentRightTxtCategory;
    }

    public void setParentRightTxtCategory(String parentRightTxtCategory) {
        this.parentRightTxtCategory = parentRightTxtCategory;
    }

    public String getParentRightTxtQuantity() {
        return parentRightTxtQuantity;
    }

    public void setParentRightTxtQuantity(String parentRightTxtQuantity) {
        this.parentRightTxtQuantity = parentRightTxtQuantity;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public boolean isExpand() {
        return isExpand;
    }

    public void setExpand(boolean expand) {
        isExpand = expand;
    }

    public DataBean getChildBean() {
        return childBean;
    }

    public void setChildBean(DataBean childBean) {
        this.childBean = childBean;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }
}
