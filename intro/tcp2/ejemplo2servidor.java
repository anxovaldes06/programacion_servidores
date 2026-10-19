package tcp2;

import java.io.*;
import java.net.*;
import java.util.Scanner;
   
public class ejemplo2servidor {
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

    int mensajeCliente = flujoEntrada.readInt();
   
    System.out.println();
    System.out.println("Cliente: " +mensajeCliente);

   if(mensajeCliente>0 && mensajeCliente < 1000){
   
    String mensajeServidor = mensajeCliente + " es un número perfecto ? " +  numperfecto.esNumeroPerfecto(mensajeCliente);
    flujoSalida.writeUTF(mensajeServidor);
    flujoSalida.flush();
   sigue=true;
   }

    if (mensajeCliente<=0 || mensajeCliente >=1000) {
       flujoSalida.writeUTF("ERROR : Número no válido");
       flujoSalida.flush();
        sigue=false;
        
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

       

}
 