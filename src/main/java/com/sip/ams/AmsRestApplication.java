package com.sip.ams;

import java.io.File;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class AmsRestApplication {
	public static String uploadDirectory =
			System.getProperty("user.dir")+"/src/main/resources/static/uploads";
	public static void main(String[] args) {
		new File(uploadDirectory).mkdir();
		SpringApplication.run(AmsRestApplication.class, args);
	}

}
