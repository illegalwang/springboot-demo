package com.wj.bean;

import com.wj.bean.model.IndexGroupChild;
import com.wj.bean.model.IndexWebGroup;

import java.util.List;

/**
 * Created by wisi on 2018/12/21.
 */
public class WebGroup extends IndexWebGroup{
    private List<IndexGroupChild> children;

    public List<IndexGroupChild> getChildren() {
        return children;
    }

    public void setChildren(List<IndexGroupChild> children) {
        this.children = children;
    }
}
