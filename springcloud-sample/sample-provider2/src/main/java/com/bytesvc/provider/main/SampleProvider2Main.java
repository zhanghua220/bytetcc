package com.bytesvc.provider.main;

import org.springframework.boot.Banner;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.ImportResource;

@ImportResource({ "classpath:bytetcc-supports-springcloud.xml" })
@EnableDiscoveryClient
@SpringBootApplication(scanBasePackages = "com.bytesvc.provider")
public class SampleProvider2Main {

	public static void main(String[] args) {
		new SpringApplicationBuilder(SampleProvider2Main.class).bannerMode(Banner.Mode.OFF).web(true).run(args);
		System.out.println("springcloud-sample-provider2 started!");
	}

}
