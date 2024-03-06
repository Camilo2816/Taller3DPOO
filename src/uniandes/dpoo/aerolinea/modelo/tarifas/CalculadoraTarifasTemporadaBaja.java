package uniandes.dpoo.aerolinea.modelo.tarifas;

import uniandes.dpoo.aerolinea.modelo.Ruta;
import uniandes.dpoo.aerolinea.modelo.Vuelo;
import uniandes.dpoo.aerolinea.modelo.cliente.Cliente;
import uniandes.dpoo.aerolinea.modelo.cliente.ClienteCorporativo;



public class CalculadoraTarifasTemporadaBaja extends CalculadoraTarifas {
	
	protected final int COSTO_POR_KM_NATURAL = 600;
	protected final int COSTO_POR_KM_CORPORATIVO = 900;
	protected final double DESCUENTO_PEQ = 0.02;
	protected final double DESCUENTO_MEDIANAS = 0.1;
	protected final double DESCUENTO_GRANDES = 0.2;
	
    @Override
     public int calcularCostoBase(Vuelo vuelo, Cliente cliente) {
    	if ("Natural".equals(cliente.getTipoCliente())) {
			return COSTO_POR_KM_NATURAL * calcularDistanciaVuelo​(vuelo.getRuta());
		}else {
			return COSTO_POR_KM_CORPORATIVO * calcularDistanciaVuelo​(vuelo.getRuta());
		} 
    }


	public double calcularPorcentajeDescuento(Cliente cliente) {
		// TODO Auto-generated method stub4
		 if ("Natural".equals(cliente.getTipoCliente())) {
			return 0.0;
		}else {
			ClienteCorporativo clienteCorp = (ClienteCorporativo) cliente;
			if (clienteCorp.getTamanoEmpresa() == 1) {
				return 0.2;
			}else if (clienteCorp.getTamanoEmpresa() == 2) {
				return 0.1;
			}else {
				return 0.02;
			}
		}	
				
	}
}
