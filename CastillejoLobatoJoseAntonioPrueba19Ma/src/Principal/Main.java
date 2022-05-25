package Principal;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

import PlataformaOnline.jacaranda.com.Serie;
import PlataformaOnline.jacaranda.com.SerieException;
import PlataformaOnline.jacaranda.com.Series;
import PlataformaOnline.jacaranda.com.Tema;
import PlataformaOnline.jacaranda.com.Temporada;

public class Main {
	public static Series series;
	public static void main(String[] args) {

		series = new Series();
		try {
			series.annadirSerie("This is us", 2015, Tema.DRAMA);
			series.annadirSerie("Friends", 1990, Tema.COMEDIA);
			series.annadirSerie("Dallas", 1970, Tema.INTRIGA);
			series.annadirTemporada("This is us", "Empezamos");
			series.annadirTemporada("This is us", "Seguimos");
			series.annadirTemporada("This is us", "Finalizamos");
			series.annadirCapituloTemporada("This is us", "Empezamos", "La familia");
			series.annadirCapituloTemporada("This is us", "Empezamos", "El problema");
			series.annadirCapituloTemporada("This is us", "Empezamos", "Los niños");
			series.annadirCapituloTemporada("This is us", "Empezamos", "CAsi el final");
			series.annadirCapituloTemporada("This is us", "Empezamos", "El final");
			
			escribirSeries("Fichero\\Series.csv");
			series.escribirFicheroTemporada("Fichero\\Temporada.csv");
			series.escribirFicheroCapitulos("Fichero\\Capitulos.csv");
			
			Temporada t = new Temporada("TTT");
			Serie s = new Serie(null, 1996, null);
			s.annadirTemporada("TTT");
		
			t.annadirCapitulo("aaaa");
			t.annadirCapitulo("bbbb");
			t.annadirCapitulo("ccc");
			t.anadirCapituloDespues("jjjjj", "bbbb");
			System.out.println(t);
			
		} catch (SerieException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	private static void escribirSeries(String nombre) {
		
		try {
			FileWriter flujoEscritura = new FileWriter(nombre);
			PrintWriter filtroEscritura = new PrintWriter(flujoEscritura);
			
			filtroEscritura.print(series.devuelveValorParaImprimir());
			
			filtroEscritura.close();
			flujoEscritura.close();
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
	}
	
}
