package cn.itcast.bootstart.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel(value = "AjaxResponse对象",description = "修改数据信息")
public class AjaxResponse {

    @ApiModelProperty(name = "isok",value = "是否成功",required = true)
    private boolean isok;

    @ApiModelProperty(name = "code",value = "代号",required = true)
    private int code;

    @ApiModelProperty(name = "message",value = "信息说明",required = true)
    private String message;

    @ApiModelProperty(name = "data",value = "数据",required = true)
    private Object data;

    private AjaxResponse() {

    }

    public static AjaxResponse success() {
        AjaxResponse resultBean = new AjaxResponse();
        resultBean.setIsok(true);
        resultBean.setCode(200);
        resultBean.setMessage("success");
        return resultBean;
    }

    public static AjaxResponse success(Object data) {
        AjaxResponse resultBean = new AjaxResponse();
        resultBean.setIsok(true);
        resultBean.setCode(200);
        resultBean.setMessage("success");
        resultBean.setData(data);
        return resultBean;
    }
}
