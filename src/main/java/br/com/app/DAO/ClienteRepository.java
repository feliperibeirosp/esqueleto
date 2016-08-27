package br.com.app.DAO;

import java.util.Date;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import br.com.app.model.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {

	
	/**
	 * 
	 * Para entender direitinho como montar esses métodos a documentação fica em :
	 * 
	 * http://docs.spring.io/spring-data/data-jpa/docs/current/reference/html/
	 * 
	 * 
	 * Se você precisar fazer um Criteria... não é aqui no DAO. Tem que fazer na camada Business ( ou então fazer uma classe Repository que Implementa essa mesma JpaRepository )
	 *   
	 */

	// Pegar por código
	Cliente findByCodigo( String codigo );
	
	// Contar ativos
	Long countByAtivo( Boolean ativo );
	
	// Pegar por CNPJ
	Cliente findByCnpj( String cnpj );
	
	// Retorna uma lista simples
	List<Cliente> findByRazaosocialContainingIgnoreCase( String razaosocial );

	// Mesma query de antes porém Paginada
	Page<Cliente> findByRazaosocialContainingIgnoreCase( Pageable pageable, String razaosocial );

	
	// Esse @Modifying é pra comandos de UPDATE ou DELETE
	@Modifying
    @Query( value = "DELETE FROM CLIENTE WHERE ID_CLIENTE IN :ids", nativeQuery = true )   // perceba que esse comando não é HQL nem JPQL é nativo
    int deleteByIds( @Param("ids") List<Long> idsClientes );
	
//	// Essa é uma query HQL / JPQL
	@Query( "SELECT C FROM Cliente C WHERE C.dataCriacao = ?1 " )
	List<Cliente> findByDataCriacao( Date dataCriacao );


	// Esse clear aqui faz o Flush automatico
	@Modifying(clearAutomatically=true)
	@Query("update Cliente c set c.ativo = ?1 where c.idCliente = ?2 ")
	int setAtivoFor( Boolean ativo, Long idCliente );

}
