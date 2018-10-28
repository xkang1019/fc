package com.ruoyi;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;



@SpringBootApplication(exclude = { DataSourceAutoConfiguration.class})
@MapperScan("com.ruoyi.*.mapper")
public class LinLiApplication
{

    private final RestTemplateBuilder builder;

    @Autowired
    public LinLiApplication(RestTemplateBuilder builder) {
        this.builder = builder;
    }

    // 使用RestTemplateBuilder来实例化RestTemplate对象，spring默认已经注入了RestTemplateBuilder实例
    @Bean
    public RestTemplate restTemplate() {
        return builder.build();
    }


    public static void main(String[] args)
    {
        // System.setProperty("spring.devtools.restart.enabled", "false");
        SpringApplication.run(LinLiApplication.class, args);
        System.out.println("\n" +"      :::        :::        :::::::::       :::    ::: \n" +
                "     :+:        :+:             :+:        :+:    :+:  \n" +
                "    +:+        +:+            +:+          +:+  +:+    \n" +
                "   +#+        +#+           +#+            +#++:+      \n" +
                "  +#+        +#+          +#+            +#+  +#+      \n" +
                " #+#        #+#         #+#            #+#    #+#      \n" +
                "########## ########## #########       ###    ###      邻里中心启动成功 ... \n");
    }
}
