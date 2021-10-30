package cn.itcast.bootstart.model;


import com.fasterxml.jackson.annotation.*;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
//@JsonPropertyOrder(value = {"content","title"})
//@ApiModel(value = "Article对象",description = "文章对象信息")
public class Article {

    /**
     * id : 1
     * author : zimug
     * title : 手摸手教你kaifaspringboot
     * content : c
     * createTime :
     * reader : [{"name":"zimug","age":18},{"name":"kobe","age":37}]
     */
    @ApiModelProperty(name = "id",value = "编号",required = true)
    @JsonIgnore
    private Long id;
    //@JsonProperty("auther")
    @ApiModelProperty(name = "author",value = "作者",example = "莫言",required = true)
    private String author;

    @ApiModelProperty(name = "title",value = "标题",example = "《我爱我的祖国》",required = true)
    private String title;

    private String content;

   // @JsonInclude(JsonInclude.Include.NON_NULL)
    @ApiModelProperty(name = "createTime",value = "日期",required = true)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date createTime;
    private List<Reader> reader;



}