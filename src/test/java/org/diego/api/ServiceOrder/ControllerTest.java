package org.diego.api.ServiceOrder;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import java.io.IOException;

import org.diego.api.serviceorder.ServiceOrderApplication;
import org.diego.api.serviceorder.model.Cliente;
import org.junit.Assert;
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
@AutoConfigureTestDatabase
public class ControllerTest {

	@Autowired
	private MockMvc mockMvc;

	@Test
	public void testSalvaRecuperaRemoveCliente() throws Exception {
		Cliente cliente = montaCliente();
		mockMvc.perform(post("/cliente").contentType(MediaType.APPLICATION_JSON).content(toJson(cliente)))
				.andExpect(status().isOk()).andDo(print());
		mockMvc.perform(get("/cliente/1").contentType(MediaType.APPLICATION_JSON)).andDo(print())
				.andExpect(status().isOk()).andReturn().getResponse();
		cliente.setTelefone("11 9988745");
		cliente.setId(1);
		mockMvc.perform(put("/cliente").contentType(MediaType.APPLICATION_JSON).content(toJson(cliente)))
				.andExpect(status().isOk()).andDo(print());
		mockMvc.perform(delete("/cliente/1"))
				.andExpect(status().isOk()).andDo(print()).andReturn().getResponse().getContentAsString();
	}

	@Test
	public void testRecuperarClienteNaoCadastrado() throws Exception {
		mockMvc.perform((get("/cliente/1222"))).andDo(print()).andExpect(status().isNoContent());
	}

	@Test
	public void testAtualizaClienteNaoCadastrado() throws Exception {
		mockMvc.perform(put("/cliente").contentType(MediaType.APPLICATION_JSON).content(toJson(montaCliente())))
				.andExpect(status().isNotAcceptable()).andDo(print());
	}

	private Cliente montaCliente() {
		Cliente cliente = new Cliente();
		cliente.setCidade("Curitiba");
		cliente.setEmail("email@amfil.com");
		cliente.setEndereco("Rua endereco");
		cliente.setNome("Jose Mourinho");
		cliente.setUf("PR");
		cliente.setTelefone("41 555441122");
		cliente.setNumDocumento(987456112L);
		return cliente;
	}

	private static byte[] toJson(Object object) throws IOException {
		ObjectMapper mapper = new ObjectMapper();
		mapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
		return mapper.writeValueAsBytes(object);
	}

}
