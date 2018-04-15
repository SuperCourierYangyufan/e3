package cn.e3.controller;

import cn.e3.common.pojo.EasyUiTreeNode;
import cn.e3.common.utils.E3Result;
import cn.e3.content.service.ContentCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Created by YangYuFan on 2018/4/8.
 * 内容分类管理
 */
@Controller
public class ContentCatController {

    @Autowired
    private ContentCategoryService contentCategoryService;

    @RequestMapping("/content/category/list")
    @ResponseBody
    public List<EasyUiTreeNode> getContentCatList(@RequestParam(name="id",defaultValue = "0") Long parentId){
        List<EasyUiTreeNode> contentCatList = contentCategoryService.getContentCatList(parentId);
        return contentCatList;
    }

    @RequestMapping(value = "/content/category/create",method = RequestMethod.POST)
    @ResponseBody
    public E3Result createContentCategory(Long parentId,String name){
        E3Result e3Result = contentCategoryService.addContentCat(parentId, name);
        return e3Result;
    }
}
