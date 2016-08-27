package br.com.app.business;

import java.util.List;

import javax.persistence.EntityManager;

import org.apache.commons.lang3.StringUtils;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.app.DAO.ClienteRepository;
import br.com.app.model.Cliente;


/**
 * Essa é a classe Business
 * 
 * @author pazin
 *
 */
@Service
public class ClienteService {
	
	@Autowired
	private ClienteRepository clienteRepo;
	
	@Autowired
	private EntityManager entityManager;
	
	
	// Atenção pra poder usar o Session do Hibernate o método tem que estar em uma Transação. Por isso a Annotation é importante.
	@Transactional
	public List<Cliente> exemploCriteriaHibernate( String cnpj ){
		
		// DÁ PRA USAR O CRITERIA DO HIBERNATE COM O ENTITY MANAGER DO JPA!!!!!!!! 

		Session session = entityManager.unwrap( Session.class );
		
		Criteria crit = session.createCriteria( Cliente.class );
		
		crit.add( Restrictions.eq( "cnpj", cnpj ) );
		
		List<Cliente> result = crit.list();

		return result;
	}


	@Transactional
	public Cliente saveCliente( Cliente clienteVO )
	{
		if ( clienteVO.getAtivo() == null )
			clienteVO.setAtivo( false );
 
		if ( StringUtils.isNotBlank( clienteVO.getCnpj() ) )
			clienteVO.setCnpj( clienteVO.getCnpj().replaceAll("\\D+","") );
		
		boolean clienteNovo = clienteVO.getIdCliente() == null;
		
		if ( clienteNovo )
		{
			Cliente clienteExistente = clienteRepo.findByCnpj( clienteVO.getCnpj() );
			
			if ( clienteExistente != null )
				throw new RuntimeException( "Cliente já existe no banco de dados." );
		}
		
		clienteRepo.save( clienteVO );

		return clienteVO;
	}


	
	/**
	 * Select * from 
	 * 
	 * @param pageable
	 * @return
	 */
	public Page<Cliente> findAll( Pageable pageable ){
		
		Page<Cliente> page = clienteRepo.findAll( pageable );
		
		return page;
	}
	
	
	
	public Cliente findOne( Long idCliente ){
		return clienteRepo.findOne( idCliente );
	}
	

}
