#solr的使用</BR>
https://github.com/SuperCourierYangyufan/e3/blob/master/e3-search/e3-search-service/src/main/Test/TestSolr.java

ps：可以注入solrService
  =》</br>	https://github.com/SuperCourierYangyufan/e3/blob/master/e3-search/e3-search-service/src/main/resources/spring/applicationContext-solr.xml<br/>
    
项目工程的使用：</br>dao: https://github.com/SuperCourierYangyufan/e3/blob/master/e3-search/e3-search-service/src/main/java/cn/e3/search/dao/SearchDao.java <br/>
                service: https://github.com/SuperCourierYangyufan/e3/blob/master/e3-search/e3-search-service/src/main/java/cn/e3/search/service/Impl/SearchServiceImpl.java<br/>
                web: https://github.com/SuperCourierYangyufan/e3/blob/master/e3-search-web/src/main/java/cn/e3/search/controller/SearchController.java<br/>
                
                
                
                
#集群版使用</br>
https://github.com/SuperCourierYangyufan/e3/blob/master/e3-search/e3-search-service/src/main/Test/TestSolrCloud.java</br>
将spirng中httpSolrServer切换至cloudSolrServer即可使用


