package cn.itcast.bootstart.dao;

import cn.itcast.bootstart.model.Article;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.List;

@Repository
public class ArticleJDBCDAO {
<<<<<<< HEAD

    @Resource
    private JdbcTemplate primaryJdbcTemplate;

    @Resource
    private JdbcTemplate secondaryJdbcTemplate;

    /*保存文章*/
    public void save(Article article,JdbcTemplate jdbcTemplate){
=======
    @Resource
    private JdbcTemplate jdbcTemplate;

    /*保存文章*/
    public void save(Article article){
>>>>>>> origin/main
        /*jdbcTemplate.update用于insert、update、delete操作*/
        jdbcTemplate.update("INSERT INTO article(author, title, content, createTime) VALUES (?,?,?,?)",
                article.getAuthor(),
                article.getTitle(),
                article.getContent(),
                article.getCreateTime());
    }

    /*删除文章*/
<<<<<<< HEAD
    public void deleteById(Long id,JdbcTemplate jdbcTemplate){
        jdbcTemplate.update("DELETE FROM article WHERE id=?",new Object[]{id});
    }
    /*更新文章（修改）*/
    public void updateById(Article article,JdbcTemplate jdbcTemplate){
=======
    public void deleteById(Long id){
        jdbcTemplate.update("DELETE FROM article WHERE id=?",new Object[]{id});
    }
    /*更新文章（修改）*/
    public void updateById(Article article){
>>>>>>> origin/main
        jdbcTemplate.update("UPDATE article SET author=?,title=?,content=?,createTime=? WHERE id=?",
                article.getAuthor(),
                article.getTitle(),
                article.getContent(),
                article.getCreateTime(),
                article.getId());
    }

    /*根据id查找文章*/
<<<<<<< HEAD
    public Article findById(Long id,JdbcTemplate jdbcTemplate){
=======
    public Article findById(Long id){
>>>>>>> origin/main
        /*queryForObject用于查询单条记录返回结果*/
        return (Article) jdbcTemplate.queryForObject("SELECT * FROM article WHERE id=?",new Object[]{id},new BeanPropertyRowMapper(Article.class));
    }

    /*查询所有*/
<<<<<<< HEAD
    public List<Article> findAll(JdbcTemplate jdbcTemplate){
        /*query用于查询结果列表*/
        return (List<Article>)jdbcTemplate.query("SELECT * FROM article",new BeanPropertyRowMapper(Article.class));
    }
}
=======
    public List<Article> findAll(){
        /*query用于查询结果列表*/
        return (List<Article>)jdbcTemplate.query("SELECT * FROM article",new BeanPropertyRowMapper(Article.class));
    }
}
>>>>>>> origin/main
