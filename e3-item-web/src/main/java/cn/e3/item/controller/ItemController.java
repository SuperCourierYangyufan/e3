package cn.e3.item.controller;

import cn.e3.item.pojo.Item;
import cn.e3.pojo.TbItem;
import cn.e3.pojo.TbItemDesc;
import cn.e3.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 详情页面
 * Created by YangYuFan on 2018/4/18.
 */
@Controller
public class ItemController {
    @Autowired
    private ItemService itemService;


    @RequestMapping("/item/{itemId}")
    public String showItem(@PathVariable Long itemId, Model model){
        TbItem tbItem = itemService.getItemById(itemId);
        Item item = new Item(tbItem);

        TbItemDesc tbItemDesc = itemService.getTbItemDescByID(itemId);

        model.addAttribute("item",item);
        model.addAttribute("itemDesc",tbItemDesc);
        return "item";
    }
}
