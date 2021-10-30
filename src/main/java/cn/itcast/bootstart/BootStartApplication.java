package cn.itcast.bootstart;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;

@SpringBootApplication
@ImportResource(locations = {"classpath:beans.xml"})//导入外部配置文件，.xml文件
public class BootStartApplication {

    public static void main(String[] args) {
        SpringApplication.run(BootStartApplication.class, args);
    }

}
