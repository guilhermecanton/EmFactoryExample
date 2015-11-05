package br.com.crud.negocio;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import br.com.crud.modelo.EmFactory;
import br.com.crud.modelo.Pessoa;

public class PessoaDAO implements DAO<Pessoa, Long>{

	@Override
	public Pessoa insert(Pessoa t) throws Exception {
		EntityManager manager = EmFactory.instance().createEntityManager();
		try {
			EntityTransaction tx = manager.getTransaction();
			tx.begin();
			manager.persist(t);
			tx.commit();
		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			manager.close();
		}
		return t;
	}

	@Override
	public Pessoa update(Pessoa t) throws Exception {
		EntityManager manager = EmFactory.instance().createEntityManager();
		try {
			EntityTransaction tx = manager.getTransaction();
			tx.begin();
			manager.merge(t);
			tx.commit();
		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			manager.close();
		}
		return t;
	}

	@Override
	public void delete(Pessoa t) throws Exception {
		EntityManager manager = EmFactory.instance().createEntityManager();
		try {
			EntityTransaction tx = manager.getTransaction();
			tx.begin();
			Object c = manager.merge(t);
			manager.remove(c);
			tx.commit();
		} catch (Exception e) {
			System.out.println(e);
		} finally {
			manager.close();
		}

	}

	@Override
	public Pessoa find(Long k) throws Exception {
		EntityManager manager = EmFactory.instance().createEntityManager();
		try {
			EntityTransaction tx = manager.getTransaction();
			tx.begin();
			return manager.find(Pessoa.class, k);
		} catch (Exception e) {
			// TODO: handle exception
		}finally {
			manager.close();
		}		
		return null;
	}

	@Override
	public List findAll() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

}
