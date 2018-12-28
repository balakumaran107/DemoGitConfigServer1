package com.example.demo.toll.rate;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class TollRateControllerImpl implements TollRateController{

	@Value("${rate}")
	String rate;

	@Value("${lanecount}")
	String laneCount;

	@Value("${tollstart}")
	String tollStart;
	
	@Value("${connString}")
	String connString;

	@Override
	public String getRates() {
		return rate + " " + laneCount + " " + tollStart + " Conn Strin : " + connString;
	}
}
