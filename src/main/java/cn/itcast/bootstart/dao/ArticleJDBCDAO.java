package cn.itcast.bootstart.dao;

import cn.itcast.bootstart.model.ArticleVO;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.List;

@Repository
public class ArticleJDBCDAO {
    @Resource
    private JdbcTemplate jdbcTemplate;

    /*保存文章*/
    public void save(ArticleVO article){
        /*jdbcTemplate.update用于insert、update、delete操作*/
        jdbcTemplate.update("INSERT INTO article(author, title, content, createTime) VALUES (?,?,?,?)",
                article.getAuthor(),
                article.getTitle(),
                article.getContent(),
                article.getCreateTime());
    }

    /*删除文章*/
    public void deleteById(Long id){
        jdbcTemplate.update("DELETE FROM article WHERE id=?",new Object[]{id});
    }
    /*更新文章（修改）*/
    public void updateById(ArticleVO article){
        jdbcTemplate.update("UPDATE article SET author=?,title=?,content=?,createTime=? WHERE id=?",
                article.getAuthor(),
                article.getTitle(),
                article.getContent(),
                article.getCreateTime(),
                article.getId());
    }

    /*根据id查找文章*/
    public ArticleVO findById(Long id){
        /*queryForObject用于查询单条记录返回结果*/
        return (ArticleVO) jdbcTemplate.queryForObject("SELECT * FROM article WHERE id=?",new Object[]{id},new BeanPropertyRowMapper(ArticleVO.class));
    }

    /*查询所有*/
    public List<ArticleVO> findAll(){
        /*query用于查询结果列表*/
        return (List<ArticleVO>)jdbcTemplate.query("SELECT * FROM article",new BeanPropertyRowMapper(ArticleVO.class));
    }
}
