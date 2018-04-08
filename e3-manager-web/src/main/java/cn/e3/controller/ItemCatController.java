package cn.e3.controller;

import cn.e3.common.pojo.EasyUiTreeNode;
import cn.e3.service.ItemCatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Created by YangYuFan on 2018/4/6.
 */
@Controller
public class ItemCatController {
    @Autowired
    private ItemCatService itemCatService;

    //商品节点分类
    @RequestMapping("/item/cat/list")
    @ResponseBody
    public List<EasyUiTreeNode> getItemCatList(@RequestParam(name="id",defaultValue = "0")long parentId){
        List<EasyUiTreeNode> list = itemCatService.getItemCatList(parentId);
        return list;
    }

}
