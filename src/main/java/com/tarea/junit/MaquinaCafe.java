package com.tarea.junit;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MaquinaCafe {
	private List<Inventario> inventario;
	private List<Receta> recetas;
	private static final Scanner scanner = new Scanner(System.in);
	
	public MaquinaCafe() {
		super();	
		inventario = new ArrayList<Inventario>();
		recetas = new ArrayList<Receta>();
		
		configuracionInicial();
	}

	public void agregarInventario() {
		for (Inventario inv : this.inventario) {
			while (true) {
				System.out.printf("%s: ", inv.getTipo());
				int cantidad = getIntegerInput();
				if (cantidad < 0) {
					System.out.println("Valor incorrecto. Ingresa otro valor.");
					continue;
				}
				
				boolean success = inv.addCantidad(cantidad); 
				if (!success) { 
					System.out.println("El valor ingresado excede la capacidad máxima. Ingresa otro valor."); 
					continue; 
				}
				 
				break;
			}
		}
	}
	
	public void verificarInventario() {
		for (Inventario inv : this.inventario) {
			System.out.printf("- %s: %d/%d\n", inv.getTipo(), inv.getCantidadActual(), inv.getMaxSoportado());
		}
	}
	
	public void comprarBebida() {
		for (int i = 0; i < 3; i++) {
			System.out.printf("%d. %s ($%d).\n", i+1, this.recetas.get(i).getNombre(), this.recetas.get(i).getPrecio());
		}
		
		System.out.print("Ingresa tu bebida: ");
		int opcion = getIntegerInput();
		while (opcion <= 0 || opcion >= 4) {
			System.out.println("Opción incorrecta. Ingresa una receta valida.");
			System.out.print("Ingresa tu bebida: ");
			opcion = getIntegerInput();
		}
		opcion -= 1;
		
		System.out.print("Por favor, ingresa el dinero: ");
		int dinero = getIntegerInput();
		while (dinero < 0) {
			System.out.println("Valor invalido!. Ingresa un valor valido.");
			System.out.print("Por favor, ingresa el dinero: ");
			dinero = getIntegerInput();
		}
				
		if (dinero < this.recetas.get(opcion).getPrecio()) {
			System.out.println("\nNo tienes suficiente dinero.");
			System.out.printf("Dinero devuelto: $%d\n", dinero);
			return;
		}
		
		if (!haySuficienteInventario(opcion)) {
			System.out.println("\nNo hay suficiente inventario.");
			System.out.printf("Dinero devuelto: $%d\n", dinero);
			return;
		}
		
		actualizarIngredientes(opcion);
		System.out.printf("\nSu bebida %s esta lista\n", this.recetas.get(opcion).getNombre());
		System.out.printf("Dinero devuelto: $%d\n", dinero - this.recetas.get(opcion).getPrecio());
	}
	
	private boolean haySuficienteInventario(int opcion) {
		int[] ing = this.recetas.get(opcion).getIngredientes();
		for (int i = 0; i < 4; i++) {
			if (ing[i] > this.inventario.get(i).getCantidadActual()) {
				return false;
			}
		}
		
		return true;
	}
	
	private void actualizarIngredientes(int opcion) {
		int[] ing = this.recetas.get(opcion).getIngredientes();
		for (int i = 0; i < 4; i++) {
			this.inventario.get(i).quitarCantidad(ing[i]);
		}
	}
	
	private int getIntegerInput() {
		int value;
		if (scanner.hasNextInt()) {
			value = scanner.nextInt();
		} else {
			scanner.next();
			value = -1;
		}
		
		return value;
	}
	
	private void configuracionInicial() {
		inventario.add(new Inventario("Café", 10, 0));
		inventario.add(new Inventario("Chocolate", 10, 0));
		inventario.add(new Inventario("Leche", 80, 0));
		inventario.add(new Inventario("Azúcar", 40, 0));
		
		recetas.add(new Receta("Cafe Normal", 1000, new int[]{2, 0, 0, 5}));
		recetas.add(new Receta("Cafe con Leche", 1500, new int[]{2, 0, 4, 2}));
		recetas.add(new Receta("Capuchino", 2000, new int[]{2, 3, 10, 5}));
	}
	
	public List<Inventario> getInventario() {
		return inventario;
	}

	public void setInventario(List<Inventario> inventario) {
		this.inventario = inventario;
	}

	public List<Receta> getRecetas() {
		return recetas;
	}

	public void setRecetas(List<Receta> recetas) {
		this.recetas = recetas;
	}
}
