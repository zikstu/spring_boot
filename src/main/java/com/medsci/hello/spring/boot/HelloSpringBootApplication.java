package com.medsci.hello.spring.boot;

import com.alibaba.nacos.api.config.ConfigType;
import com.alibaba.nacos.spring.context.annotation.config.NacosPropertySource;
import net.hasor.spring.boot.EnableHasor;
import net.hasor.spring.boot.EnableHasorWeb;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.MultipartConfigFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.util.unit.DataSize;
import tk.mybatis.spring.annotation.MapperScan;

import javax.servlet.MultipartConfigElement;

@EnableHasor
@EnableHasorWeb
@SpringBootApplication
@NacosPropertySource(dataId = "hello-spring-boot", autoRefreshed = true, type = ConfigType.YAML)
@MapperScan(basePackages = "com.medsci.hello.spring.boot.mapper")
public class HelloSpringBootApplication {

    public static void main(String[] args) {
        System.setProperty("spring.devtools.restart.enabled", "false");
        SpringApplication.run(HelloSpringBootApplication.class, args);
    }

    /**
     * 文件上传配置
     * @return
     */
    @Bean
    public MultipartConfigElement multipartConfigElement() {
        MultipartConfigFactory factory = new MultipartConfigFactory();
        //文件最大
        factory.setMaxFileSize(DataSize.parse("10240KB")); //KB,MB
        /// 设置总上传数据总大小
        factory.setMaxRequestSize(DataSize.parse("102400KB"));
        return factory.createMultipartConfig();
    }
}
