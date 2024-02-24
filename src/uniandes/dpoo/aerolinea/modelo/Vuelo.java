package uniandes.dpoo.aerolinea.modelo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import uniandes.dpoo.aerolinea.modelo.tarifas.CalculadoraTarifas;
import uniandes.dpoo.aerolinea.tiquetes.Tiquete;

public class Vuelo {
	
	
	/**
	 * Atributos
	 */
	private String fecha;
	private Ruta ruta;
	private Avion avion;
	private Map< String,Tiquete> tiquetes;

	
	
	/**
	 * Constructor
	 */
    public Vuelo(Ruta ruta, String fecha, Avion avion)
    {
        tiquetes = new HashMap< String, Tiquete>( );
        this.ruta = ruta;
        this.avion = avion;
        this.fecha = fecha; 
    }


	public String getFecha() {
		return fecha;
	}


	public Ruta getRuta() {
		return ruta;
	}


	public Avion getAvion() {
		return avion;
	}

	public Map<String, Tiquete> getTiquetes() {
		return tiquetes;
	}
	
	public int venderTicketes(Cliente clientes, CalculadoraTarifas calculadora, int cantidad ) {
		return -1;
	}
    
    
    public boolean equals(Object object) {
		return false;
    	
    }
}
