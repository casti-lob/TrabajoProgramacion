package com.feria;

import java.io.File;

import javax.lang.model.element.Element;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class Lectura {
	
	public static void main(String[] args) {
		File file = new File("");
		
		try {
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.parse(file);
			
			doc.getDocumentElement().normalize();
			System.out.println(doc.getDocumentElement().getNodeName());
			NodeList hijos = doc.getDocumentElement().getChildNodes();
			
			for(int i =0;i<hijos.getLength();i++) {
				Node hijo=hijos.item(i);
				if(hijo.getNodeType()==Node.ELEMENT_NODE) {
					Element elemento = (Element)hijo;
					System.out.println(((Object) elemento).getattribute("id"));
					/*
					System.out.println(((DocumentBuilderFactory) elemento).getAttribute("id"));
					NodeList p1 = elemento.getElementsByTagName("marca");
					p1= elemento
					System.out.println(elemento.getElementsByTagName("marca").item(0).get);
				*/
					NodeList hijoshijo=elemento.getchildNodes();
					for(int j=0; j<hijoshijo.getLength();i++) {
						Node nieto= hijoshijo.item(j);
						if(nieto.getNodeType()==Node.ELEMENT_NODE) {
							Element nietoElemento=(Element) nieto;
							System.out.println(nietoElemento.getTextContent());
						}
					}
				}
				
				File lileEscritura= new File("");
				DocumentBuilderFactory dbFactoryEscritura = DocumentBuilderFactory.newInstance();
				DocumentBuilder dBuilderEscritura = dbFactory.newDocumentBuilder();
				Document docEscritura = dBuilder.parse(file);
				
				Element rootElement= docEscritura.createElement("Primero");
				docEscritura.appendChild(rootElement);
			}
		
		} catch(Exception e) {
			System.out.println(e.getMessage());
			}
		
	}
	
}
