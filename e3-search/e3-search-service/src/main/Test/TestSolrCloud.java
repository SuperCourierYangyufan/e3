import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.impl.CloudSolrServer;
import org.apache.solr.client.solrj.response.QueryResponse;
import org.apache.solr.common.SolrDocument;
import org.apache.solr.common.SolrDocumentList;
import org.apache.solr.common.SolrInputDocument;
import org.junit.Test;

/**
 * Created by YangYuFan on 2018/4/17.
 */
public class TestSolrCloud {

    @Test
    public void addDocument() throws Exception{
        //创建集群连接 zkHost zookeeper地址列表
        CloudSolrServer cloudSolrServer = new CloudSolrServer("123.206.32.230:2181,123.206.32.230:2182,123.206.32.230:2183");
        //defaultCollection属性
        cloudSolrServer.setDefaultCollection("collection2");

        //单机使用方法一致
        SolrInputDocument document = new SolrInputDocument();
        document.setField("id","helloCloud");
        document.setField("item_price","5000");
        document.setField("item_title","1111111111");

        cloudSolrServer.add(document);
        cloudSolrServer.commit();
    }




    @Test
    public void testQuery() throws Exception{
        CloudSolrServer cloudSolrServer = new CloudSolrServer("123.206.32.230:2181,123.206.32.230:2182,123.206.32.230:2183");
        cloudSolrServer.setDefaultCollection("collection2");

        SolrQuery query = new SolrQuery();
        query.setQuery("id:helloCloud");

        QueryResponse queryResponse = cloudSolrServer.query(query);
        SolrDocumentList list = queryResponse.getResults();
        System.out.println(list.getNumFound());
        for (SolrDocument document : list) {
            System.out.println(document.get("id"));
            System.out.println(document.get("item_title"));
        }
    }
}
