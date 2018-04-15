package cn.e3.search.service.Impl;

import cn.e3.common.pojo.SearchResult;
import cn.e3.search.dao.SearchDao;
import cn.e3.search.service.SearchService;
import org.apache.solr.client.solrj.SolrQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 商品搜索
 * Created by YangYuFan on 2018/4/15.
 */
@Service
public class SearchServiceImpl implements SearchService {
    @Autowired
    private SearchDao searchDao;


    @Override
    public SearchResult search(String keyWords, int page, int rows) throws Exception {
        //创建solrQuery对象
        SolrQuery query = new SolrQuery();
        //设置查询条件
        query.setQuery(keyWords);
        //分页条件
        if(page <=0)
            page=1;
        query.setStart((page-1)*rows);
        query.setRows(rows);
        //设置默认搜索域
        query.set("df","item_title");
        //开启高亮
        query.setHighlight(true);
        query.addHighlightField("item_title");
        query.setHighlightSimplePre("<em style=\" colo:red \" ");
        query.setHighlightSimplePost("</em>");
        //调用dao执行查询
            SearchResult searchResult = searchDao.search(query);
            //进一步封装
            long recordCount = searchResult.getRecordCount();
            int totalPage = (int) (recordCount/rows);
            if(recordCount%rows >0)
                totalPage++;
            searchResult.setTotalPages(totalPage);
            //返回
            return searchResult;

    }
}
