package uniandes.dpoo.aerolinea.modelo.tarifas;

import uniandes.dpoo.aerolinea.modelo.Aeropuerto;
import uniandes.dpoo.aerolinea.modelo.Ruta;
import uniandes.dpoo.aerolinea.modelo.Vuelo;
import uniandes.dpoo.aerolinea.modelo.cliente.Cliente;

public abstract class CalculadoraTarifas {

	
	
	public static final double IMPUESTO = 0.28;

	
	
	public int calcularTarifa​(Vuelo vuelo, Cliente cliente) {
		int costoBase = calcularCostoBase(vuelo, cliente);
		double porcentajeDescuento = calcularPorcentajeDescuento(cliente);
		int impuesto = calcularValorImpuestos​(costoBase);
		int descuento = (int) (costoBase * porcentajeDescuento); 
		return costoBase + impuesto - descuento;
	
	}
	
	


	protected abstract int calcularCostoBase(Vuelo vuelo, Cliente cliente);

	protected abstract double calcularPorcentajeDescuento(Cliente cliente);
	
	
	
	protected int calcularDistanciaVuelo​(Ruta ruta) {
		Aeropuerto origen = ruta.getOrigen();
		Aeropuerto destino = ruta.getDestino();
		double lat1 = origen.getLatitud();
		double long1 = origen.getLongitud();
		double lat2 = destino.getLatitud();
		double long2 = destino.getLongitud();		
	
	
	   final double RADIUS_OF_EARTH_KM = 6371.0;

	    double latitudRadianes1 = Math.toRadians(lat1);
	    double longitudRadianes1 = Math.toRadians(long1);
	    double latitudRadianes2 = Math.toRadians(lat2);
	    double longitudRadianes2 = Math.toRadians(long2);

	    double diferenciaLatitud = latitudRadianes2 - latitudRadianes1;
	    double diferenciaLongitud = longitudRadianes2 - longitudRadianes1;

	    double a = Math.pow(Math.sin(diferenciaLatitud / 2), 2) +
	               Math.cos(latitudRadianes1) * Math.cos(latitudRadianes2) *
	               Math.pow(Math.sin(diferenciaLongitud / 2), 2);
	    double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));
	    double distancia = RADIUS_OF_EARTH_KM * c;

	    return (int)distancia;
	}

	
	protected int calcularValorImpuestos​(int costoBase) {
		double impuesto = costoBase * IMPUESTO;
		return (int) impuesto;
	}
}
