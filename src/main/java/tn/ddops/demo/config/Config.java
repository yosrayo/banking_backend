package tn.ddops.demo.config;

import org.springframework.beans.factory.annotation.Value;

public class Config {
	
	@Value("${ionic.MOBILE_URL}")
	public String MOBILE_URL;

}
