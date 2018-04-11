package cn.e3.content.service.Impl;

import cn.e3.common.pojo.EasyUiTreeNode;
import cn.e3.common.utils.E3Result;
import cn.e3.content.service.ContentCategoryService;
import cn.e3.mapper.TbContentCategoryMapper;
import cn.e3.pojo.TbContentCategory;
import cn.e3.pojo.TbContentCategoryExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by YangYuFan on 2018/4/8.
 */
@Service
public class ContentCategoryServiceImpl implements ContentCategoryService {
    @Autowired
    private TbContentCategoryMapper tbContentCategoryMapper;

    @Override
    public List<EasyUiTreeNode> getContentCatList(long parentId) {
        //根据parentid查询字节点类表
        TbContentCategoryExample tbContentCategoryExample = new TbContentCategoryExample();
        TbContentCategoryExample.Criteria criteria = tbContentCategoryExample.createCriteria();
        criteria.andParentIdEqualTo(parentId);

        List<TbContentCategory> tbContentCategoryList = tbContentCategoryMapper.selectByExample(tbContentCategoryExample);

        //转出成EasyUiTreeNode
        List<EasyUiTreeNode> easyUiTreeNodeList = new ArrayList<>();
        for (TbContentCategory nodeList : tbContentCategoryList) {
            EasyUiTreeNode easyUiTreeNode = new EasyUiTreeNode();
            easyUiTreeNode.setId(nodeList.getId());
            easyUiTreeNode.setText(nodeList.getName());
            easyUiTreeNode.setState(nodeList.getIsParent()?"closed":"open");
            easyUiTreeNodeList.add(easyUiTreeNode);
        }
        return easyUiTreeNodeList;
    }

    @Override
    public E3Result addContentCat(long parentID, String name) {
        //创建pojo插入数据，返回id
        TbContentCategory tbContentCategory = new TbContentCategory();
        tbContentCategory.setParentId(parentID);
        tbContentCategory.setName(name);
        tbContentCategory.setStatus(1); //1为创建 2为删除
        tbContentCategory.setSortOrder(1);
        tbContentCategory.setCreated(new Date());
        tbContentCategory.setUpdated(new Date());
        tbContentCategory.setIsParent(false); //新添加的节点一定是叶子节点

        int id = tbContentCategoryMapper.insert(tbContentCategory);
        //判断父节点，isparent属性，若不是true改为true
        TbContentCategory contentCategory = tbContentCategoryMapper.selectByPrimaryKey(parentID);
        if(!contentCategory.getIsParent()){
            contentCategory.setIsParent(true);
            //提交更新父节点
            tbContentCategoryMapper.updateByPrimaryKey(contentCategory);
        }
        //创建E3Result,填充属性，返回
        return E3Result.ok(contentCategory);
    }
}
