package es.unican.ps.uchoteles.daoLayer.impl;

import java.util.List;

import es.unican.ps.uchoteles.daoLayer.IHotelesDAOLocal;
import es.unican.ps.uchoteles.daoLayer.IHotelesDAORemote;
import es.unican.ps.uchoteles.entities.Hotel;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityExistsException;
import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;

@Stateless
public class HotelesDAO implements IHotelesDAOLocal, IHotelesDAORemote {

    @PersistenceContext(unitName="HotelesPU")
    private EntityManager em;

    
    public Hotel creaHotel(Hotel hotel) {
    	try {
            em.persist(hotel);
    	} catch (EntityExistsException e) {
    		return null;
    	}
        return hotel;
    }

    public Hotel eliminaHotel(String nombre, String localidad) {
        Hotel hotel = hotel(nombre, localidad);
        if (hotel != null) {
            em.remove(hotel);
        }
        return hotel;
    }

    public Hotel actualizarHotel(Hotel hotel) {
        return em.merge(hotel);
    }

    
    public Hotel hotel(String nombre, String localidad) {
    	Query q = em.createQuery("SELECT h FROM Hotel h WHERE h.nombre = :nom AND h.localidad = :loc");
        q.setParameter("nom", nombre);
        q.setParameter("loc", localidad);
        try {
        	return (Hotel) q.getSingleResult();
        } catch (NoResultException e) {
        	return null;
        }
	}
    
    @SuppressWarnings("unchecked")
    public List<Hotel> hoteles() {
        Query q = em.createQuery("SELECT h FROM Hotel h");
        return (List<Hotel>) q.getResultList();
    }	
}
