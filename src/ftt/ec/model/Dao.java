package ftt.ec.model;

import java.util.ArrayList;

// Referência: https://cursos.alura.com.br/forum/topico-dao-generica-61881

public interface Dao {
	
	public void insert(Object obj);
	
	public void update(Object obj);
	
	public void delete(Object obj);
	
	public Object find(Object obj);
	
	public ArrayList<Object> findAll(Object obj);
	
}
