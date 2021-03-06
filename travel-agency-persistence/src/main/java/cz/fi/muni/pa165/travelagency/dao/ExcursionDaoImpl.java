package cz.fi.muni.pa165.travelagency.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import cz.fi.muni.pa165.travelagency.entity.Excursion;

/**
 * dao implementation for Excursion entity
 * 
 * @author Julius Stassik
 */
@Repository
public class ExcursionDaoImpl implements ExcursionDao {

	@PersistenceContext
	private EntityManager em;
	
	
	@Override
	public void create(Excursion excursion) {
		em.persist(excursion);		
		
	}

	@Override
	public void delete(Excursion excursion) {
		em.remove(getById(excursion.getId()));
		
	}

	@Override
	public void update(Excursion excursion) {
		em.merge(excursion);
		
	}

	@Override
	public Excursion getById(Long id) {
		return em.find(Excursion.class, id);
	}

	@Override
	public List<Excursion> getAll() {
		return em.createQuery("SELECT e FROM Excursion e", 
				Excursion.class).getResultList();
	}

	
    
}