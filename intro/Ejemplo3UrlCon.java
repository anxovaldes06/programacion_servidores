
import java.net.*;
import java.io.*;   //paquetes para manejo direcciones
import java.util.*;

public class Ejemplo3UrlCon {

    @SuppressWarnings ("rawtypes") //omite avisos aunque no se le indique el tipo de dato que va a contener 
    public static void main ( String[] args) throws Exception{ //puede lanzar excepciones

    String cadena;
URL url = new URL("http://localhost:80/formulario.html"); //nueva URL
URLConnection conexion = url.openConnection(); //abre la conexión

System.out.println(" Direccion [getURL()]: " + conexion.getURL()); //devuelve dirección URL

Date fecha = new Date(conexion.getLastModified());                              
System.out.println("Fecha ultima modificacion [getLastModified()]: " + fecha); //devuelve la última fecha de modificación

System.out.println("Tipo de contenido [getContentType()]: " //devuelve el tipo de contenido del archivo
        + conexion.getContentType());

System.out.println("======================================== ");
System.out.println("TODOS LOS CAMPOS DE CABECERA CON getHeaderFields(): ");

// USAMOS UNA ESTRUCTURA Map PARA RECUPERAR CABECERAS
Map camposcabecera = conexion.getHeaderFields();
Iterator it = camposcabecera.entrySet().iterator();

while (it.hasNext()) {
    Map.Entry map = (Map.Entry) it.next();
    System.out.println(map.getKey() + " : " + map.getValue());          //Guarda los datos de todas las cabeceras HTTP en un Map y los va recorriendo con el iterador imprimiendo los datos
}

System.out.println("======================================== ");
System.out.println("CAMPOS 1 Y 4 DE CABECERA:");                
System.out.println("getHeaderField(1)=> "
        + conexion.getHeaderField(1));
                                                                                //Mientras recorre el mapa, imprime los campos en la posición 1 y 4  de la cabecera
System.out.println("getHeaderField(4)=> "
        + conexion.getHeaderField(4));

System.out.println("========================================");

System.out.println("CONTENIDO DE [url.getFile()]: "
        + url.getFile());                   //devuelve el nombre del archivo de la URL

BufferedReader pagina = new BufferedReader( 
        new InputStreamReader(url.openStream()));       //sirve para leer la página

while ((cadena = pagina.readLine()) != null) {      //si la página no tiene nada no imprime, si tiene algo imprime la estructura y contenido de la misma
    System.out.println(cadena);
}

    }
    
}
