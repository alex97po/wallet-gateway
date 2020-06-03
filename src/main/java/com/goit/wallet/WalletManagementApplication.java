package com.goit.wallet;

import com.goit.wallet.config.UriConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
public class WalletManagementApplication {

	public static void main(String[] args) {
		SpringApplication.run(WalletManagementApplication.class, args);
	}

}
