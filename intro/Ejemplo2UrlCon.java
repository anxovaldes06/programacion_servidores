
import java.io.*;
import java.net.*;  //paquetes para manejo de direcciones

public class Ejemplo2UrlCon {

    public static void main(String[] args) {

        try {
            URL url = new URL("http://localhost:80/vernombre.php"); //indicamos la URL de respuesta del formulario, en el puerto 80.
            URLConnection conexion = url.openConnection();
            conexion.setDoOutput(true);     //establecemos conexion con la respuesta
            conexion.setRequestProperty("Content-Type", "application/x-www-form-urlencoded"); //comprobamos conexion

            String cadena = "nombre=Maria+Jesus&apellidos=Ramos+Martin&edad=19";    //está es la cadena de texto que tiene que devolver la respuesta

            // ESCRIBIR EN LA URL
            PrintWriter output = new PrintWriter(
                    conexion.getOutputStream());
            
            output.write(cadena);           
            output.close(); // cerrar flujo

            // LEER DE LA URL
            BufferedReader reader = new BufferedReader(
                    new InputStreamReader(conexion.getInputStream()));

            String linea;                   //lee el texto de la URL

            while ((linea = reader.readLine()) != null) {
                System.out.println(linea);          //si el texto no es nulo, lo imprime
            }

            reader.close(); // cerrar flujo

        } catch (MalformedURLException me) {    
            System.err.println("MalformedURLException: " + me);             //en caso de error, devuele excepcion
        } catch (IOException ioe) {                         
            System.err.println("IOException: " + ioe);
        }
    } // main

} // Ejemplo2urlCon