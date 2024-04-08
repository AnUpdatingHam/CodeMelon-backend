package org.rhythm;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/*
引导类，springboot的入口
 */
@EnableCaching
//@ServletComponentScan   //允许使用javaWeb组件(Filter)
@SpringBootApplication
@EnableTransactionManagement //开启注解方式事务管理
@EnableScheduling //开启任务调度
@Slf4j
public class MelonApplication {
    public static void main(String[] args) {
        SpringApplication.run(MelonApplication.class, args);
        log.info("server started");
    }
}
