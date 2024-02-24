package uniandes.dpoo.aerolinea.modelo.cliente;

import java.util.ArrayList;
import java.util.List;
import uniandes.dpoo.aerolinea.modelo.Vuelo;
import uniandes.dpoo.aerolinea.tiquetes.Tiquete;

public abstract class Cliente {

	
	private List<Tiquete> tiquetesSinUsar;
	private List<Tiquete> tiquetesUsados;
	
	public Cliente() {
		tiquetesSinUsar = new ArrayList<Tiquete>();
		tiquetesUsados = new ArrayList<Tiquete>();
	}
	
	
	public abstract String getTipoCliente();
	public abstract String getIdentificador();
	
	public void agregarTiquete​(Tiquete tiquete) {
		
	}
	
	public int calcularValorTotalTiquetes() {
		return -1;
	}
	
	
	public void usarTiquetes​(Vuelo vuelo) {
		
	}
}


