package udp2;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class ReceptorUDP {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int puertoEscucha = 12345;
        byte[] buffer = new byte[1024];

        try (DatagramSocket socket = new DatagramSocket(puertoEscucha)) {
            boolean sigue = true;

            System.out.println("Servidor esperando datagramas en el puerto " + puertoEscucha + "... Escribe 'quit' para salir.");

            while (sigue) {
            
                DatagramPacket recibo = new DatagramPacket(buffer, buffer.length);
                socket.receive(recibo);

                int bytesRec = recibo.getLength();
                String paquete = new String(recibo.getData(), 0, bytesRec, StandardCharsets.UTF_8);

                if (paquete.trim().equalsIgnoreCase("quit")) {
                    System.out.println("El cliente ha salido de la conversación.");
                    break;
                }

                System.out.println("Cliente: " + paquete);
                System.out.print("Servidor: ");
                String mensajeServidor = sc.nextLine();

                byte[] mensaje = mensajeServidor.getBytes(StandardCharsets.UTF_8);
                DatagramPacket envio = new DatagramPacket(mensaje, mensaje.length, recibo.getAddress(), recibo.getPort());
                socket.send(envio);
                if (mensajeServidor.trim().equalsIgnoreCase("quit")) {
                    System.out.println("Has cerrado la conexión.");
                    break;
                }
            }

        } catch (IOException e) {
            System.err.println("Error en el servidor UDP: " + e.getMessage());
            e.printStackTrace();
        }

        sc.close();
    }
}