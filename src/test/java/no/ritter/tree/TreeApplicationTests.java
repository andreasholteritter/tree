package no.ritter.tree;

import com.google.gson.Gson;
import no.ritter.tree.entity.Tree;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;

import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.List;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.jupiter.api.Assertions.assertEquals;

import static org.hamcrest.Matchers.equalTo;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class TreeApplicationTests {

	@Autowired
	private MockMvc mvc;

	@BeforeAll
	public void beforeAll() throws Exception {
		mvc.perform(MockMvcRequestBuilders.delete("/tree/delete-all").accept(MediaType.APPLICATION_JSON))
				.andExpect(status().isAccepted());
	}

	@Test
	public void getHello() throws Exception {
		mvc.perform(MockMvcRequestBuilders.get("/tree/hello").accept(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk())
				.andExpect(content().string(equalTo("Hello world")));
	}

	@Test
	public void createAndGet() throws Exception {
		Tree tree = new Tree();
		tree.setName("test tree");

		Gson gson = new Gson();
		String json = gson.toJson(tree);

		MvcResult entityIdResult = mvc.perform(MockMvcRequestBuilders
					.post("/tree/")
					.accept(MediaType.APPLICATION_JSON)
					.contentType(MediaType.APPLICATION_JSON)
					.content(json))
				.andExpect(status().isOk())
				.andReturn();

		int entityId = Integer.valueOf(entityIdResult.getResponse().getContentAsString());

		MvcResult entityTreeResult = mvc.perform(MockMvcRequestBuilders.get("/tree/id/" + entityId).accept(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk())
				.andReturn();

		String entityTree = entityTreeResult.getResponse().getContentAsString();

		Tree returnTree = gson.fromJson(entityTree, Tree.class);
		assertEquals(returnTree.getId(), entityId, "check if return id and id on return object matches");
	}
}
