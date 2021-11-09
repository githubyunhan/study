package cn.itcast.bootstart.service;

import cn.itcast.bootstart.generator.testdb.Article;
import cn.itcast.bootstart.generator.testdb.ArticleMapper;
import cn.itcast.bootstart.model.ArticleVO;
import cn.itcast.bootstart.utils.DozerUtils;
import lombok.extern.slf4j.Slf4j;

import org.dozer.Mapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Slf4j
@Service
public class ArticleMybatisRestServiceImpl implements ArticleRestService {

    @Resource
    protected Mapper dozerMapper;

    @Resource
    private ArticleMapper articleMapper;

    //@Transactional//做事务管理
    @Override
    public ArticleVO saveArticle(ArticleVO article) {
        Article articlePO=dozerMapper.map(article,Article.class);

        articleMapper.insert(articlePO);
        return article;
    }

    @Override
    public void deleteArticle(Long id) {

        articleMapper.deleteByPrimaryKey(id);
    }

    @Override
    public void updateArticle(ArticleVO article) {

        Article articlePO=dozerMapper.map(article,Article.class);
        articleMapper.updateByPrimaryKeySelective(articlePO);
    }

    @Override
    public ArticleVO getArticle(Long id) {
        return dozerMapper.map(articleMapper.selectByPrimaryKey(id),ArticleVO.class);
    }

    @Override
    public List<ArticleVO> getAll() {
        List<Article> articles=articleMapper.selectByExample(null);
        return DozerUtils.mapList(articles,ArticleVO.class);
    }
}
