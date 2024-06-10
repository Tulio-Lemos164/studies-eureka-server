package br.com.mscredit_appraiser;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class MscreditAppraiserApplication {

	public static void main(String[] args) {
		SpringApplication.run(MscreditAppraiserApplication.class, args);
	}

}
