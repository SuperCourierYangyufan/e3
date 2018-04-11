package cn.e3.content.service.Impl;

import cn.e3.common.jedis.JedisClient;
import cn.e3.common.utils.E3Result;
import cn.e3.common.utils.JsonUtils;
import cn.e3.content.service.ContentService;
import cn.e3.mapper.TbContentMapper;
import cn.e3.pojo.TbContent;
import cn.e3.pojo.TbContentExample;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * Created by YangYuFan on 2018/4/9.
 */
@Service
public class ContentServiceImpl implements ContentService {
    @Autowired
    private TbContentMapper tbContentMapper;
    @Autowired
    private JedisClient jedisClient;
    @Value("${CONTENT_LIST}")
    private String CONTENT_LIST;


    @Override
    public E3Result addContent(TbContent tbContent) {
        //将内容数据插入内容表
        tbContent.setCreated(new Date());
        tbContent.setUpdated(new Date());

        tbContentMapper.insert(tbContent);

        //缓存同步 删除缓冲中对应的数据
        jedisClient.hdel(CONTENT_LIST,tbContent.getCategoryId().toString());
        return null;
    }

    @Override
    public List<TbContent> getContentListByCid(long cid) {
        //查询缓冲。若有直接响应结果，
        try {
            String json = jedisClient.hget(CONTENT_LIST, cid + "");
            if(StringUtils.isNotBlank(json)){
                List<TbContent> tbContents = JsonUtils.jsonToList(json, TbContent.class);
                return tbContents;
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        //没有查询数据库，并添加缓存
        TbContentExample tbContentExample = new TbContentExample();
        TbContentExample.Criteria criteria = tbContentExample.createCriteria();
        criteria.andCategoryIdEqualTo(cid);
        List<TbContent> tbContentList = tbContentMapper.selectByExampleWithBLOBs(tbContentExample);
        try {
            jedisClient.hset(CONTENT_LIST,cid+"", JsonUtils.objectToJson(tbContentList));
        }catch (Exception e){
            e.printStackTrace();
        }
        return tbContentList;
    }
}
