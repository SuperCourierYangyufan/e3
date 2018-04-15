package cn.e3.search.dao;

import cn.e3.common.pojo.SearchItem;
import cn.e3.common.pojo.SearchResult;
import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.SolrServer;
import org.apache.solr.client.solrj.response.QueryResponse;
import org.apache.solr.common.SolrDocument;
import org.apache.solr.common.SolrDocumentList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * 商品搜索dao
 * Created by YangYuFan on 2018/4/15.
 */
@Repository
public class SearchDao {
    @Autowired
    private SolrServer solrServer;


    //根据查询查询索引库
    public SearchResult search(SolrQuery query) throws Exception{
        //根据query查询索引
        QueryResponse queryResponse = solrServer.query(query);
        SolrDocumentList solrDocuments = queryResponse.getResults(); //普通内容
        //取查询结果返回
        SearchResult searchResult = new SearchResult();
        searchResult.setRecordCount(solrDocuments.getNumFound()); //总记录

        List<SearchItem> searchItemList = new ArrayList<>();

        for (SolrDocument document : solrDocuments) {
            SearchItem searchItem = new SearchItem();

           searchItem.setId((String) document.get("id"));
           searchItem.setCategory_name((String) document.get("item_category_name"));
           searchItem.setImage((String) document.get("item_image"));
           searchItem.setPrice((Long) document.get("item_price"));
           searchItem.setSell_point((String) document.get("item_sell_point"));

           //高亮
            Map<String, Map<String, List<String>>> highlighting = queryResponse.getHighlighting();
            List<String> list = highlighting.get(document.get("id")).get("item_title");
            if(list!=null&&list.size()>0){
                searchItem.setTitle(list.get(0));
            }else {
                searchItem.setTitle((String) document.get("item_title"));
            }
           searchItemList.add(searchItem);
        }

        searchResult.setItemList(searchItemList);

        return  searchResult;
    }
}
