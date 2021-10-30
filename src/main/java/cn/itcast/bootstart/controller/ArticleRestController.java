package cn.itcast.bootstart.controller;

import cn.itcast.bootstart.model.AjaxResponse;
import cn.itcast.bootstart.model.Article;
import cn.itcast.bootstart.service.ArticleRestService;
import io.swagger.annotations.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Date;

import static org.springframework.web.bind.annotation.RequestMethod.*;

@Slf4j
@RestController
@RequestMapping("/rest")
//@Api(value = "ArticleRestController",tags = {"文章操作接口"})
public class ArticleRestController {

    @Resource
    ArticleRestService articleRestService;

    @ApiOperation(value = "添加文章", notes = "添加新的文章信息", tags = "Article",httpMethod = "POST")
    @ApiResponses({
            @ApiResponse(code=200,message="成功",response=AjaxResponse.class),
            @ApiResponse(code=400,message="用户输入错误",response=AjaxResponse.class),
            @ApiResponse(code=500,message="系统内部错误",response=AjaxResponse.class)
    })
    //@RequestMapping(value = "/article",method = POST,produces = "application/json")
    @PostMapping("/article")
    public @ResponseBody AjaxResponse saveArticle(@RequestBody Article article){
    /*public  AjaxResponse saveArticle(@RequestParam String id,
                                     @RequestParam String author){*/
        log.info("saveArticle:{}",article);
        return AjaxResponse.success(article);
    }

    @ApiImplicitParams({
            @ApiImplicitParam(name = "name",value = "文章名",dataType = "string",paramType = "query"),
            @ApiImplicitParam(name = "id",value = "文章id",dataType = "long",paramType = "query"),
    })
    @ApiOperation(value = "删除文章", notes = "删除id对应的文章", tags = "Article",httpMethod = "DELETE")
    //@RequestMapping(value = "/article/{id}",method = DELETE,produces = "application/json")
    @DeleteMapping("/article/{id}")
    public @ResponseBody AjaxResponse deleteArticle(@PathVariable Long id){
        log.info("deleteArticle:{}",id);
        return AjaxResponse.success(id);
    }

    @ApiOperation(value = "修改文章信息", notes = "通过id修改对应文章的错误信息",tags = "Article", httpMethod = "PUT")
    //@RequestMapping(value = "/article/{id}",method = PUT,produces = "application/json")
    @PutMapping("/article/{id}")
    public @ResponseBody AjaxResponse updateArticle(@PathVariable Long id, @RequestBody Article article){
        article.setId(id);
        log.info("updateArticle:{}",id);
        return AjaxResponse.success(id);
    }


    @ApiOperation(value = "获取文章信息", notes = "展示所有文章的基本信息",tags = "Article",httpMethod = "GET")
    //@RequestMapping(value = "/article/{id}",method = GET,produces = "application/json")
    @GetMapping("/article/{id}")
    public @ResponseBody AjaxResponse getArticle(@PathVariable Long id){
        Article article1= Article.builder().id(1L).author("zimug").content("spring boot 2.深入浅出").createTime(new Date()).title("t1").build();
        return AjaxResponse.success(article1);
    }
}
