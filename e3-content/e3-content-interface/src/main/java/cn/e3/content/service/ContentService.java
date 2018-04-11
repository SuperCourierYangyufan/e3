package cn.e3.content.service;

import cn.e3.common.utils.E3Result;
import cn.e3.pojo.TbContent;

import java.util.List;

/**
 * Created by YangYuFan on 2018/4/9.
 */
public interface ContentService {
    //新增详情信息
   E3Result addContent(TbContent tbContent);

   //轮播图展示
    List<TbContent> getContentListByCid(long cid);
}
