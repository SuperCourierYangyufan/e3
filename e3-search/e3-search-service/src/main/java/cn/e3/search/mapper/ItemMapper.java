package cn.e3.search.mapper;

import cn.e3.common.pojo.SearchItem;

import java.util.List;


public interface ItemMapper {

	List<SearchItem> getItemList();

	//activemq
	SearchItem getItemById(long item);
}
