package cn.e3.controller;

import cn.e3.common.pojo.EasyUIData;
import cn.e3.common.utils.E3Result;
import cn.e3.pojo.TbItem;
import cn.e3.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * Created by YangYuFan on 2018/4/4.
 */
@Controller
public class itemController {

    @Autowired
    private ItemService itemService;

    //根据id查询商品-json返回
    @RequestMapping("/item/{itemId}")
    @ResponseBody
    public TbItem getItemById(@PathVariable Long itemId){
        TbItem itemById = itemService.getItemById(itemId);
        return itemById;
    }

    //商品查询-分页-json
    @RequestMapping("/item/list")
    @ResponseBody
    public EasyUIData getItemList(@RequestParam(required = false,defaultValue = "1")Integer page, @RequestParam(required = false,defaultValue = "30")Integer rows) {
        //调用服务查询商品列表
        EasyUIData result = itemService.getItemList(page, rows);
        return result;
    }

    //添加商品
    @RequestMapping(value = "/item/save",method = RequestMethod.POST)
    @ResponseBody
    public E3Result addItem(TbItem item,String desc){
        E3Result result = itemService.addItem(item, desc);
        return result;
    }
}
