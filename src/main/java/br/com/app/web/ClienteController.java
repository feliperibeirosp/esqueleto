package br.com.app.web;

import java.security.Principal;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import br.com.app.business.ClienteService;
import br.com.app.config.web.WebAppConfig;
import br.com.app.json.JSONBootstrapGridWrapper;
import br.com.app.model.Cliente;



@Controller
public class ClienteController extends AbstractController {

	// Injetando a classe de business
	@Autowired
	private ClienteService clienteService;


	/** 
	 * Para retornar uma tela esse método só precisa retornar o nome dela.
	 * 
	 * O Spring vai concatenar automaticamente o prefixo "WEB-INF/views/" com o retorno desse método mais o sufixo ".jsp"
	 * 
	 * Ou seja vai retornar o jsp que fica em "WEB-INF/views/index.jsp"
	 * 
	 * Essa concatenação foi configurada no {@link WebAppConfig#getInternalResourceViewResolver()}
	 */
	@RequestMapping(value="/", method=RequestMethod.GET)
	public String home( HttpServletRequest request, ModelMap model )
	{
		return "index";
	}


	@RequestMapping( value = { "/clientes/{idCliente}", "/api/clientes/{idCliente}" }, method = RequestMethod.GET, produces = APPLICATION_JSON_CHARSET_UTF_8 )
	public @ResponseBody Cliente getCliente( @PathVariable Long idCliente, 
											 Principal principal  )
	{
		return clienteService.findOne( idCliente );
	}



	/**
	 * Retorno anotado com @ResponseBody significa que vai retornar um recurso (Ex nesse caso: json de cliente). 
	 * 
	 * Se não anotar e retornar uma string o spring vai entender como se a string fosse o nome de um JSP (igual no "home" desse controller)
	 * 
	 * @param cliente
	 * @param result
	 * @param principal
	 * @return
	 */
	@RequestMapping( value = { "/clientes", "/api/clientes" }, method = { RequestMethod.POST }, consumes = "application/json", produces = APPLICATION_JSON_CHARSET_UTF_8 )
	public @ResponseBody String saveCliente( 
									@RequestBody @Valid Cliente cliente, 
									BindingResult result, 
									Principal principal )
	{
		String jsonResult = null;
		
		if ( result.hasErrors() ){
			
			jsonResult = writeErrorsAsJSONErroMessage(result);	
		}
		else
		{
			try
			{
				cliente  = clienteService.saveCliente( cliente );
				
				jsonResult = writeObjectAsString( cliente );
			}
			catch ( Exception e )
			{
				e.printStackTrace();
				jsonResult = writeSingleErrorAsJSONErroMessage( "alertArea", e.getMessage() );
			}
		}

		return jsonResult;
	}



	@RequestMapping( value = { "/clientes", "/api/clientes" }, method = RequestMethod.GET, produces = APPLICATION_JSON_CHARSET_UTF_8 )
	public @ResponseBody JSONBootstrapGridWrapper<Cliente> listClientes( 
																 @RequestParam(value="search", required=false) String search, 
																 @RequestParam(value="pageNumber", required=false) Integer pageNumber, 
																 @RequestParam(value="limit", required=false) Integer limit
																 )
	{
		// O pageable define como vamos ordenar e por quais campos vamos ordenar...
		Pageable pageable = getPageable( pageNumber, limit, "asc", "razaosocial" );
		
		Page<Cliente> clientePage = clienteService.findAll( pageable );
		
		// Esse Wrapper é pra poder exportar para a grid.... 
		JSONBootstrapGridWrapper<Cliente> jsonList = new JSONBootstrapGridWrapper<Cliente>( clientePage.getContent(), clientePage.getTotalElements() );

		return jsonList;
	}


}
