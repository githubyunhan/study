package cn.itcast.bootstart.mybatis;

import cn.itcast.bootstart.generator.testdb.Article;
import cn.itcast.bootstart.generator.testdb.ArticleMapper;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MybatisTest {

    //只有紧跟在PageHelper.startPage方法后的第一个Mybatis的查询（Select）方法会被分页
    @Resource
    ArticleMapper articleMapper;

    @Test
    public void testPageHelper(){
        PageHelper.startPage(2,2);
        List<Article> articles = articleMapper.selectByExample(null);
        PageInfo<Article> page=PageInfo.of(articles);
        System.out.println(page);
    }
}
