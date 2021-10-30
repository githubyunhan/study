package cn.itcast.bootstart.controller;

import cn.itcast.bootstart.model.AjaxResponse;
import cn.itcast.bootstart.model.Article;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

import static org.springframework.web.bind.annotation.RequestMethod.*;

@Slf4j
@RestController
@RequestMapping("/rest")
public class ArticleRestController {

    //@RequestMapping(value = "/article",method = POST,produces = "application/json")
    @PostMapping("/article")
    public @ResponseBody AjaxResponse saveArticle(@RequestBody Article article){
    /*public  AjaxResponse saveArticle(@RequestParam String id,
                                     @RequestParam String author){*/
        log.info("saveArticle:{}",article);
        return AjaxResponse.success(article);
    }

    //@RequestMapping(value = "/article/{id}",method = DELETE,produces = "application/json")
    @DeleteMapping("/article/{id}")
    public @ResponseBody AjaxResponse deleteArticle(@PathVariable Long id){
        log.info("deleteArticle:{}",id);
        return AjaxResponse.success(id);
    }

    //@RequestMapping(value = "/article/{id}",method = PUT,produces = "application/json")
    @PutMapping("/article/{id}")
    public @ResponseBody AjaxResponse updateArticle(@PathVariable Long id, @RequestBody Article article){
        article.setId(id);
        log.info("updateArticle:{}",id);
        return AjaxResponse.success(id);
    }

    //@RequestMapping(value = "/article/{id}",method = GET,produces = "application/json")
    @GetMapping("/article/{id}")
    public @ResponseBody AjaxResponse getArticle(@PathVariable Long id){
        Article article1= Article.builder().id(1L).author("zimug").content("spring boot 2.深入浅出").createTime(new Date()).title("t1").build();
        return AjaxResponse.success(article1);
    }
}
