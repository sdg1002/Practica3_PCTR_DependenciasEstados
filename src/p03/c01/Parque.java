package src.p03.c01;

import java.util.Enumeration;
import java.util.Hashtable;

public class Parque implements IParque{

	// TO DO 
	private int contadorPersonasTotales;
	private Hashtable<String, Integer> contadoresPersonasPuerta;
	private final int aforoMax;
	
	
	public Parque(int aforo) {	// TO DO
		contadorPersonasTotales = 0;
		contadoresPersonasPuerta = new Hashtable<String, Integer>();
		this.aforoMax=  aforo;
		// TO DO
	}


	@Override
	public synchronized void entrarAlParque(String puerta){
		
		// Si no hay entradas por esa puerta, inicializamos
		if (contadoresPersonasPuerta.get(puerta) == null){
			contadoresPersonasPuerta.put(puerta, 0);
		}
		
		comprobarAntesDeEntrar();
		
		// Aumentamos el contador total y el individual
		contadorPersonasTotales++;		
		contadoresPersonasPuerta.put(puerta, contadoresPersonasPuerta.get(puerta)+1);
		
		// Imprimimos el estado del parque
		imprimirInfo(puerta, "Entrada");
		
		checkInvariante();
		
		notifyAll();
		
	}
	
	// 
	// TODO Método salirDelParque
	//
	public synchronized void salirDelParque(String puerta){
		
		if (contadoresPersonasPuerta.get(puerta) == null){
			contadoresPersonasPuerta.put(puerta, 0);
		}
		
		// Decrementamos el contador total y el individual
		contadorPersonasTotales--;
		//Comprobar invariante
		contadoresPersonasPuerta.put(puerta, contadoresPersonasPuerta.get(puerta)-1);
		
		// Imprimimos el estado del parque
		imprimirInfo(puerta, "Entrada");
		
		checkInvariante();
		
		notifyAll();
	}
	
	private void imprimirInfo (String puerta, String movimiento){
		System.out.println(movimiento + " por puerta " + puerta);
		System.out.println("--> Personas en el parque " + contadorPersonasTotales); //+ " tiempo medio de estancia: "  + tmedio);
		
		// Iteramos por todas las puertas e imprimimos sus entradas
		for(String p: contadoresPersonasPuerta.keySet()){
			System.out.println("----> Por puerta " + p + " " + contadoresPersonasPuerta.get(p));
		}
		System.out.println(" ");
	}
	
	private int sumarContadoresPuerta() {
		int sumaContadoresPuerta = 0;
			Enumeration<Integer> iterPuertas = contadoresPersonasPuerta.elements();
			while (iterPuertas.hasMoreElements()) {
				sumaContadoresPuerta += iterPuertas.nextElement();
			}
		return sumaContadoresPuerta;
	}
	
	protected void checkInvariante() {
		assert sumarContadoresPuerta() == contadorPersonasTotales : "INV: La suma de contadores de las puertas debe ser igual al valor del contador del parte";
		// TO DO 
		// TO DO
	}

	protected void comprobarAntesDeEntrar(){	// TO DO
		//
		// TO DO
		//
		int cont = 0;
		for(String p: contadoresPersonasPuerta.keySet()){
			cont += 1;
		}
		assert contadorPersonasTotales < cont*20: "No puedes entrar, el Parque está lleno";
	
	}

	protected void comprobarAntesDeSalir(){		// TO DO
		//
		// TO DO
		//
		int cont = 0;
		for(String p: contadoresPersonasPuerta.keySet()){
			cont += 1;
		}
		assert contadorPersonasTotales > 0: "No puede salir nadie, pues el Parque está vacío";
		}


}
