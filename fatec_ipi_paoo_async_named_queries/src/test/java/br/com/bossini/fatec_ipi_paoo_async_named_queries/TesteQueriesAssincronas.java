package br.com.bossini.fatec_ipi_paoo_async_named_queries;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import br.com.bossini.fatec_ipi_paoo_async_named_queries.model.beans.Aluno;
import br.com.bossini.fatec_ipi_paoo_async_named_queries.model.repository.AlunoRepository;

@SpringBootTest
@RunWith (SpringRunner.class)
public class TesteQueriesAssincronas {

	@Autowired
	private AlunoRepository alunoRepo;
	
	@Test
	public void test() {
		List <Aluno> alunos = alunoRepo.buscarTodosComLetraInicial("a");
		alunos.forEach(System.out::println);
		Aluno unicoAluno = alunoRepo.buscarUmAlunoPeloSeuEmail("ana@fatec.br");
		System.out.println(unicoAluno);
	}
}
