package br.edu.ifpe.recife.gcms.WebApp;

import static org.hamcrest.Matchers.containsString;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class WebAppApplicationTests {
	@Autowired
	private MockMvc mockMvc;

	@Test
	public void shouldReturnDefaultMessage() throws Exception {
		this.mockMvc.perform(get("/")).andDo(print()).andExpect(status().isOk())
				.andExpect(content().string(containsString("Hello, World")));
	}
	
	@Test
	public void shouldReturnDefaultMessageVictor() throws Exception {
		this.mockMvc.perform(get("/victor")).andDo(print()).andExpect(status().isOk())
				.andExpect(content().string(containsString("Hello, Víctor")));
	}

	@Test
	public void shouldReturnDefaultMessageHotfix() throws Exception {
		this.mockMvc.perform(get("/victor")).andDo(print()).andExpect(status().isOk())
				.andExpect(content().string(containsString("Hello, Hotfix")));
	}
}
