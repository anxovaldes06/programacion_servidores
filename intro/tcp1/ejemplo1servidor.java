package tcp1;

import java.io.*;
import java.net.*;
import java.util.Scanner;
   
public class ejemplo1servidor {
    
    public static void main ( String [] args) {

            try {
                int port = 6000;
                ServerSocket servidor = new ServerSocket(port);
                System.out.println("Escuchando en : " + servidor.getLocalPort());

              try{  
                Socket clienteConectado = servidor.accept();
                DataInputStream flujoEntrada =
                    new DataInputStream(clienteConectado.getInputStream());
                DataOutputStream flujoSalida =
                    new DataOutputStream(clienteConectado.getOutputStream());
                boolean sigue = true;
                Scanner sc = new Scanner(System.in);

               while (sigue) {

    String mensajeCliente = flujoEntrada.readUTF();
    System.out.println();
    System.out.println("Cliente: " + ecoUpperCase(mensajeCliente));

    if (mensajeCliente.equalsIgnoreCase("salir")) {
        sigue = false;
        break;
    }

    System.out.print("Servidor: ");
    System.out.flush();
    String mensajeServidor = sc.nextLine();

    flujoSalida.writeUTF(mensajeServidor);
    flujoSalida.flush();

    if (mensajeServidor.equalsIgnoreCase("salir")) {
        sigue = false;
    }
}
                sc.close();
                flujoEntrada.close();
                flujoSalida.close();
                clienteConectado.close();
                servidor.close();

              }catch(IOException e2){
                System.out.println("ERROR en el Socket" +e2.getMessage());
                e2.printStackTrace();
            
              }
            }catch(IOException e) {
                System.out.println("ERROR en el ServerSocker " + e.getMessage());
                e.printStackTrace();
            }
    
        }

        public static String ecoUpperCase( String mensaje ) {
            return mensaje.toUpperCase();
        }
}
 