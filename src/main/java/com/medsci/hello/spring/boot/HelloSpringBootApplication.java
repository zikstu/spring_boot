package com.medsci.hello.spring.boot;

import com.alibaba.nacos.api.config.ConfigType;
import com.alibaba.nacos.spring.context.annotation.config.NacosPropertySource;
import com.medsci.hello.spring.boot.utils.ErrorUtil;
import com.thebeastshop.forest.springboot.annotation.ForestScan;
import lombok.extern.slf4j.Slf4j;
import net.hasor.spring.boot.EnableHasor;
import net.hasor.spring.boot.EnableHasorWeb;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.MultipartConfigFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.util.unit.DataSize;
import tk.mybatis.spring.annotation.MapperScan;

import javax.servlet.MultipartConfigElement;
import javax.servlet.http.HttpServletResponse;
import java.net.InetAddress;
import java.net.UnknownHostException;

@Slf4j
@EnableHasor
@EnableHasorWeb
@SpringBootApplication
@NacosPropertySource(dataId = "hello-spring-boot", autoRefreshed = true, type = ConfigType.YAML)
@MapperScan(basePackages = "com.medsci.hello.spring.boot.mapper")
@ForestScan(basePackages = {"com.medsci.hello.spring.boot.service"})
public class HelloSpringBootApplication {
    @Value("${server.servlet.context-path:}")
    private String contextPath;

    /**
     * 端口
     */
    @Value("${server.port}")
    private String port;

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

    /**
     * 启动成功
     * @return
     */
    @Bean
    public ApplicationRunner applicationRunner(){
        return applicationArguments -> {
            try {
                //获取本机内网IP
                log.info("启动成功：" + "http://" + InetAddress.getLocalHost().getHostAddress() + ":" + port + contextPath + "doc.html");
            }catch (UnknownHostException e){
                log.error(ErrorUtil.errorInfoToString(e));
            }
        };
    }
}
