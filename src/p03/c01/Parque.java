package src.p03.c01;

import java.util.Enumeration;
import java.util.Hashtable;

public class Parque implements IParque{

	// TODO 
	private final int aforoMax = 50;
	private int contadorPersonasTotales;
	private Hashtable<String, Integer> contadoresPersonasPuerta;
	
	
	public Parque() {	// TODO
		contadorPersonasTotales = 0;
		contadoresPersonasPuerta = new Hashtable<String, Integer>();
		// TODO
	}


	@Override
	public void entrarAlParque(String puerta){		// TODO
		
		// Si no hay entradas por esa puerta, inicializamos
		if (contadoresPersonasPuerta.get(puerta) == null){
			contadoresPersonasPuerta.put(puerta, 0);
		}
		
		// Precondicion / Invariante
		comprobarAntesDeEntrar();
		
		// Aumentamos el contador total y el individual
		contadorPersonasTotales++;		
		contadoresPersonasPuerta.put(puerta, contadoresPersonasPuerta.get(puerta)+1);
		
		// Imprimimos el estado del parque
		imprimirInfo(puerta, "Entrada");
		
		// TODO
		
		
		// TODO
		
	}
	
	// 
	// TODO MÃ©todo salirDelParque
	//
	public void salirDelParque(String puerta){
		//Comprobar invariante / Precondicion
		comprobarAntesDeSalir();
		
		// Decrementamos el contador total y el individual
		contadorPersonasTotales--;
		contadoresPersonasPuerta.put(puerta, contadoresPersonasPuerta.get(puerta)-1);

		//Comprobar Postcondicion
		
		// Imprimimos el estado del parque
		imprimirInfo(puerta, "Entrada");
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
		assert sumarContadoresPuerta() <= aforoMax : "No se debe superar el aforo Máximo por el Covid";
		// TODO 
		// TODO
	}

	protected void comprobarAntesDeEntrar(){	// TODO
		//
		// TODO
		//
		/*int cont = 0;
		for(String p: contadoresPersonasPuerta.keySet()){
			cont += 1;
		}*/
		assert contadorPersonasTotales < aforoMax: "No puedes pasar, el Parque está lleno";
	
	}

	protected void comprobarAntesDeSalir(){		// TODO
		//
		// TODO
		//
		assert contadorPersonasTotales > 0: "No puede salir nadie, pues el Parque está vacío";
		}


}
