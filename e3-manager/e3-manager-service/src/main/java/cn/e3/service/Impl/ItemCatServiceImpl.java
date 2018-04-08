package cn.e3.service.Impl;

import cn.e3.common.pojo.EasyUiTreeNode;
import cn.e3.mapper.TbItemCatMapper;
import cn.e3.pojo.TbItemCat;
import cn.e3.pojo.TbItemCatExample;
import cn.e3.service.ItemCatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by YangYuFan on 2018/4/6.
 */
@Service
public class ItemCatServiceImpl implements ItemCatService {
    @Autowired
    private TbItemCatMapper tbItemCatMapper;

    //根据parentId查询子节点类别
    @Override
    public List<EasyUiTreeNode> getItemCatList(long parentId) {
        //封装查询
        TbItemCatExample tbItemCatExample = new TbItemCatExample();
        TbItemCatExample.Criteria criteria = tbItemCatExample.createCriteria();
        criteria.andParentIdEqualTo(parentId);
        //查询
        List<TbItemCat> list = tbItemCatMapper.selectByExample(tbItemCatExample);
        //创建节点对象
        List<EasyUiTreeNode> easyUiTreeNodes = new ArrayList<>();
        for (TbItemCat tbItemCat : list) {
            //循环添加
            EasyUiTreeNode easyUiTreeNode = new EasyUiTreeNode();
            easyUiTreeNode.setId(tbItemCat.getId());
            easyUiTreeNode.setText(tbItemCat.getName());
            easyUiTreeNode.setState(tbItemCat.getIsParent()?"closed":"open");
            easyUiTreeNodes.add(easyUiTreeNode);
        }
        return easyUiTreeNodes;
    }
}
