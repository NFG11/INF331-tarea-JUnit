package com.tarea.junit;

import static org.junit.Assert.assertEquals;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

public class MaquinaCafeTest {
	
	private MaquinaCafe cafetera;
	private MaquinaCafe cafetera2;
	
	@Before
	public void setUp() throws Exception {
		cafetera = new MaquinaCafe();
		cafetera2 = new MaquinaCafe();
	}
	
	@Test
	public void testAgregarInventario() {
		System.out.println("testAgregarInventario()");
		System.out.println("Debe ingresar '2' para todos los inputs");
		int[] inventarioBefore = new int[4];
		for (int i = 0; i < 4; i++) {
			inventarioBefore[i] = cafetera.getInventario().get(i).getCantidadActual();
		}
		
		int[] inventarioAgregado = {2, 2, 2, 2};
		cafetera.agregarInventario();
		
		for (int i = 0; i < 4; i++) {
			assertEquals(inventarioBefore[i] + inventarioAgregado[i], cafetera.getInventario().get(i).getCantidadActual());
		}
	}
	
	@Test
	public void testcomprarBebida() {
		System.out.println("testcomprarBebida()");
		
		System.out.println("Debe ingresar '10', '10', '10' y '10'");
		cafetera2.agregarInventario();
		int[] inventarioBefore = new int[4];
		for (int i = 0; i < 4; i++) {
			inventarioBefore[i] = cafetera2.getInventario().get(i).getCantidadActual();
		}
		
		System.out.println("Debe ingresar '3' y '2000'");
		cafetera2.comprarBebida();
		int[] inventarioQuitado = {2, 3, 10, 5};
		
		for (int i = 0; i < 4; i++) {
			assertEquals(inventarioBefore[i] - inventarioQuitado[i], cafetera2.getInventario().get(i).getCantidadActual());
		}
	}
}
