package uniandes.dpoo.aerolinea.modelo.tarifas;

import uniandes.dpoo.aerolinea.modelo.Vuelo;
import uniandes.dpoo.aerolinea.modelo.cliente.Cliente;

public class CalculadoraTarifasTemporadaAlta extends CalculadoraTarifas {

	protected final int COSTO_POR_KM = 1000;
	
	@Override
	public int calcularCostoBase(Vuelo vuelo, Cliente cliente) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public double calcularPorcentajeDescuento(Cliente cliente) {
		// TODO Auto-generated method stub
		return 0;
	}

}
