package cn.e3.pageHelper;

import cn.e3.mapper.TbItemMapper;
import cn.e3.pojo.TbItem;
import cn.e3.pojo.TbItemExample;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * Created by YangYuFan on 2018/4/6.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath*:spring/applicationContext-*.xml")
public class pagehelper {

    @Autowired
    private TbItemMapper tm;
    @Test
    public void testPageHelper() throws Exception {
        PageHelper.startPage(1,10);
        TbItemExample example = new TbItemExample();
        List<TbItem> list = tm.selectByExample(example);
        PageInfo<TbItem> pageInfo = new PageInfo<>(list);

        System.out.println(pageInfo.getTotal());
    }

}
