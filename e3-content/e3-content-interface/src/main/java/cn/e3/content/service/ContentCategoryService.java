package cn.e3.content.service;

import cn.e3.common.pojo.EasyUiTreeNode;
import cn.e3.common.utils.E3Result;

import java.util.List;

/**
 * Created by YangYuFan on 2018/4/8.
 */
public interface ContentCategoryService {
    //返回商品类别
    List<EasyUiTreeNode> getContentCatList(long parentId);

    //新增商品类别
    E3Result addContentCat(long parentID,String name);



}
