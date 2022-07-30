package com.tarea.junit;

public class Inventario {
	private String tipo;
	private int maxSoportado;
	private int cantidadActual;
	
	public Inventario(String tipo, int maxSoportado, int cantidadActual) {
		super();
		this.tipo = tipo;
		this.maxSoportado = maxSoportado;
		this.cantidadActual = cantidadActual;
	}
	
	public boolean addCantidad(int cantidad) {
		if (this.cantidadActual + cantidad > maxSoportado) {
			return false;
		}
		
		this.cantidadActual += cantidad;
		return true;
	}
	
	public void quitarCantidad(int cantidad) {
		if (this.cantidadActual - cantidad >= 0) {
			this.cantidadActual -= cantidad;
		}
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public int getMaxSoportado() {
		return maxSoportado;
	}

	public void setMaxSoportado(int maxSoportado) {
		this.maxSoportado = maxSoportado;
	}

	public int getCantidadActual() {
		return cantidadActual;
	}

	public void setCantidadActual(int cantidadActual) {
		this.cantidadActual = cantidadActual;
	}
}
