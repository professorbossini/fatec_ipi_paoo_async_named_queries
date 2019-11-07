package br.com.bossini.fatec_ipi_paoo_async_named_queries.model.repository;

import java.util.List;
import java.util.concurrent.Future;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.scheduling.annotation.Async;

import br.com.bossini.fatec_ipi_paoo_async_named_queries.model.beans.Aluno;

public interface AlunoRepository extends JpaRepository<Aluno, Long> {
	
	@Async
	public Future <List <Aluno>> findByNome (String nome);
	
	@Query ("SELECT a FROM Aluno a WHERE a.email = ?1")
	public Aluno buscarUmAlunoPeloSeuEmail (String email);
	
	@Query ("SELECT a FROM Aluno a WHERE a.nome LIKE ?1%")
	public List <Aluno> buscarTodosComLetraInicial (String letra);
	
	
	@Query ("SELECT a FROM Aluno a WHERE a.fone = :f")
	public List <Aluno> buscarPorTelefone ( @Param ("f") String telefone);
	
	public Aluno buscarPeloNomeEPeloEmail (@Param ("nome") String x, @Param ("email") String y);

}
