package cn.itcast.bootstart.model.yaml;

import cn.itcast.bootstart.config.MinPropertySourceFactory;
import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Data
@Component
@PropertySource(value = {"classpath:family.yml"},factory = MinPropertySourceFactory.class)//导入外部配置文件，.properties文件不使用factory属性
public class Family {
    @Value("${family.familyName}")
    private String familyName;
    private Father father;
    private Mother mother;
    private Child child;
}
