package com.example.telenor;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

@SpringBootTest
@AutoConfigureMockMvc
class TestWebApp extends AndrijaApplicationTests {
	
	@Autowired
	private MockMvc mvc;
	
	@Test
	public void test1() throws Exception {

		MockHttpServletRequestBuilder mockHttpServletRequestBuilder = MockMvcRequestBuilders.get("/greeting");
		mockHttpServletRequestBuilder.param("id", "10");
		mockHttpServletRequestBuilder.param("account", "personal");
		mvc.perform(mockHttpServletRequestBuilder).andExpect(status().isOk()).andDo(print());

	}
	
	@Test
	public void test2() throws Exception {

		MockHttpServletRequestBuilder mockHttpServletRequestBuilder = MockMvcRequestBuilders.get("/greeting");
		mockHttpServletRequestBuilder.param("id", "10");
		mockHttpServletRequestBuilder.param("account", "personal");
		mockHttpServletRequestBuilder.param("type", "small");
		mvc.perform(mockHttpServletRequestBuilder).andExpect(status().isOk()).andDo(print());

	}
	
	@Test
	public void test3() throws Exception {

		MockHttpServletRequestBuilder mockHttpServletRequestBuilder = MockMvcRequestBuilders.get("/greeting");
		mockHttpServletRequestBuilder.param("id", "10");
		mockHttpServletRequestBuilder.param("account", "personal");
		mockHttpServletRequestBuilder.param("type", "bla");
		mvc.perform(mockHttpServletRequestBuilder).andExpect(status().isBadRequest()).andDo(print());

	}
	
	@Test
	public void test4() throws Exception {

		MockHttpServletRequestBuilder mockHttpServletRequestBuilder = MockMvcRequestBuilders.get("/greeting");
		mockHttpServletRequestBuilder.param("id", "-1");
		mockHttpServletRequestBuilder.param("account", "personal");
		mockHttpServletRequestBuilder.param("type", "small");
		mvc.perform(mockHttpServletRequestBuilder).andExpect(status().isBadRequest()).andDo(print());

	}
	
	@Test
	public void test5() throws Exception {

		MockHttpServletRequestBuilder mockHttpServletRequestBuilder = MockMvcRequestBuilders.get("/greeting");
		mockHttpServletRequestBuilder.param("account", "personal");
		mockHttpServletRequestBuilder.param("type", "small");
		mvc.perform(mockHttpServletRequestBuilder).andExpect(status().isBadRequest()).andDo(print());

	}
	
	@Test
	public void test6() throws Exception {

		MockHttpServletRequestBuilder mockHttpServletRequestBuilder = MockMvcRequestBuilders.get("/greeting");
		mockHttpServletRequestBuilder.param("account", "business");
		mockHttpServletRequestBuilder.param("type", "small");
		mvc.perform(mockHttpServletRequestBuilder).andExpect(status().isNotImplemented()).andDo(print());

	}
	
	@Test
	public void test7() throws Exception {

		MockHttpServletRequestBuilder mockHttpServletRequestBuilder = MockMvcRequestBuilders.get("/greeting");
		mockHttpServletRequestBuilder.param("account", "business");
		mockHttpServletRequestBuilder.param("type", "big");
		mvc.perform(mockHttpServletRequestBuilder).andExpect(status().isOk()).andDo(print());

	}
	
	@Test
	public void test8() throws Exception {

		MockHttpServletRequestBuilder mockHttpServletRequestBuilder = MockMvcRequestBuilders.get("/greeting");
		mockHttpServletRequestBuilder.param("account", "blabla");
		mockHttpServletRequestBuilder.param("type", "small");
		mvc.perform(mockHttpServletRequestBuilder).andExpect(status().isBadRequest()).andDo(print());

	}
	
	@Test
	public void test9() throws Exception {

		MockHttpServletRequestBuilder mockHttpServletRequestBuilder = MockMvcRequestBuilders.get("/greeting");
		mockHttpServletRequestBuilder.param("id", "10");
		mockHttpServletRequestBuilder.param("type", "big");
		mvc.perform(mockHttpServletRequestBuilder).andExpect(status().isBadRequest()).andDo(print());

	}

}
