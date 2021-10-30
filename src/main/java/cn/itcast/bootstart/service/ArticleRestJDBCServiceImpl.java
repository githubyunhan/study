package cn.itcast.bootstart.service;

import cn.itcast.bootstart.dao.ArticleJDBCDAO;
import cn.itcast.bootstart.model.Article;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Slf4j
@Service
public class ArticleRestJDBCServiceImpl implements ArticleRestService {

    @Resource
    ArticleJDBCDAO articleJDBCDAO;

    @Transactional//做事务管理
    @Override
    public Article saveArticle(Article article) {

        articleJDBCDAO.save(article);
        return article;
    }

    @Override
    public void deleteArticle(Long id) {

        articleJDBCDAO.deleteById(id);
    }

    @Override
    public void updateArticle(Article article) {

        articleJDBCDAO.updateById(article);
    }

    @Override
    public Article getArticle(Long id) {
        return articleJDBCDAO.findById(id);
    }

    @Override
    public List<Article> getAll() {
        return articleJDBCDAO.findAll();
    }
}
