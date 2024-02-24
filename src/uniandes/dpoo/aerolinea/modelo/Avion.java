package uniandes.dpoo.aerolinea.modelo;

public class Avion 
{

	/**
	 * Atributos
	 */
	private String nombre;
	private int capacidad;

	/**
	 * Constructor
	 */
	public Avion(String nombre, int capacidad) {
		this.nombre = nombre;
		this.capacidad = capacidad;
	}
	
	/**
	 * Retorna el nombre de un avion
	 */
	public String getNombre() {
		return nombre;
	}
	
	/**
	 * Retorna la capacidad de un avion
	 */
	public int getCapacidad() {
		return capacidad;
	}
	
	
	
}
