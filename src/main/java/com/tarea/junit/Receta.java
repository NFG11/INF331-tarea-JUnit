package com.tarea.junit;

public class Receta {
	private String nombre;
	private int precio;
	private int[] ingredientes; // Orden: cafe, chocolate, leche, azucar
	
	public Receta(String nombre, int precio, int[] ingredientes) {
		super();
		this.nombre = nombre;
		this.precio = precio;
		this.ingredientes = ingredientes;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getPrecio() {
		return precio;
	}

	public void setPrecio(int precio) {
		this.precio = precio;
	}

	public int[] getIngredientes() {
		return ingredientes;
	}

	public void setIngredientes(int[] ingredientes) {
		this.ingredientes = ingredientes;
	}
}
