package io.github.NiceLeader.CryptoWatch;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude={SecurityAutoConfiguration.class})

public class CryptoWatchApplication {
	public static void main(String[] args) {
		SpringApplication.run(CryptoWatchApplication.class, args);
	}
}
