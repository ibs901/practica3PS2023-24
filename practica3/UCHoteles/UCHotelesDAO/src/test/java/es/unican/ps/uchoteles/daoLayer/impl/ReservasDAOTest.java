package es.unican.ps.uchoteles.daoLayer.impl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import es.unican.ps.uchoteles.entities.Reserva;
import jakarta.persistence.EntityManager;

public class ReservasDAOTest {
	
	@Mock
	private EntityManager em;
	
	private ReservasDAO sut;
	
	private long idExistente, idInexistente;
	
	private Reserva reservaExistente;
	
	@BeforeEach
	public void inicializa() {
		MockitoAnnotations.initMocks(this);
		sut = new ReservasDAO(em);
		idExistente = 1;
		reservaExistente = new Reserva();
		
		when(em.find(Reserva.class, idExistente)).thenReturn(reservaExistente);
		when(em.find(Reserva.class, idInexistente)).thenReturn(null);
	}

	@Test
	public void eliminaReservaTest() {
		
		// El id no existe
		assertNull(sut.eliminaReserva(idInexistente));
		verify(em).find(Reserva.class, idInexistente);
		verify(em, never()).remove(any());
		
		// El id existe
		assertEquals(reservaExistente, sut.eliminaReserva(idExistente));
		verify(em).remove(reservaExistente);
	}
}
