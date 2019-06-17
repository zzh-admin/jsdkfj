package com.springcloud;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@MapperScan("com.springcloud.dao")
@SpringBootApplication	//璁剧疆mybatis鐨勬帴鍙ｄ綅缃�
@EnableEurekaClient
public class SpringCloudGoodProvider {

	public static void main(String[] args) throws Exception {
		SpringApplication.run(SpringCloudGoodProvider.class, args);
	}

}
