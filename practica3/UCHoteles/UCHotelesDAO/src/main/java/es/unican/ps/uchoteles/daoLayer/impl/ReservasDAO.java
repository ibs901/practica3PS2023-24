package es.unican.ps.uchoteles.daoLayer.impl;

import java.util.List;

import es.unican.ps.uchoteles.daoLayer.IReservasDAOLocal;
import es.unican.ps.uchoteles.daoLayer.IReservasDAORemote;
import es.unican.ps.uchoteles.entities.Reserva;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityExistsException;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;

@Stateless
public class ReservasDAO implements IReservasDAOLocal, IReservasDAORemote {

    @PersistenceContext(unitName="HotelesPU")
	private EntityManager em;
	
	public Reserva creaReserva(Reserva reserva) {
		// TODO Auto-generated method stub
		try {
            em.persist(reserva);
    	} catch (EntityExistsException e) {
    		return null;
    	}
        return reserva;
	}

	public Reserva eliminaReserva(long idReserva) {
		// TODO Auto-generated method stub
		Reserva reserva = em.find(Reserva.class, idReserva);
        if (reserva != null) {
            em.remove(reserva);
        }
        return reserva;
	}

	public Reserva actualizarReserva(Reserva reserva) {
		// TODO Auto-generated method stub
		return em.merge(reserva);
	}

	public Reserva reserva(long idReserva) {
		return em.find(Reserva.class, idReserva);
	}

	@SuppressWarnings("unchecked")
	public List<Reserva> reservas() {
		// TODO Auto-generated method stub
		Query q = em.createQuery("SELECT r FROM Reserva r");
		return (List<Reserva>) q.getResultList();
	}

}
