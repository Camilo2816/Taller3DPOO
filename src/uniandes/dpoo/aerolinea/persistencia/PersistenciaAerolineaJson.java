package uniandes.dpoo.aerolinea.persistencia;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;

import org.json.JSONArray;
import org.json.JSONObject;

import uniandes.dpoo.aerolinea.exceptions.ClienteRepetidoException;
import uniandes.dpoo.aerolinea.exceptions.InformacionInconsistenteException;
import uniandes.dpoo.aerolinea.modelo.Aerolinea;
import uniandes.dpoo.aerolinea.modelo.Aeropuerto;
import uniandes.dpoo.aerolinea.modelo.Avion;
import uniandes.dpoo.aerolinea.modelo.Ruta;
import uniandes.dpoo.aerolinea.modelo.Vuelo;
import uniandes.dpoo.aerolinea.modelo.cliente.Cliente;
import uniandes.dpoo.aerolinea.modelo.cliente.ClienteCorporativo;
import uniandes.dpoo.aerolinea.modelo.cliente.ClienteNatural;
import uniandes.dpoo.aerolinea.tiquetes.Tiquete;






public class PersistenciaAerolineaJson implements IPersistenciaAerolinea {

	private static final String NOMBRE_AVION = "nombre_avion";
	private static final String CAPACIDAD_AVION = "capacidad_avion";
	private static final String HORA_SALIDA = "hora_salida";
	private static final String HORA_LLEGADA = "hora_llegada";
	private static final String CODIGO_RUTA = "codigo_ruta";
	private static final String NOMBRE_AEROPUERTO_DESTINO = "nombre_aeropuerto_destino";
	private static final String CODIGO_AEROPUERTO_DESTINO = "codigo_aeropuerto_destino";
	private static final String NOMBRE_CIUDAD_AEROPUERO_DESTINO = "nombre_ciudad_aeropuerto_destino";
	private static final String LATITUD_AEROPUERTO_DESTINO = "latitud_aeropuerto_destino";
	private static final String LONGITUD_AEROPUERTO_DESTINO = "longitud_aeropuerto_destino";
	private static final String NOMBRE_AEROPUERTO_ORIGEN = "nombre_aeropuerto_origen";
	private static final String CODIGO_AEROPUERTO_ORIGEN = "codigo_aeropuerto_origen";
	private static final String NOMBRE_CIUDAD_AEROPUERO_ORIGEN = "nombre_ciudad_aeropuerto_origen";
	private static final String LATITUD_AEROPUERTO_ORIGEN = "latitud_aeropuerto_origen";
	private static final String LONGITUD_AEROPUERTO_ORIGEN = "longitud_aeropuerto_origen";
	private static final String RADIO_TERRESTRE = "radio_terrestre";
	private static final String AEROPUERTO_ORIGEN = "aeropuerto_origen";
	private static final String AEROPUERTO_DESTINO = "aeropuerto_destino";
	private static final String FECHA_VUELO = "fecha_vuelo";
	private static final String RUTA_VUELO = "ruta_vuelo";
	private static final String HORA_SALIDA_VUELO = "hora_salida_vuelo";
	private static final String HORA_LLEGADA_VUELO = "hora_llegada_vuelo";
	private static final String CODIGO_RUTA_VUELO = "codigo_ruta_vuelo";
	private static final String AEROPUERTO_ORIGEN_VUELO = "aeropuerto_origen_vuelo";
	private static final String AEROPUERTO_DESTINO_VUELO = "aeropuerto_destino_vuelo";
	private static final String NOMBRE_AEROPUERTO_ORIGEN_VUELO = "nombre_aeropuerto_origen_vuelo";
	private static final String CODIGO_AEROPUERTO_ORIGEN_VUELO = "nombre_aeropuerto_desstino_vuelo";
	private static final String NOMBRE_CIUDAD_AEROPUERO_ORIGEN_VUELO = "nombre_ciudad_aeropuerto_origen_vuelo";
	private static final String LATITUD_AEROPUERTO_ORIGEN_VUELO = "latitud_aeropuerto_origen_vuelo";
	private static final String LONGITUD_AEROPUERTO_ORIGEN_VUELO = "longitud_aeropuerto_origen_vuelo";
	private static final String NOMBRE_AEROPUERTO_DESTINO_VUELO = "nombre_aeropuerto_destino_vuelo";
	private static final String CODIGO_AEROPUERTO_DESTINO_VUELO = "codigo_aeropuerto_destino_vuelo";
	private static final String NOMBRE_CIUDAD_AEROPUERO_DESTINO_VUELO = "nombre_ciudad_aeropuerto_destino_vuelo";
	private static final String LATITUD_AEROPUERTO_DESTINO_VUELO = "latitud_aeropuerto_destino_vuelo";
	private static final String LONGITUD_AEROPUERTO_DESTINO_VUELO = "longitud_aeropuerto_destino_vuelo";
	private static final String AVION_VUELO = "avion_vuelo";
	private static final String NOMBRE_AVION_VUELO = "nombre_avio_vuelo";
	private static final String CAPACIDAD_AVION_VUELO = "capacidad_avion_vuelo";
	private static final String AVIONES = "aviones";
	private static final String RUTAS = "rutas";
	private static final String VUELOS = "vuelos";
	private static final String TIQUETES_VUELO = "tiquetes_vuelo";
	private static final String CODIGO_TIQUETE_VUELO = "codigo_tiquete_vuelo";
	private static final String TARIFA_TIQUETE_VUELO = "tarifa_tiquete_vuelo";
	private static final String USADO_TIQUETE_VUELO = "usado_tiquete_vuelo";
	private static final String VUELO_TIQUETE = "vuelo_tiquete";
	private static final String NOMBRE_CLIENTE = "nombre_cliente";
	private static final String CLIENTE_TIQUETE = "nombre_cliente";
	private static final String CLIENTES = "clientes";
	private static final String TIPO_CLIENTE = "tipoCliente";
	
	
	//CARGAR DATOS
	@Override
	public void cargarAerolinea(String archivo, Aerolinea aerolinea) throws IOException, InformacionInconsistenteException 
	{
        String jsonCompleto = new String( Files.readAllBytes( new File( archivo ).toPath( ) ) );
        JSONObject raiz = new JSONObject( jsonCompleto );

        cargarAviones( aerolinea, raiz.getJSONArray( AVIONES ) );
        cargarRutas( aerolinea, raiz.getJSONArray(  RUTAS) );
        cargarVuelos( aerolinea, raiz.getJSONArray( VUELOS ) );
        cargarClientes( aerolinea, raiz.getJSONArray(  CLIENTES) );

	}

	




	//Cargar aviones
	private void cargarAviones(Aerolinea aerolinea, JSONArray jAviones) {
		
		int numeroAviones = jAviones.length();
		for (int i = 0; i < numeroAviones; i++) {
			
			JSONObject avion = jAviones.getJSONObject( i );
			
			Avion nuevoAvion = new Avion(avion.getString(NOMBRE_AVION), avion.getInt(CAPACIDAD_AVION));
			
			aerolinea.agregarAvion(nuevoAvion);
			
			
		}
		
	}
	
	//Cargar rutas

	private void cargarRutas(Aerolinea aerolinea, JSONArray jRutas) {

		int numeroRutas = jRutas.length();
		for (int i = 0; i < numeroRutas; i++) {
			JSONObject jRuta = jRutas.getJSONObject( i );
			JSONObject aeropuertoOrigen = jRuta.getJSONObject(AEROPUERTO_ORIGEN);
			JSONObject aeropuertoDestino = jRuta.getJSONObject(AEROPUERTO_DESTINO);
			
			String nombreAeropuertoOrigen = aeropuertoOrigen.getString(NOMBRE_AEROPUERTO_ORIGEN);
			String codigoAeropuertoOrigen = aeropuertoOrigen.getString(CODIGO_AEROPUERTO_ORIGEN);
			String nombreCiudadAeropuertoOrigen = aeropuertoOrigen.getString(NOMBRE_CIUDAD_AEROPUERO_ORIGEN);
			double latitudAeropuertoOrigen = aeropuertoOrigen.getDouble(LATITUD_AEROPUERTO_ORIGEN);
			double longitudAeropuertoOrigen = aeropuertoOrigen.getDouble(LONGITUD_AEROPUERTO_ORIGEN);
			
			String nombreAeropuertoDestino = aeropuertoDestino.getString(NOMBRE_AEROPUERTO_DESTINO);
			String codigoAeropuertoDestino = aeropuertoDestino.getString(CODIGO_AEROPUERTO_DESTINO);
			String nombreCiudadAeropuertoDestino = aeropuertoDestino.getString(NOMBRE_CIUDAD_AEROPUERO_DESTINO);
			double latitudAeropuertoDestino = aeropuertoDestino.getDouble(LATITUD_AEROPUERTO_DESTINO);
			double longitudAeropuertoDestino = aeropuertoDestino.getDouble(LONGITUD_AEROPUERTO_DESTINO);
			
			
			String horaSalida = jRuta.getString(HORA_SALIDA);
			String horaLlegada = jRuta.getString(HORA_LLEGADA);
			String codigoRuta = jRuta.getString(CODIGO_RUTA);

			Aeropuerto NuevoAeropuertoOrigen = new Aeropuerto(nombreAeropuertoOrigen, codigoAeropuertoOrigen, nombreCiudadAeropuertoOrigen, latitudAeropuertoOrigen, longitudAeropuertoOrigen);
			Aeropuerto NuevoAeropuertoDestino = new Aeropuerto(nombreAeropuertoDestino, codigoAeropuertoDestino, nombreCiudadAeropuertoDestino, latitudAeropuertoDestino, longitudAeropuertoDestino);
			
			Ruta nuevaRuta = new Ruta(NuevoAeropuertoOrigen, NuevoAeropuertoDestino, horaSalida, horaLlegada, codigoRuta);
			
			aerolinea.agregarRuta(nuevaRuta);
		}
		
	}
	
	
	//cargar vuelos.
	private void cargarVuelos(Aerolinea aerolinea, JSONArray jVuelos) {
	    int numeroVuelos = jVuelos.length();
	    for (int i = 0; i < numeroVuelos; i++) {
	        JSONObject jVuelo = jVuelos.getJSONObject(i);
	        
	        // Obtener la fecha del vuelo
	        String fecha = jVuelo.getString(FECHA_VUELO);
	        
	        // Obtener la ruta del vuelo
	        JSONObject jRutaVuelo = jVuelo.getJSONObject(RUTA_VUELO);
	        Ruta rutaVuelo = cargarRutaVuelo(jRutaVuelo);
	        
	        // Obtener el avión del vuelo
	        JSONObject jAvionVuelo = jVuelo.getJSONObject(AVION_VUELO);
	        Avion avionVuelo = cargarAvionVuelo(jAvionVuelo);
	        
	        // Crear el vuelo y agregarlo a la aerolínea
	        Vuelo nuevoVuelo = new Vuelo(rutaVuelo, fecha, avionVuelo);
	        aerolinea.agregarVuelo(nuevoVuelo);
	    }
	}

	
	
	private Ruta cargarRutaVuelo(JSONObject jRutaVuelo) {
	    String horaSalida = jRutaVuelo.getString(HORA_SALIDA_VUELO);
	    String horaLlegada = jRutaVuelo.getString(HORA_LLEGADA_VUELO);
	    String codigoRuta = jRutaVuelo.getString(CODIGO_RUTA_VUELO);
	    
	    JSONObject jAeropuertoOrigen = jRutaVuelo.getJSONObject(AEROPUERTO_ORIGEN_VUELO);
	    Aeropuerto aeropuertoOrigen = cargarAeropuertoVueloOrigen(jAeropuertoOrigen);
	    
	    JSONObject jAeropuertoDestino = jRutaVuelo.getJSONObject(AEROPUERTO_DESTINO_VUELO);
	    Aeropuerto aeropuertoDestino = cargarAeropuertoVueloDestino (jAeropuertoDestino);
	    
	    return new Ruta(aeropuertoOrigen, aeropuertoDestino, horaSalida, horaLlegada, codigoRuta);
	    		
	}

	
	

	
	private Aeropuerto cargarAeropuertoVueloDestino(JSONObject jAeropuertoDestino) 
	{
		
		String nombreAeropuertoDestino = jAeropuertoDestino.getString(NOMBRE_AEROPUERTO_DESTINO);
		String codigoAeropuertoDestino = jAeropuertoDestino.getString(CODIGO_AEROPUERTO_DESTINO);
		String nombreCiudadAeropuertoDestino = jAeropuertoDestino.getString(NOMBRE_CIUDAD_AEROPUERO_DESTINO);
		double latitudAeropuertoDestino = jAeropuertoDestino.getDouble(LATITUD_AEROPUERTO_DESTINO);
		double longitudAeropuertoDestino = jAeropuertoDestino.getDouble(LONGITUD_AEROPUERTO_DESTINO);
		return new Aeropuerto(nombreAeropuertoDestino, codigoAeropuertoDestino, nombreCiudadAeropuertoDestino, latitudAeropuertoDestino, longitudAeropuertoDestino);
	}






	private Aeropuerto cargarAeropuertoVueloOrigen(JSONObject jAeropuertoOrigen)
	
	{
		
		String nombreAeropuertoOrigen = jAeropuertoOrigen.getString(NOMBRE_AEROPUERTO_ORIGEN);
		String codigoAeropuertoOrigen = jAeropuertoOrigen.getString(CODIGO_AEROPUERTO_ORIGEN);
		String nombreCiudadAeropuertoOrigen = jAeropuertoOrigen.getString(NOMBRE_CIUDAD_AEROPUERO_ORIGEN);
		double latitudAeropuertoOrigen = jAeropuertoOrigen.getDouble(LATITUD_AEROPUERTO_ORIGEN);
		double longitudAeropuertoOrigen = jAeropuertoOrigen.getDouble(LONGITUD_AEROPUERTO_ORIGEN);
		return new Aeropuerto(nombreAeropuertoOrigen, codigoAeropuertoOrigen, nombreCiudadAeropuertoOrigen, latitudAeropuertoOrigen, longitudAeropuertoOrigen);
	}






	private Avion cargarAvionVuelo(JSONObject jAvionVuelo) {
	    // Obtener los datos del avión del JSON
	    String nombreAvion = jAvionVuelo.getString(NOMBRE_AVION_VUELO);
	    int capacidadAvion = jAvionVuelo.getInt(CAPACIDAD_AVION_VUELO);
	    
	    // Crear y devolver un objeto Avion con los datos obtenidos
	    return new Avion(nombreAvion, capacidadAvion);

	}
	
	
	//cargar clientes.
	
	 private void cargarClientes( Aerolinea aerolinea, JSONArray jClientes ) throws ClienteRepetidoException
	    {
	        int numClientes = jClientes.length( );
	        for( int i = 0; i < numClientes; i++ )
	        {
	            JSONObject cliente = jClientes.getJSONObject( i );
	            String tipoCliente = cliente.getString( TIPO_CLIENTE );
	            Cliente nuevoCliente = null;
	            
	            if( ClienteNatural.NATURAL.equals( tipoCliente ) )
	            {
	                
	                String nombre = cliente.getString( NOMBRE_CLIENTE );
	                nuevoCliente = new ClienteNatural( nombre );
	            }
	            else
	            {
	               
	                nuevoCliente = ClienteCorporativo.cargarDesdeJSON( cliente );
	            }
	            if( !aerolinea.existeCliente( nuevoCliente.getIdentificador( ) ) )
	                aerolinea.agregarCliente( nuevoCliente );
	            else
	                throw new ClienteRepetidoException( nuevoCliente.getTipoCliente( ), nuevoCliente.getIdentificador( ) );
	        }
	    }




	//SALVAR DATOS en JSON
	@Override
	public void salvarAerolinea(String archivo, Aerolinea aerolinea) throws IOException {
		JSONObject jobject = new JSONObject( );
		
		//salvar aviones
		salvarAviones(aerolinea, jobject);
		
		//salvar rutas
		salvarRutas(aerolinea, jobject);
		
		//salvar vuelos
		salvarVuelos(aerolinea, jobject );
		
		//salvar clientes
		salvarClientes(aerolinea, jobject);
		
        PrintWriter pw = new PrintWriter( archivo );
        jobject.write( pw, 2, 0 );
        pw.close( );
	}

	


	//salvar aviones
	private void salvarAviones(Aerolinea aerolinea, JSONObject jobject) 
	{
		JSONArray jAviones = new JSONArray( );
		for(Avion avion: aerolinea.getAviones() ) {
			JSONObject javion = new JSONObject( );
			javion.put(NOMBRE_AVION, avion.getNombre());
			javion.put(CAPACIDAD_AVION, avion.getCapacidad());
			jAviones.put(javion);
			
		}
		jobject.put(AVIONES, jAviones);
	}
	
	
	//salvar rutas
	private void salvarRutas(Aerolinea aerolinea, JSONObject jobject) {
		JSONArray jRutas = new JSONArray( );
		for (Ruta ruta: aerolinea.getRutas()) {
			JSONObject jRuta = new JSONObject( );
			jRuta.put(HORA_SALIDA, ruta.getHoraSalida());
			jRuta.put(HORA_LLEGADA, ruta.getHoraLlegada());
			jRuta.put(CODIGO_RUTA, ruta.getCodigoRuta());
			
			JSONObject jAeropuertoOrigen = salvarAeropuertoOrigen( ruta);
			jRuta.put(AEROPUERTO_ORIGEN, jAeropuertoOrigen);
			
			JSONObject jAeropuertoDestino = salvarAeropuertoDestino( ruta);
			jRuta.put(AEROPUERTO_DESTINO, jAeropuertoDestino);
			
			jRutas.put(jRuta);
		}
		jobject.put(RUTAS, jRutas);
	}

	private JSONObject  salvarAeropuertoDestino( Ruta ruta)
	{
		JSONObject jAeropuertoDestino = new JSONObject( );
		jAeropuertoDestino.put(NOMBRE_AEROPUERTO_DESTINO, ruta.getDestino().getNombre());
		jAeropuertoDestino.put(CODIGO_AEROPUERTO_DESTINO, ruta.getDestino().getCodigo());
		jAeropuertoDestino.put(NOMBRE_CIUDAD_AEROPUERO_DESTINO, ruta.getDestino().getNombreCiudad());
		jAeropuertoDestino.put(LATITUD_AEROPUERTO_DESTINO, ruta.getDestino().getLatitud());
		jAeropuertoDestino.put(LONGITUD_AEROPUERTO_DESTINO, ruta.getDestino().getLongitud());
		jAeropuertoDestino.put(RADIO_TERRESTRE, 6371);
		return jAeropuertoDestino;
	}
	
	private JSONObject salvarAeropuertoOrigen( Ruta ruta)
	{
		JSONObject jAeropuertoOrigen = new JSONObject( );
		jAeropuertoOrigen.put(NOMBRE_AEROPUERTO_ORIGEN, ruta.getOrigen().getNombre());
		jAeropuertoOrigen.put(CODIGO_AEROPUERTO_ORIGEN, ruta.getOrigen().getCodigo());
		jAeropuertoOrigen.put(NOMBRE_CIUDAD_AEROPUERO_ORIGEN, ruta.getOrigen().getNombreCiudad());
		jAeropuertoOrigen.put(LATITUD_AEROPUERTO_ORIGEN, ruta.getOrigen().getLatitud());
		jAeropuertoOrigen.put(LONGITUD_AEROPUERTO_ORIGEN, ruta.getOrigen().getLongitud());
		jAeropuertoOrigen.put(RADIO_TERRESTRE, 6371);
		return jAeropuertoOrigen;
	}	
	
	
	
	
	//salvar Vuelos
	private void salvarVuelos(Aerolinea aerolinea, JSONObject jobject) 
	{
		JSONArray jVuelos = new JSONArray( );
		for(Vuelo vuelo : aerolinea.getVuelos()) {
			JSONObject jVuelo = new JSONObject( );
			
			jVuelo.put(FECHA_VUELO, vuelo.getFecha());
			
			JSONObject jRutaVuelo = salvarRutaVuelo(vuelo);
			jVuelo.put(RUTA_VUELO, jRutaVuelo);
			
			JSONObject jAvionVuelo = salvarAvionVuelo(vuelo);
			jVuelo.put(AVION_VUELO, jAvionVuelo);
			
			JSONArray jTiqutesVuelo = salvarTiquetesVuelo(vuelo);
			jVuelo.put(TIQUETES_VUELO, jTiqutesVuelo);
			
			
			jVuelos.put(jVuelo);
			
		}
		jobject.put(VUELOS, jVuelos);
		
	}



	private JSONObject  salvarRutaVuelo( Vuelo vuelo) {
		JSONObject jRutaVuelo = new JSONObject( );
		jRutaVuelo.put(HORA_SALIDA_VUELO, vuelo.getRuta().getHoraSalida());
		jRutaVuelo.put(HORA_LLEGADA_VUELO, vuelo.getRuta().getHoraLlegada());
		jRutaVuelo.put(CODIGO_RUTA_VUELO, vuelo.getRuta().getCodigoRuta());
		JSONObject jAropuertoOrigen = salvarAeropuertoOrigenVuelo(vuelo);
		jRutaVuelo.put(AEROPUERTO_ORIGEN_VUELO, jAropuertoOrigen);
		JSONObject jAropuertoDestino =salvarAeropuertoDestinoVuelo(vuelo);
		jRutaVuelo.put(AEROPUERTO_DESTINO_VUELO, jAropuertoDestino);
		return jRutaVuelo;
	}

	private JSONObject salvarAeropuertoDestinoVuelo(Vuelo vuelo) {
		JSONObject jAeropuertoOrigen = new JSONObject( );
		jAeropuertoOrigen.put(NOMBRE_AEROPUERTO_ORIGEN_VUELO, vuelo.getRuta().getOrigen().getNombre());
		jAeropuertoOrigen.put(CODIGO_AEROPUERTO_ORIGEN_VUELO, vuelo.getRuta().getOrigen().getCodigo());
		jAeropuertoOrigen.put(NOMBRE_CIUDAD_AEROPUERO_ORIGEN_VUELO, vuelo.getRuta().getOrigen().getNombreCiudad());
		jAeropuertoOrigen.put(LATITUD_AEROPUERTO_ORIGEN_VUELO, vuelo.getRuta().getOrigen().getLatitud());
		jAeropuertoOrigen.put(LONGITUD_AEROPUERTO_ORIGEN_VUELO, vuelo.getRuta().getOrigen().getLongitud());
		jAeropuertoOrigen.put(RADIO_TERRESTRE, 6371);
		return jAeropuertoOrigen;
		
	}

	private JSONObject salvarAeropuertoOrigenVuelo(Vuelo vuelo) {
		JSONObject jAeropuertoDestino = new JSONObject( );
		jAeropuertoDestino.put(NOMBRE_AEROPUERTO_DESTINO_VUELO, vuelo.getRuta().getDestino().getNombre());
		jAeropuertoDestino.put(CODIGO_AEROPUERTO_DESTINO_VUELO, vuelo.getRuta().getDestino().getCodigo());
		jAeropuertoDestino.put(NOMBRE_CIUDAD_AEROPUERO_DESTINO_VUELO, vuelo.getRuta().getDestino().getNombreCiudad());
		jAeropuertoDestino.put(LATITUD_AEROPUERTO_DESTINO_VUELO, vuelo.getRuta().getDestino().getLatitud());
		jAeropuertoDestino.put(LONGITUD_AEROPUERTO_DESTINO_VUELO, vuelo.getRuta().getDestino().getLongitud());
		jAeropuertoDestino.put(RADIO_TERRESTRE, 6371);
		return jAeropuertoDestino;		
	}
	
	private JSONObject salvarAvionVuelo(Vuelo vuelo) {
		JSONObject jAvionVuelo = new JSONObject( );
		jAvionVuelo.put(NOMBRE_AVION_VUELO, vuelo.getAvion().getNombre());
		jAvionVuelo.put(CAPACIDAD_AVION_VUELO, vuelo.getAvion().getCapacidad());
		
		return jAvionVuelo;
	}
	
	
	private JSONArray salvarTiquetesVuelo(Vuelo vuelo) {
		JSONArray jTiquetesVuelo = new JSONArray( );
		for(Tiquete tiquete : vuelo.getTiquetes().values()) {
			JSONObject jTiqueteVuelo = new JSONObject( );
			jTiqueteVuelo.put(CODIGO_TIQUETE_VUELO, tiquete.getCodigo());
			jTiqueteVuelo.put(TARIFA_TIQUETE_VUELO, tiquete.getTarifa());
			jTiqueteVuelo.put(USADO_TIQUETE_VUELO, tiquete.esUsado());
			jTiqueteVuelo.put(VUELO_TIQUETE, tiquete.getCodigo());
			salvarClienteTiquete(tiquete, jTiqueteVuelo);
			jTiquetesVuelo.put(jTiqueteVuelo);
			
		}
		return jTiquetesVuelo;
	}
    private void salvarClienteTiquete( Tiquete tiquete, JSONObject jTiqueteVuelo)
    {

            // Acá también se utilizaron dos estrategias para salvar los clientes.
            // Para los clientes naturales, esta clase extrae la información de los objetos y la organiza para que luego sea salvada.
            // Para los clientes corporativos, la clase ClienteCorporativo hace todo lo que está en sus manos para persistir un cliente
            if( ClienteNatural.NATURAL.equals( tiquete.getCliente().getTipoCliente( ) ) )
            {
                JSONObject jCliente = new JSONObject( );
                jCliente.put( NOMBRE_CLIENTE, tiquete.getCliente().getIdentificador( ) );
                jTiqueteVuelo.put(CLIENTE_TIQUETE, jCliente );
            }
            else
            {
                ClienteCorporativo cc = ( ClienteCorporativo )tiquete.getCliente();
                JSONObject jCliente = cc.salvarEnJSON( );
                jTiqueteVuelo.put( CLIENTE_TIQUETE, jCliente );
            }
    }

    
    
    
    //salvar clientes
	private void salvarClientes(Aerolinea aerolinea, JSONObject jobject) {
		JSONArray jClientes = new JSONArray( );
        for( Cliente cliente : aerolinea.getClientes( ) )
        {
            // Acá también se utilizaron dos estrategias para salvar los clientes.
            // Para los clientes naturales, esta clase extrae la información de los objetos y la organiza para que luego sea salvada.
            // Para los clientes corporativos, la clase ClienteCorporativo hace todo lo que está en sus manos para persistir un cliente
            if( ClienteNatural.NATURAL.equals( cliente.getTipoCliente( ) ) )
            {
                JSONObject jCliente = new JSONObject( );
                jCliente.put( NOMBRE_CLIENTE, cliente.getIdentificador( ) );
                jClientes.put( jCliente );
            }
            else
            {
                ClienteCorporativo cc = ( ClienteCorporativo )cliente;
                JSONObject jCliente = cc.salvarEnJSON( );
                jClientes.put( jCliente );
            }
		
        }
        jobject.put(CLIENTES, jClientes);
	}
        
}
	
	

