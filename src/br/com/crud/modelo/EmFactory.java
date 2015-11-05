package br.com.crud.modelo;


import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;




public class EmFactory {
	
	static public String PERSISTENCE_CONTEXT = "crud-pu";
	
	private static EntityManagerFactory fabrica;
	
	private static EmFactory _instancia;

	public static synchronized EmFactory instance() {
		if (_instancia == null) {
			_instancia = new EmFactory();
		}
		return _instancia;
	}
	
	private EmFactory(){
		try {
			
			
			if (fabrica == null) {
				fabrica = Persistence.createEntityManagerFactory( PERSISTENCE_CONTEXT );
			}	
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	public EntityManager createEntityManager() {
		
		try {
			
			return fabrica.createEntityManager();
			
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("ERRO: EntityManager não pode ser criado.");
			return null;
		}
	}

}
