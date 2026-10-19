
import java.net.MalformedURLException;  
import java.net.URL; //paquetes para manejar direcciones URL en java

public class Ejemplo1URL {

    public static void main(String[] args) {
        URL url; //declaramos nueva variable URL

        try {
            System.out.println("Otro constructor simple para una URL:");
            url = new URL("http://localhost/PFC/gest/cli_gestion.php?S=3"); //damos nueva dirección
            Visualizar(url);        //imprime resultado

            System.out.println("Const. para protocolo +URL +directorio:"); //damos protocolo, URL y directorio
            url = new URL("http", "docs.oracle.com", "/javase/7"); //imprime resultado
            Visualizar(url);

            System.out.println("Constructor para protocolo + URL + puerto + directorio:"); //damos constructor,URL,puerto y directorio
            url = new URL("http", "docs.oracle.com", 80, "/javase/7");
            Visualizar(url); //imprime resultado

            System.out
                .println("Constructor para un objeto URL y un directorio:"); //damos URL y directorio
            URL urlBase = new URL("http://docs.oracle.com/");       //imprime resultado
            url = new URL(urlBase, "/javase/7/docs/api/java/net/URL.html");
            Visualizar(url);

        } catch (MalformedURLException e) { System.out.println(e); } //si falla imprime error
    } // main

    private static void Visualizar(URL url) {
        System.out.println("\tURL completa: " + url.toString());    // Da la dirección completa URL
        System.out.println("\ttgetProtocol(): " + url.getProtocol());   // Da el protocolo, es decir, método de comunicación de la URL
        System.out.println("\ttgetHost(): " + url.getHost());   //Da el el host donde se aloja dicha URL
        System.out.println("\ttgetPort(): " + url.getPort());   // Da el número  del puerto 
        System.out.println("\ttgetFile(): " + url.getFile());     //Devuelve la ruta hacia el fichero desde el servidor y metodo guetQuery
        System.out.println("\ttgetUserInfo(): " + url.getUserInfo());   //Devuelve datos usuario, en este caso nulo porque no hay
        System.out.println("\ttgetPath(): " + url.getPath());           //Devuelve la ruta hacia el fichero desde el servidor
        System.out.println("\ttgetAuthority(): " + url.getAuthority()); // Obtiene la autoridad del objeto URL
        System.out.println("\ttgetQuery(): " + url.getQuery());     //Devuelva la información que se envía a una página para ser procesada
        System.out
            .println("==================================================");
    }
}