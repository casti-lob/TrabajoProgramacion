package PlataformaOnline.jacaranda.com;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map.Entry;



public class Series {

	private HashMap<String, Serie> mapSeries;
	
	/**
	 * Crea el objeto que nos servirá para tener las series
	 */
	public Series() {
		mapSeries=new HashMap<String, Serie>();
	}
	
	
	/** Añade una serie a la lista de series. Si existe una serie con el mismo nombre lanza una excpetion
	 * 
	 * @param serie
	 * @throws SerieException
	 */
	public void annadirSerie(String nombreSerie, int anno, Tema tema) throws SerieException {
		if (mapSeries.containsKey(nombreSerie)) {
			throw new SerieException("Ya existe esa serie");
		}
		Serie serie = new Serie(nombreSerie, anno, tema);
		mapSeries.put(serie.getNombreSerie(), serie);
	}
	
	
	/** Añade una temporada a la Serie cuyo nombre se le pasa por argumento, si no existe
	 * la Serie lanza una exception
	 * @param serie
	 * @throws SerieException
	 */
	public void annadirTemporada(String nombreSerie, String temporada) throws SerieException {
		if (!mapSeries.containsKey(nombreSerie)) {
			throw new SerieException("No existe esa serie");
		}
		Serie serie = mapSeries.get(nombreSerie);
		serie.annadirTemporada(temporada);
	}
	
	
	/** Añade un capítulo a la temporada de la Serie cuyo nombre se le pasa por argumento, si no existe
	 * la Serie o la temporada lanza una exception
	 * @param serie
	 * @throws SerieException
	 */
	public void annadirCapituloTemporada(String nombreSerie, String temporada, String capitulo) throws SerieException {
		if (!mapSeries.containsKey(nombreSerie)) {
			throw new SerieException("No existe esa serie");
		}
		Serie serie = mapSeries.get(nombreSerie);
		serie.annadirCapituloTemporada(temporada, capitulo);

	}
	
	
	/** Valorar una temporada de la Serie cuyo nombre se le pasa por argumento, si no existe
	 * la Serie o la temporada lanza una exception
	 * @param serie
	 * @throws SerieException
	 */
	public void valorarTemporada(String nombreSerie, String temporada, int valoracion) throws SerieException {
		if (!mapSeries.containsKey(nombreSerie)) {
			throw new SerieException("No existe esa serie");
		}
		Serie serie = mapSeries.get(nombreSerie);
		serie.valorarTemporada(temporada, valoracion);
	}
	
	/**
	 * Devuelve el número de temporadas que tiene la serie que se pasa por parámetro
	 * Si no existe la serie saltará la excepción.
	 * @param nombreSerie
	 * @return
	 * @throws SerieException
	 */

	public int numeroDeTemporadasDeUnaSerie(String nombreSerie) throws SerieException{
		int nTemporadas=0;
		if(mapSeries.containsKey(nombreSerie)) {
			Serie s = mapSeries.get(nombreSerie);
			nTemporadas= s.numeroTemporadas();
		}else {
			throw new SerieException("La serie no existe");
		} 
		return nTemporadas;
		
	}
	
	public String escribirSerie() {
		StringBuilder lista = new StringBuilder();
		for (String i : mapSeries.keySet()) {
			lista.append(mapSeries.get(i+"\n"));
		}
		return lista.toString();
	}
	
	/** Modifica el tema de una serie. Si no se encuentra la serie o ya tenía ese tema saltará la excepción. 
	 * 
	 * @param nombreSerie
	 * @param nuevoTema
	 * @throws SerieException
	 */
	public void modificarTema( String nombreSerie, Tema nuevoTema) throws SerieException {
		
		if(mapSeries.containsKey(nombreSerie)) {
			Serie s = mapSeries.get(nombreSerie);
			if(s.getTema().equals(nuevoTema)) {
				throw new SerieException("Ya tiene ese tema");
			}
			s.setTema(nuevoTema);
		}else {
			throw new SerieException("La serie no existe");
		}
		
		
	}
	
	
	
	/**
	 * Devolverá un listado ordenado de forma creciente por el año de la serie. 
	 * Para cada serie se mostrará su nombre, año y número de temporadas. 
	 * Si no hay ninguna serie de ese tema saltará la excepción.
	 * @param tema
	 * @return
	 * @throws SerieException
	 */
	public  String listadoOrdenadoSeriesDeUnTema( Tema tema)  throws SerieException {
		ArrayList<Serie>listado =  new ArrayList<Serie>();
		StringBuilder resultado = new StringBuilder();
		for(Serie serie:this.mapSeries.values()) {
			if(serie.getTema().equals(tema)) {
				listado.add(serie);
			}
		}
		Collections.sort(listado);		
		for(Serie serie:listado) {
			resultado.append(serie.toString()+"\n");
		}
		return resultado.toString();
	}
	public String devuelveValorParaImprimir() {
		StringBuilder resultado =new StringBuilder();
		
		for(Serie serie:this.mapSeries.values()) {
			resultado.append(serie.getNombreSerie()+","+serie.getAnno()+","+serie.getTema()+"\n");
		}
		return resultado.toString();
	}
	public void escribirFicheroCapitulos(String nombre) {
		try {
			FileWriter flujoEscritura = new FileWriter(nombre);
			PrintWriter filtroEscritura = new PrintWriter(flujoEscritura);
			
			for(Serie i:mapSeries.values()) {
				filtroEscritura.print(i.infoCapitulos());
			}
			filtroEscritura.close();
			flujoEscritura.close();
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
	}
	
	
	public void escribirFicheroTemporada(String nombre) {
		
		try {
			FileWriter flujoEscritura = new FileWriter(nombre);
			PrintWriter filtroEscritura = new PrintWriter(flujoEscritura);
			
			for(Serie i:mapSeries.values()) {
				filtroEscritura.print(i.infoTemporadas());
			}
			
			filtroEscritura.close();
			flujoEscritura.close();
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
	}
}
