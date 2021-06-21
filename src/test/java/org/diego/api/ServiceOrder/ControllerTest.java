package org.diego.api.ServiceOrder;

import static org.junit.Assert.assertNotNull;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.io.IOException;

import org.diego.api.serviceorder.ServiceOrderApplication;
import org.diego.api.serviceorder.dto.Cliente;
import org.diego.api.serviceorder.service.ClienteService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.ObjectMapper;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = ServiceOrderApplication.class, webEnvironment = SpringBootTest.WebEnvironment.MOCK)
@AutoConfigureMockMvc
//@TestPropertySource(locations = "classpath:application-integrationtest.properties")
@AutoConfigureTestDatabase
public class ControllerTest {

	@Autowired
	private ClienteService clienteService;
	@Autowired
	private MockMvc mockMvc;

	@Test
	public void testSalvarCliente() throws Exception {
		String retorno = mockMvc
				.perform(post("/cliente").contentType(MediaType.APPLICATION_JSON).content(toJson(montaCliente())))
				.andExpect(status().isOk()).andDo(print()).andReturn().getResponse().getContentAsString();
		assertNotNull(retorno);
	}

	@Test
	public void testRecuperarCliente() throws Exception {
		clienteService.saveCliente(montaCliente());
		mockMvc.perform(get("/cliente/1").contentType(MediaType.APPLICATION_JSON)).andDo(print())
				.andExpect(status().isOk());
	}

	private Cliente montaCliente() {
		Cliente cliente = new Cliente();
		cliente.setCidade("Curitiba");
		cliente.setEmail("email@amfil.com");
		cliente.setEndereco("Rua endereco");
		cliente.setNome("Jose Mourinho");
		cliente.setUf("PR");
		cliente.setTelefone("41 555441122");
		return cliente;
	}

	private static byte[] toJson(Object object) throws IOException {
		ObjectMapper mapper = new ObjectMapper();
		mapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
		return mapper.writeValueAsBytes(object);
	}
}
