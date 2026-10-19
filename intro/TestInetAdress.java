
import java.net.*; //paquetes para trabajar con redes en Java

public class TestInetAdress {
public static void main(String [] args){
    InetAddress dir = null; //declaramos nueva variable InetAdress sin valor 
    System.out.println("========================================");
    System.out.println("SALIDA PARA LOCALHOST: ");
    try {
        dir = InetAddress.getByName("localhost"); //busca la dirección IP local del ordenador/portátil
        pruebaMetodos(dir); //imprime el resultado

        System.out.println("========================================");
        System.out.println("SALIDA PARA UNA URL:");
        dir = InetAddress.getByName("www.google.es"); //busca la dirección IP de Google a través del enlace a la web oficial del buscacor
        pruebaMetodos(dir); //imprime resultado

        System.out.println("\tDIRECCIONES IP PARA: " +dir.getHostName()); //imprime las direcciones IP de Google buscando el nombre
        InetAddress[] direcciones = 
                        InetAddress.getAllByName(dir.getHostName()); 
        for(int i = 0 ; i < direcciones.length ; i++){
            System.out.println("\t\t"+direcciones[i].toString());
        }
        System.out.println("========================================");
    } catch (UnknownHostException e1) { e1.printStackTrace();   // recorriendo el array va imprimiendo las direcciones encontradas, en caso de no encontrarla da error
        // TODO: handle exception
    }
    

}       //main
    private static void pruebaMetodos (InetAddress dir){         
        System.out.println("\tMetodo getByName() : " +dir); //dada la dirección IP , imprime el nombre
        InetAddress dir2;
        try {
            dir2= InetAddress.getLocalHost();
        System.out.println("\tMetodo getLocalHost () : " +dir2); //imprime el nombre del dispositivo que alberga dicha direccion

        } catch (UnknownHostException e) { e.printStackTrace(); //da error si algo falla
            // TODO: handle exception
        }
        //imprime metodos y resultados
        System.out.println("\tMetodo getHostName() : " +dir.getHostName() );  //imprime nombre del host
        System.out.println("\tMetodo getHostAddress () : " +dir.getHostAddress() );  //imprime la direccion
        System.out.println("\tMetodo toString () : " + dir.toString());  //imprime tanto nombre como direccion
        System.out.println("\tMetodo getCanonicalHostName() : " +dir.getCanonicalHostName()); //devuelve la dirección real del host


    }
}
