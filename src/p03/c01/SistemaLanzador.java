package src.p03.c01;

public class SistemaLanzador {
	public static void main(String[] args) {
		
		IParque parque = new Parque(50); // TODO
		char letra_puerta = 'A';
		
		System.out.println("�Parque abierto!");
		
		for (int i = 0; i < 2; i++) {
			
			String puerta = ""+((char) (letra_puerta++));
			
			// Creaci�n de hilos de entrada
			ActividadEntradaPuerta entradas = new ActividadEntradaPuerta(puerta, parque);
			new Thread (entradas).start();
			
			// 
			// TO DO
			//
			ActividadSalidaPuerta salidas = new ActividadSalidaPuerta(puerta, parque);
			new Thread (salidas).start();			
		}
	}	
}