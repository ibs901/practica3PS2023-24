package es.unican.ps.hoteles.daoLayer.impl;

import java.util.List;

import es.unican.ps.hoteles.daoLayer.IHotelesDAOLocal;
import es.unican.ps.hoteles.daoLayer.IHotelesDAORemote;
import es.unican.ps.hoteles.entities.Hotel;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;

@Stateless
public class HotelesDAO implements IHotelesDAOLocal, IHotelesDAORemote {

    @PersistenceContext(unitName = "HotelesPU")
    private EntityManager em;

    public Hotel creaHotel(Hotel hotel) {
        em.persist(hotel);
        return hotel;
    }

    public Hotel eliminaHotel(String idHotel) {
        Hotel hotel = em.find(Hotel.class, idHotel);
        if (hotel != null) {
            em.remove(hotel);
        }
        return hotel;
    }

    public Hotel actualizarHotel(Hotel hotel) {
        return em.merge(hotel);
    }

    public Hotel hotelPorLocalidad(String localidad) {
        Query q = em.createQuery("SELECT h FROM Hotel h WHERE h.localidad = :localidad");
        q.setParameter("localidad", localidad);
        return (Hotel) q.getSingleResult();
    }

    public Hotel hotelPorNombre(String nombre) {
        Query q = em.createQuery("SELECT h FROM Hotel h WHERE h.nombre = :nombre");
        q.setParameter("nombre", nombre);
        return (Hotel) q.getSingleResult();
    }

    public List<Hotel> hoteles() {
        Query q = em.createQuery("FROM Hotel h");
        return (List<Hotel>) q.getResultList();
    }
}
