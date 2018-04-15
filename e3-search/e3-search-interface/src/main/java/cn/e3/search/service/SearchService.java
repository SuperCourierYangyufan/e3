package cn.e3.search.service;

import cn.e3.common.pojo.SearchResult;

/**
 * Created by YangYuFan on 2018/4/15.
 */
public interface SearchService {
    SearchResult search(String keyWords,int page,int rows) throws Exception;
}
