package br.com.app.json;

import java.io.Serializable;
import java.util.List;

/**
 * 
 * Esse wrapper é um empacotador pra poder mandar qualquer entidade para a tela.
 * 
 * Caso precise de um empacotador de JSON especial para o ExtJS é só criar um ExtWrapper<T> 
 * 
 * @author pazin
 *
 * @param <T>
 */
public class JSONListWrapper<T> implements Serializable {

	private static final long serialVersionUID = 1L;

	private List<T> rows;
	
	private int total;
	
	public JSONListWrapper(List<T> rows, int total){
		this.rows = rows;
		this.total = total;
	}
	
	public JSONListWrapper(List<T> rows, Long total){
		this.rows = rows;
		this.total = total.intValue();
	}
	

	public List<T> getRows()
	{
		return rows;
	}

	public int getTotal(){
		return total;
	}
}
