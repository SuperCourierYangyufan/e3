import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.SolrServer;
import org.apache.solr.client.solrj.impl.HttpSolrServer;
import org.apache.solr.client.solrj.response.QueryResponse;
import org.apache.solr.common.SolrDocument;
import org.apache.solr.common.SolrDocumentList;
import org.apache.solr.common.SolrInputDocument;
import org.junit.Test;

import java.util.List;
import java.util.Map;

/**
 * Created by YangYuFan on 2018/4/14.
 */
public class TestSolr {
    @Test
    public void AddorUpdateDocumemt() throws Exception{
        //创建SolrService对象
        SolrServer solrServer = new HttpSolrServer("http://123.206.32.230:8080/solr/");
        //创建一个文档对象
        SolrInputDocument document = new SolrInputDocument();
        //添加域 必须包含id域、必须在solr中有过定义
        document.addField("id","doc01");
        document.addField("item_title","测试商品2");
        document.addField("item_price","999999999");
        //写入
        solrServer.add(document);
        //提交
        solrServer.commit();

    }

    @Test
    public void deleteDocument() throws  Exception{
        //创建SolrService对象
        SolrServer solrServer = new HttpSolrServer("http://123.206.32.230:8080/solr/");
        solrServer.deleteById("doc01");
        //solrServer.deleteByQuery("id:doc01")
        solrServer.commit();
    }


    @Test
    public void queryIndex() throws Exception{
        //创建连接
        SolrServer solrServer = new HttpSolrServer("http://123.206.32.230:8080/solr/");
        //创建solrquery
        SolrQuery solrQuery = new SolrQuery();
        //设置条件
        solrQuery.setQuery("*:*");
        solrQuery.setStart(0);
        solrQuery.setRows(50);
//        solrQuery.set("q","*:*");
        //执行查询 queryResponse
        QueryResponse queryResponse = solrServer.query(solrQuery);
        //取文档对象。总记录数
        SolrDocumentList solrDocumentList = queryResponse.getResults();
        System.out.println("总记录数位"+solrDocumentList.getNumFound());
        //遍历
        for (SolrDocument document : solrDocumentList) {
            System.out.println(document.get("id"));
            System.out.println(document.get("item_title"));
            System.out.println(document.get("item_sell_point"));
            System.out.println(document.get("item_price"));
            System.out.println();
        }
    }






    @Test
    public  void queryNum2() throws Exception{
        //创建连接
        SolrServer solrServer = new HttpSolrServer("http://123.206.32.230:8080/solr/");
        //创建solrquery
        SolrQuery solrQuery = new SolrQuery();
        //设置条件
        solrQuery.setQuery("手机");
        solrQuery.set("df","item_keywords");
        //分页
        solrQuery.setStart(0);
        solrQuery.setRows(15);
        //高亮
        solrQuery.setHighlight(true);
        solrQuery.addHighlightField("item_title");
        solrQuery.setHighlightSimplePre("<em>");
        solrQuery.setHighlightSimplePost("</em>");
        //执行查询 queryResponse
        QueryResponse queryResponse = solrServer.query(solrQuery);
        //取文档对象
        SolrDocumentList solrDocumentList = queryResponse.getResults();

        //遍历
        for (SolrDocument document : solrDocumentList) {
            //获取高亮
            Map<String, Map<String, List<String>>> highlighting = queryResponse.getHighlighting();
            List<String> string = highlighting.get(document.get("id")).get("item_title");
            System.out.println(string);
            //普通信息  应该合理判断，strings!=null&&string.size()>0，则去上面的title若不然则应该正常取值
            System.out.println(document.get("id"));
            System.out.println(document.get("item_title"));
            System.out.println(document.get("item_sell_point"));
            System.out.println(document.get("item_price"));
            System.out.println();
        }





    }
}