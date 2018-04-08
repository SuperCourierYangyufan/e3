package cn.e3.service;

import cn.e3.common.pojo.EasyUiTreeNode;

import java.util.List;

/**
 * Created by YangYuFan on 2018/4/6.
 */
public interface ItemCatService {
    //查询商品分类-根据easyUi
    List<EasyUiTreeNode> getItemCatList(long parentId);
}
