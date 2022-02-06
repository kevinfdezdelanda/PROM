package com.example.ejxml;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

public class RssParserDOM {

    private URL rssURL;

    public RssParserDOM(String url){
        try{
            this.rssURL =new URL (url);
        }catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }
    public List<Clima> parse() {
        //Instanciamos la fabrica para DOM
        DocumentBuilderFactory factory =
                DocumentBuilderFactory.newInstance();
        List<Clima> climas = new ArrayList<>();
        try {
            //Creamos un nuevo parser DOM
            DocumentBuilder builder = factory.newDocumentBuilder();
            //Realizamos la lectura completa del XML
            Document dom = builder.parse(this.getInputStream());
            //Nos posicionamos en el nodo principal del árbol (<rss>)
            Element root = dom.getDocumentElement();
            //Localizamos todos los elemntos <item>
            Element prediccion = (Element) root.getElementsByTagName("prediccion").item(0);
            NodeList items = prediccion.getElementsByTagName("dia");
            //Recorremos la lista de clima
            for (int i=0; i<items.getLength(); i++){
                //Obtenemos el clima actual
                Node item = items.item(i);

                String fecha = ((Element) item).getAttribute("fecha");

                Node temperatura = ((Element) item).getElementsByTagName("temperatura").item(0);
                NodeList temps = temperatura.getChildNodes();

                System.out.println(temps.item(0).getNodeValue());

                int max = 0;
                int min = 0;
                for (int j=0; j<temps.getLength(); j++){
                    Node dato = temps.item(j);
                    String etiqueta = dato.getNodeName();

                    if (etiqueta.equals("maxima")){
                        String texto = obtenerTexto(dato);
                        max = Integer.parseInt(texto);
                    }
                    else if (etiqueta.equals("minima")){
                        String texto = obtenerTexto(dato);
                        min = Integer.parseInt(texto);
                    }
                }

                climas.add(new Clima(fecha, max, min));
            }
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        }
        catch (Exception ex){
            throw new RuntimeException(ex);
        }
        return climas;
    }
    public String obtenerTexto (Node dato) {
        StringBuilder texto = new StringBuilder();
        NodeList fragmentos = dato.getChildNodes();
        for (int k=0; k<fragmentos.getLength(); k++) {
            texto.append(fragmentos.item(k).getNodeValue());
        }
        return texto.toString();
    }
    private InputStream getInputStream() {
        try {
            return rssURL.openConnection().getInputStream();
        }
        catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}