package cn.e3.service.Impl;

import cn.e3.common.pojo.EasyUIData;
import cn.e3.common.utils.E3Result;
import cn.e3.common.utils.IDUtils;
import cn.e3.mapper.TbItemDescMapper;
import cn.e3.mapper.TbItemMapper;
import cn.e3.pojo.TbItem;
import cn.e3.pojo.TbItemDesc;
import cn.e3.pojo.TbItemExample;
import cn.e3.service.ItemService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * Created by YangYuFan on 2018/4/4.
 */
@Service
public class ItemServiceImpl implements ItemService {
    @Autowired
    private TbItemMapper tm;

    @Autowired
    private TbItemDescMapper tbItemDescMapper;

    @Override
    public TbItem getItemById(long itemid) {
        //根据主键查询
        TbItem tbItem = tm.selectByPrimaryKey(itemid);
        return tbItem;
    }

    @Override
    public EasyUIData getItemList(int page, int rows) {
        //设置分页信息
        PageHelper.startPage(page, rows);
        //执行查询
        TbItemExample example = new TbItemExample();
        List<TbItem> list = tm.selectByExample(example);
        //创建一个返回值对象
        EasyUIData result = new EasyUIData();
        result.setRows(list);
        //取分页结果
        PageInfo<TbItem> pageInfo = new PageInfo<>(list);
        //取总记录数
        long total = pageInfo.getTotal();
        result.setTotal(total);
        return result;
    }

    @Override
    public E3Result addItem(TbItem tbItem, String desc) {
        //创建商品id
        long itemId = IDUtils.genItemId();
        //补全item属性
        tbItem.setId(itemId); //id
        tbItem.setStatus((byte) 1);//1 成功 2下架 3 删除
        tbItem.setCreated(new Date()); //插入时间
        tbItem.setUpdated(new Date()); //更新时间
        //向商品表插入数据
        tm.insert(tbItem);
        //创建商品描述表
        TbItemDesc tbItemDesc = new TbItemDesc();
        //属性补全
        tbItemDesc.setItemId(itemId);
        tbItemDesc.setItemDesc(desc); //详情信息
        tbItemDesc.setCreated(new Date());
        tbItemDesc.setUpdated(new Date());
        //向商品描述表插入数据
        tbItemDescMapper.insert(tbItemDesc);
        //返回成功
        return E3Result.ok();
    }
}

