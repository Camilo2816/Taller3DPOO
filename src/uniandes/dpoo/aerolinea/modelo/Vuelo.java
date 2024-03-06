package uniandes.dpoo.aerolinea.modelo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import uniandes.dpoo.aerolinea.exceptions.VueloSobrevendidoException;
import uniandes.dpoo.aerolinea.modelo.cliente.Cliente;
import uniandes.dpoo.aerolinea.modelo.tarifas.CalculadoraTarifas;
import uniandes.dpoo.aerolinea.tiquetes.GeneradorTiquetes;
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
	
	
	public int venderTicketes(Cliente clientes, CalculadoraTarifas calculadora, int cantidad) throws VueloSobrevendidoException {
	    int capacidadDisponible = avion.getCapacidad() - tiquetes.size();
	    if (cantidad > capacidadDisponible) {
	        throw new VueloSobrevendidoException(this);
	    } else {
	        int tarifa1 = calculadora.calcularTarifa​(this, clientes);
	        for (int i = 0; i < cantidad; i++) {
	            Tiquete tiqueteNuevo = GeneradorTiquetes.generarTiquete(this, clientes, tarifa1);
	            GeneradorTiquetes.registrarTiquete(tiqueteNuevo);
	            tiquetes.put(tiqueteNuevo.getCodigo(), tiqueteNuevo);
	            clientes.agregarTiquete​(tiqueteNuevo);
	        }
	        return tarifa1 * cantidad; 
	    }
	}

    
    
	@Override
	public boolean equals(Object obj) {
	    if (this == obj) {
	        return true;
	    }
	    if (obj == null || getClass() != obj.getClass()) {
	        return false;
	    }
	    Vuelo otroVuelo = (Vuelo) obj;
	    return fecha.equals(otroVuelo.fecha) && 
	           ruta.equals(otroVuelo.ruta) && 
	           avion.equals(otroVuelo.avion) && 
	           tiquetes.equals(otroVuelo.tiquetes);
	}
}
