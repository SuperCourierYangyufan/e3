package cn.e3.service;

import cn.e3.common.pojo.EasyUIData;
import cn.e3.common.utils.E3Result;
import cn.e3.pojo.TbItem;

/**
 * Created by YangYuFan on 2018/4/4.
 */
public interface ItemService {
    //根据id查询商品
    TbItem getItemById(long itemid);
    //查询所有商品分页
    EasyUIData getItemList(int page,int rows);
    //添加商品
    E3Result addItem(TbItem tbItem,String desc);

}
