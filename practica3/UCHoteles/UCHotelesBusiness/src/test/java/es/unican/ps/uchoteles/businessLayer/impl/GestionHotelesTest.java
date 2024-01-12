package es.unican.ps.uchoteles.businessLayer.impl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import es.unican.ps.uchoteles.daoLayer.IHotelesDAOLocal;
import es.unican.ps.uchoteles.entities.Hotel;

public class GestionHotelesTest {
	
	@Mock
	private IHotelesDAOLocal hotelesDAO;
		
	private GestionHoteles sut;
		
	List<Hotel> inicial, soloh1, soloh3, h1yh3, h1yh1Santander, vacia;
	Hotel h1, h1Santander, h3;
	
	
	@BeforeEach
	public void inicializa() {
		MockitoAnnotations.initMocks(this);
		sut = new GestionHoteles(hotelesDAO);
		inicial = new ArrayList<Hotel>();
		soloh1 = new ArrayList<Hotel>();
		soloh3 = new ArrayList<Hotel>();
		h1yh3 = new ArrayList<Hotel>();
		h1yh1Santander = new ArrayList<Hotel>();
		vacia = new ArrayList<Hotel>();
		
		h1 = new Hotel("h1", "Torrelavega");
		h1Santander = new Hotel("h1", "Santander");
		h3 = new Hotel("h3", "Torrelavega");
		
		inicial.add(h1);
		inicial.add(h1Santander);
		inicial.add(h3);
		
		soloh1.add(h1);
		
		soloh3.add(h3);
		
		h1yh1Santander.add(h1);
		h1yh1Santander.add(h1Santander);
		
		h1yh3.add(h1);
		h1yh3.add(h3);
		
		when(hotelesDAO.hoteles()).thenReturn(inicial);
	}
	
	
	@Test
	public void consultarHotelesTest() {
		
		// Caso se pasan strings vacios por parametros se muestran todos
		assertEquals(inicial, sut.consultarHoteles("", ""));
		
		// Caso se pasan nulos por parametros se muestran todos
		assertEquals(inicial, sut.consultarHoteles(null, null));
		
		// Caso solo se muestran por nombre
		assertEquals(h1yh1Santander, sut.consultarHoteles("h1", null));
		
		// Caso solo se muestran por localidad
		assertEquals(h1yh3, sut.consultarHoteles(null, "Torrelavega"));
		
		// Caso se muestran por nombre y localidad
		assertEquals(soloh1, sut.consultarHoteles("h1", "Torrelavega"));
		
		// Caso no hay hoteles con ese nombre si solo se busca por nombre
		assertEquals(vacia, sut.consultarHoteles("h4", null));

		// Caso no hay hoteles con esa localidad si solo se busca por localidad
		assertEquals(vacia, sut.consultarHoteles(null, "Potes"));

		// Caso no hay hoteles con ambas
		assertEquals(vacia, sut.consultarHoteles("h4", "Potes"));
		verify(hotelesDAO, times(8)).hoteles(); // Comprobamos que se ha hecho la busqueda segun los
												// elementos de la dao en todos los casos

	}
}
