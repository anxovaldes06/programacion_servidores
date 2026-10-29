package udp2;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class EmisorUDP {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int puertoServidor = 12345;
        byte[] buffer = new byte[1024];

        try (DatagramSocket socket = new DatagramSocket()) {
            InetAddress destino = InetAddress.getLocalHost();
            boolean sigue = true;

            System.out.println("Cliente conectado. Escribe 'quit' para salir.");

            while (sigue) {
                System.out.print("Cliente: ");
                String mensajeCliente = sc.nextLine();
                byte[] mensaje = mensajeCliente.getBytes(StandardCharsets.UTF_8);
                DatagramPacket envio = new DatagramPacket(mensaje, mensaje.length, destino, puertoServidor);
                socket.send(envio);

                if (mensajeCliente.trim().equalsIgnoreCase("quit")) {
                    System.out.println("Has cerrado la conexión.");
                    break;
                }

                DatagramPacket recibo = new DatagramPacket(buffer, buffer.length);
                socket.receive(recibo);

                int bytesRec = recibo.getLength();
                String paquete = new String(recibo.getData(), 0, bytesRec, StandardCharsets.UTF_8);

                if (paquete.trim().equalsIgnoreCase("quit")) {
                    System.out.println("El servidor ha cerrado la conexión.");
                    break;
                }

                System.out.println("Servidor: " + paquete);
            }
        } catch (IOException e) {
            System.err.println("Error en el cliente UDP: " + e.getMessage());
            e.printStackTrace();
        }
        sc.close();
    }
}