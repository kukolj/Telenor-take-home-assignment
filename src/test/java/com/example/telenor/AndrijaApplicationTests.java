package com.example.telenor;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class AndrijaApplicationTests {

	@Autowired
	private GreetingController controller;
	
	@Test
	public void contexLoads() throws Exception {
		assertThat(controller).isNotNull();
	}	


}
