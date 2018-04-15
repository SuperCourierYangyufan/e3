package cn.e3.controller;

import cn.e3.common.utils.E3Result;
import cn.e3.search.service.SearchItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 导入商品至solr
 * Created by YangYuFan on 2018/4/14.
 */
@Controller
public class SearchItemController {
    @Autowired
    private SearchItemService searchItemService;

    @RequestMapping("/index/item/import")
    @ResponseBody
    public E3Result importItemList(){
        E3Result e3Result = searchItemService.importAllItems();
        return e3Result;
    }

}
