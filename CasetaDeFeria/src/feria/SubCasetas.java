package feria;

import java.io.File;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class SubCasetas {
	private Set<Caseta> casetas = new HashSet<>();

	public SubCasetas() {

		try {

			File archivo = new File("Fichero\\casetasferia.xml");
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.parse(archivo);

			
			doc.getDocumentElement().normalize();

			
			NodeList listaCasetas = doc.getElementsByTagName("DatosLeidos");

			for (int i = 0; i < listaCasetas.getLength(); i = i + 1) {
				Node elemento = listaCasetas.item(i);
				Caseta caseta = new Caseta();
				NodeList listaTags = elemento.getChildNodes();
				for (int j = 0; j < listaTags.getLength(); j = j + 1) {
					Node tag = listaTags.item(j);
					if (tag.getNodeType() == Node.ELEMENT_NODE) {

						Element element = (Element) tag;
						if (element.getTagName().equalsIgnoreCase("TITULO")) {
							caseta.setTitulo(element.getTextContent());
						} else if (element.getTagName().equalsIgnoreCase("CALLE")) {
							caseta.setCalle(element.getTextContent());
						} else if (element.getTagName().equalsIgnoreCase("NUMERO")) {
							caseta.setNumero(Integer.parseInt(element.getTextContent()));
						} else if (element.getTagName().equalsIgnoreCase("MODULOS")) {
							caseta.setModulo(Integer.parseInt(element.getTextContent()));
						} else if (element.getTagName().equalsIgnoreCase("CLASE")) {
							caseta.setClase(element.getTextContent());
						} else if (element.getTagName().equalsIgnoreCase("ID")) {
							caseta.setId(Integer.parseInt(element.getTextContent()));
						} else if (element.getTagName().equalsIgnoreCase("ID_CALLE")) {
							caseta.setIdCalle(Integer.parseInt(element.getTextContent()));
						} else if (element.getTagName().equalsIgnoreCase("ENTIDAD")) {
							caseta.setEntidad(element.getTextContent());
						}

					}

				}
				casetas.add(caseta);
			}

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}

	

	public Set<Caseta> mostrarCasetasPorCalle(String calle) {
		Set<Caseta> lista = new HashSet<>();

		Iterator<Caseta> siguiente = casetas.iterator();
		Caseta i;

		while (siguiente.hasNext()) {
			i = siguiente.next();

			if (i.getCalle().equalsIgnoreCase(calle)) {
				lista.add(i);
			}
		}
		return lista;
	}

	

	

	private Set<Caseta> mostrarCasetasPorTipo(String tipo) {
		Set<Caseta> result = new HashSet<>();

		Iterator<Caseta> siguiente = casetas.iterator();
		Caseta i;

		while (siguiente.hasNext()) {
			i = siguiente.next();

			if (i.getClase().equalsIgnoreCase(tipo)) {
				result.add(i);
			}
		}
		return result;
	}

	
	public Set<Caseta> mostrarCasetasOtras() {
		Set<Caseta> result = new HashSet<>();

		Iterator<Caseta> siguiente = casetas.iterator();
		Caseta i;

		while (siguiente.hasNext()) {
			i = siguiente.next();

			if (!i.getClase().equalsIgnoreCase("FAMILIAR") && !i.getClase().equalsIgnoreCase("DISTRITO")) {
				result.add(i);
			}
		}
		return result;
	}

	

	

	private Map<String, Integer> mostrarCallesTipo(String tipo) {
		Map<String, Integer> result = new HashMap<>();

		Iterator<Caseta> siguiente = casetas.iterator();
		Caseta i;

		while (siguiente.hasNext()) {
			i = siguiente.next();

			if (result.containsKey(i.getCalle())) {
				if (i.getClase().equalsIgnoreCase(tipo)) {
					Integer valor = result.get(i.getCalle());
					result.put(i.getCalle(), valor + 1);
				}
			} else {
				if (i.getClase().equalsIgnoreCase(tipo)) {
					result.put(i.getCalle(), 1);
				} else {
					result.put(i.getCalle(), 0);
				}
			}

		}

		return result;
	}

	public Map<String, Integer> mostrarCallesFamiliar() {
		return mostrarCallesTipo("FAMILIAR");
	}

	public Map<String, Integer> mostrarCallesDistrito() {
		return mostrarCallesTipo("DISTRITO");
	}
	
	public Set<Caseta> mostrarCasetasDistrito() {
		return mostrarCasetasPorTipo("DISTRITO");
	}

	public Set<Caseta> mostrarCasetasFamiliar() {
		return mostrarCasetasPorTipo("FAMILIAR");
	}
	
	public boolean eliminarCaseta(String titulo) {
		boolean result = false;

		Iterator<Caseta> siguiente = casetas.iterator();
		Caseta i;

		while (siguiente.hasNext() && !result) {
			i = siguiente.next();

			if (i.getTitulo().equalsIgnoreCase(titulo)) {
				siguiente.remove();
				result = true;
			}
		}

		return result;
	}
}
