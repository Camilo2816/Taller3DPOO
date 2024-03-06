package uniandes.dpoo.aerolinea.modelo.tarifas;

import uniandes.dpoo.aerolinea.modelo.Vuelo;
import uniandes.dpoo.aerolinea.modelo.cliente.Cliente;
import uniandes.dpoo.aerolinea.modelo.cliente.ClienteCorporativo;
import uniandes.dpoo.aerolinea.modelo.cliente.ClienteNatural;

public class CalculadoraTarifasTemporadaAlta extends CalculadoraTarifas {

	protected final int COSTO_POR_KM = 1000;
	
	@Override
	public int calcularCostoBase(Vuelo vuelo, Cliente cliente) {
		return COSTO_POR_KM * calcularDistanciaVuelo​(vuelo.getRuta());
	}

	@Override
	public double calcularPorcentajeDescuento(Cliente cliente) {
		// TODO Auto-generated method stub4
		 if ("Natural".equals(cliente.getTipoCliente())) {
			return 0;
		}else {
			ClienteCorporativo clienteCorp = (ClienteCorporativo) cliente;
			if (clienteCorp.getTamanoEmpresa() == 1) {
				return 0;
			}else if (clienteCorp.getTamanoEmpresa() == 2) {
				return 0;
			}else {
				return 0;
			}
		}	
				
	}

}
