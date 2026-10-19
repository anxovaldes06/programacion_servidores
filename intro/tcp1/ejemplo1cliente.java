package tcp1;

import java.io.*;
import java.net.*;
import java.util.Scanner;

public class ejemplo1cliente {
    public static void main ( String [] args) {
        try {
    String host = "localhost";
    int port = 6000;
    Socket client = new Socket(host,port);
    InetAddress i = client.getInetAddress();
    
    System.out.println("Puerto local : " + client.getLocalPort());
    System.out.println("Puerto remoto : " + client.getPort());
    System.out.println("Host remoto : " + i.getHostName().toString());
    System.out.println("IP Host remoto : " + i.getHostAddress().toString());

    DataOutputStream flujoSalida = new DataOutputStream(client.getOutputStream());
    DataInputStream flujoEntrada = new DataInputStream(client.getInputStream());
    boolean sigue = true;
    Scanner sc = new Scanner(System.in);

   
while (sigue) {

    System.out.print("Cliente: ");
    System.out.flush();
    String mensajeCliente = sc.nextLine();

    flujoSalida.writeUTF(mensajeCliente);
    flujoSalida.flush();

    if (mensajeCliente.equalsIgnoreCase("salir")) {
        sigue = false;
        break;
    }

    String mensajeServidor = flujoEntrada.readUTF();
    System.out.println("Servidor: " + mensajeServidor);

    if (mensajeServidor.equalsIgnoreCase("salir")) {
        sigue = false;
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