package com.tarea.junit;

import java.util.Scanner;

public class Main {
	private static final Scanner scanner = new Scanner(System.in);
	
	private static void printMenu() {
		System.out.println("\nMenu de opciones.");
		System.out.println("1. Agregar inventario.");
		System.out.println("2. Verificar inventario.");
		System.out.println("3. Comprar bebida.");
	}
	
	private static int getIntegerInput() {
		int value;
		if (scanner.hasNextInt()) {
			value = scanner.nextInt();
		} else {
			scanner.next();
			value = -1;
		}
		
		return value;
	}
	
	public static void main(String[] args) {
		MaquinaCafe cafetera = new MaquinaCafe();
		
		System.out.println("Bienvenido a la maquina de cafe!");
		printMenu();
		
		while (true) {
			System.out.print("Ingresa tu opción: ");
			int opcion = getIntegerInput();
			switch (opcion) {
				case 1:
					System.out.println("\nAgregar inventario:");
					cafetera.agregarInventario();
					printMenu();
					break;
				case 2:
					System.out.println("\nInventario actual:");
					cafetera.verificarInventario();
					printMenu();
					break;
				case 3:
					System.out.println("\nComprar bebida:");
					cafetera.comprarBebida();
					printMenu();
					break;
				default:
					System.out.println("Opción incorrecta. Ingresa otro valor.");
					break;
			}
		}
	}
}
