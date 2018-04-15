package cn.e3.search.service;

import cn.e3.common.utils.E3Result;

/**
 * Created by YangYuFan on 2018/4/14.
 */
public interface SearchItemService {
    //导入全部商品至solr
    E3Result importAllItems();
}
