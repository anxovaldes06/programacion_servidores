package tcp2;

import java.io.*;
import java.net.*;
import java.util.Scanner;

public class ejemplo2cliente {
    public static void main ( String [] args) {
        try {
    String host = "localhost";
    int port = 6000;
    Socket client = new Socket(host,port);
    System.out.println("Dame un número entero positivo mayor que 0 y menor que 1000: ");
    
    DataOutputStream flujoSalida = new DataOutputStream(client.getOutputStream());
    DataInputStream flujoEntrada = new DataInputStream(client.getInputStream());
    boolean sigue = true;
    Scanner sc = new Scanner(System.in);

   
while (sigue) {

    System.out.print("Cliente: ");
    int mensajeCliente = sc.nextInt();

    flujoSalida.writeInt(mensajeCliente);
    flujoSalida.flush();

    String mensajeServidor = (flujoEntrada.readUTF());
    System.out.println("Servidor: " + mensajeServidor);


    if(mensajeServidor.equals("ERROR : Número no válido")){
        sigue=false;
    }  


     
    }
    sc.close();
    flujoSalida.close();
    flujoEntrada.close();
    client.close();
    
    }catch(IOException e) {
            e.printStackTrace();

        }
    }


}
