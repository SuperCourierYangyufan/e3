package cn.e3.search.controller;

import cn.e3.common.pojo.SearchResult;
import cn.e3.search.service.SearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by YangYuFan on 2018/4/15.
 */
@Controller
public class SearchController {
    @Autowired
    private SearchService searchService;

    @Value("${page_rows}")
    private Integer rows;

    @RequestMapping("/search")
    public String searchItemList(String keyword,@RequestParam(defaultValue = "1") int page,Model model) throws  Exception{
        keyword = new String(keyword.getBytes("iso-8859-1"),"utf-8");


        SearchResult searchResult = searchService.search(keyword, page, rows);
        model.addAttribute("query",keyword);
        model.addAttribute("totalPages",searchResult.getTotalPages());
        model.addAttribute("page",page);
        model.addAttribute("recourdCount",searchResult.getRecordCount());
        model.addAttribute("itemList",searchResult.getItemList());

        return "search";
    }
}
