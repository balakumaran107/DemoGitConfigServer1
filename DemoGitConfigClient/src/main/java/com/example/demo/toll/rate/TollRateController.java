package com.example.demo.toll.rate;

import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RefreshScope
public interface TollRateController {
	
	@RequestMapping("/tollrates")
	public String getRates();
}
