package uniandes.dpoo.aerolinea.modelo.cliente;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;

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
		tiquetesSinUsar.add(tiquete);
	}
	
	public int calcularValorTotalTiquetes() {
		int totalSinUsar = 0;
		for(Tiquete tiquete : tiquetesSinUsar) {
			totalSinUsar += tiquete.getTarifa();	
		}
		int totalUsados = 0;
		for(Tiquete tiquete : tiquetesUsados) {
			totalUsados += tiquete.getTarifa();		
		}
		return totalSinUsar;
	}
	

	public void usarTiquetes(Vuelo vuelo) {
        Map<String, Tiquete> mapaTiquetes = vuelo.getTiquetes();
        for (Tiquete tiquete : tiquetesSinUsar) {
            if (mapaTiquetes.containsKey(tiquete.getCodigo())) {
                Tiquete tiqueteEnVuelo = mapaTiquetes.get(tiquete.getCodigo());
                tiqueteEnVuelo.marcarComoUsado();
                tiquetesUsados.add(tiqueteEnVuelo); 
            }
        }
        tiquetesSinUsar.removeAll(tiquetesUsados);
    }
}



