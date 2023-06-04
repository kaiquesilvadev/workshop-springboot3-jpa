package com.example.demo.comtroller;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.example.demo.entity.User;
import com.example.demo.repositories.UserRepository;
import com.example.demo.services.UserServices;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)//A anotação cria e inicializa o nosso ambiente de testes.
@TestInstance(TestInstance.Lifecycle.PER_CLASS)//A anotação permite modificar o ciclo de vida da Classe de testes.
public  class UserControllerTest {

	@Autowired
	private TestRestTemplate testRestTemplate;//injetado, um objeto da Classe TestRestTemplate para enviar as requisições para a nossa aplicação.
	
	@Autowired
	private UserServices userServices;
	
	@Autowired
	private UserRepository userRepository;
	
	void start() {//apaga todos os dados da tabela e cria o usuário root@root.com para testar os Métodos protegidos por autenticação.
		userRepository.deleteAll();
		
		userServices.insert(new User(0L, "root", "root@root.com"," ","rootroot"));
	}
	
	@Test
	@DisplayName("cadastrar um usuário")//mensagem que será exibida ao invés do nome do Método.
	public void deveCriarUmUser() {
		
		HttpEntity<User> corpoRequisicao = new HttpEntity<User>(new User(0L,"paulo","paulo@email.com.br","-","paulo123"));
		
		ResponseEntity<User> corpoResposta = testRestTemplate
				.exchange("/Users/cadastrar", HttpMethod.POST, corpoRequisicao, User.class);
		
		assertEquals(HttpStatus.CREATED,corpoResposta.getStatusCode());
	}
}
