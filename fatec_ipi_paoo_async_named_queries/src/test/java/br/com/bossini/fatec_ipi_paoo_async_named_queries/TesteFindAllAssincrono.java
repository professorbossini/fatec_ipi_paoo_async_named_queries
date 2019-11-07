package br.com.bossini.fatec_ipi_paoo_async_named_queries;

import java.util.List;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import br.com.bossini.fatec_ipi_paoo_async_named_queries.model.beans.Aluno;
import br.com.bossini.fatec_ipi_paoo_async_named_queries.model.repository.AlunoRepository;

@SpringBootTest
@RunWith (SpringRunner.class)
public class TesteFindAllAssincrono {
	
	@Autowired
	private AlunoRepository alunoRepo;
	
	@Test
	public void testFindAllAssincrono() throws Exception{
		Future < List <Aluno> > future = alunoRepo.findByNome("Ana");
		System.out.println("mais coisas aqui..");
		System.out.println("mais um pouco aqui...");
		//List <Aluno> alunos = future.get();
		try {
			List <Aluno> alunos = future.get(100, TimeUnit.SECONDS);
			alunos.forEach(System.out::println);
		}
		catch (TimeoutException e) {
			e.printStackTrace();
		}
	}
	
	

}
