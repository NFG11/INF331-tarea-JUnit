package com.tarea.junit;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

public class InventarioTest {
	
	private Inventario cafe;
	private Inventario leche;
	private Inventario chocolate;
	private Inventario azucar;
	
	@Before
	public void setUp() throws Exception {
		cafe = new Inventario("Café", 10, 0);
		leche = new Inventario("Leche", 80, 0);
		chocolate = new Inventario("Chocolate", 10, 5);
		azucar = new Inventario("Azúcar", 40, 20);
	}

	@Test
	public void testAddCantidad() {
		int cantidadInicial = cafe.getCantidadActual();
		int cantidadAgregada = 5;
		boolean resultado = cafe.addCantidad(cantidadAgregada);
		
		assertTrue(resultado);
		assertEquals(cafe.getCantidadActual(), cantidadInicial + cantidadAgregada);
	}
	
	@Test
	public void testAddCantidadFallo() {
		int cantidadInicial = leche.getCantidadActual();
		int cantidadAgregada = 81;
		boolean resultado = leche.addCantidad(cantidadAgregada);
		
		assertFalse(resultado);
		assertEquals(leche.getCantidadActual(), cantidadInicial);
	}
	
	@Test
	public void testQuitarCantidad() {
		int cantidadInicial = chocolate.getCantidadActual();
		int cantidadQuitada = 2;
		chocolate.quitarCantidad(cantidadQuitada);
		
		assertEquals(chocolate.getCantidadActual(), cantidadInicial - cantidadQuitada);
	}
	
	@Test
	public void testQuitarCantidadFallo() {
		int cantidadInicial = azucar.getCantidadActual();
		int cantidadQuitada = 100;
		azucar.quitarCantidad(cantidadQuitada);
		
		assertEquals(azucar.getCantidadActual(), cantidadInicial);
	}
}
