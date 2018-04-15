#solr的使用
https://github.com/SuperCourierYangyufan/e3/blob/master/e3-search/e3-search-service/src/main/Test/TestSolr.java

ps：可以注入solrService
  =》<bean id="httpSolrServer" class="org.apache.solr.client.solrj.impl.HttpSolrServer">
		        <constructor-arg index="0" value="http://123.206.32.230:8080/solr/"/>
	  </bean>
    
项目工程的使用：dao: https://github.com/SuperCourierYangyufan/e3/blob/master/e3-search/e3-search-service/src/main/java/cn/e3/search/dao/SearchDao.java
                service: https://github.com/SuperCourierYangyufan/e3/blob/master/e3-search/e3-search-service/src/main/java/cn/e3/search/service/Impl/SearchServiceImpl.java
                web: https://github.com/SuperCourierYangyufan/e3/blob/master/e3-search-web/src/main/java/cn/e3/search/controller/SearchController.java
