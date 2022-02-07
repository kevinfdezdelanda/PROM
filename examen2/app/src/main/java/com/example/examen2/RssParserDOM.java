package com.example.examen2;

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
    public Clima parse() {
        //Instanciamos la fabrica para DOM
        DocumentBuilderFactory factory =
                DocumentBuilderFactory.newInstance();
        try {
            //Creamos un nuevo parser DOM
            DocumentBuilder builder = factory.newDocumentBuilder();
            //Realizamos la lectura completa del XML
            Document dom = builder.parse(this.getInputStream());
            //Nos posicionamos en el nodo principal del árbol (<rss>)
            Element root = dom.getDocumentElement();
            //Obtenemos el clima actual
            Element day = (Element) root.getElementsByTagName("day1").item(0);

            NodeList dayHijos = day.getChildNodes();

            String date="";
            int max = 0;
            int min = 0;
            String estado="";
            String icon = "";
            for (int j=0; j<dayHijos.getLength(); j++){
                Node dato = dayHijos.item(j);
                String etiqueta = dato.getNodeName();

                if (etiqueta.equals("date")){
                    date = obtenerTexto(dato);
                }else if (etiqueta.equals("temperature_max")){
                    String texto = obtenerTexto(dato);
                    max = Integer.parseInt(texto);
                }else if (etiqueta.equals("temperature_min")){
                    String texto = obtenerTexto(dato);
                    min = Integer.parseInt(texto);
                }else if (etiqueta.equals("icon")) {
                    icon = obtenerTexto(dato);
                }else if (etiqueta.equals("text")){
                    estado = obtenerTexto(dato);
                }
            }

            //Localizamos todos los elemntos <item>
            Element hour_hour = (Element) root.getElementsByTagName("hour_hour").item(0);
            //Obtenemos la hora actual
            Element hour1 = (Element) hour_hour.getElementsByTagName("hour1").item(0);

            Node tempNode = hour1.getElementsByTagName("temperature").item(0);
            int temp = Integer.parseInt(obtenerTexto(tempNode));

            Node horaNode = hour1.getElementsByTagName("hour_data").item(0);
            String hora = obtenerTexto(horaNode);

            return new Clima(date, hora, estado, max, min, temp, icon);

        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        }
        catch (Exception ex){
            throw new RuntimeException(ex);
        }
        return null;
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