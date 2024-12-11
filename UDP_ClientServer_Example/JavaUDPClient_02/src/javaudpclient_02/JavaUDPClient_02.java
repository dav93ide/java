/*********************************************
 *    ESERCIZIO NUMERO 4 PAGINA 113-114      *
 *********************************************/

package javaudpclient_02;

import java.io.IOException;
import java.net.*;
import java.util.Scanner;
import java.nio.ByteBuffer;

public class JavaUDPClient_02 {

    private DatagramSocket sckt;

    public JavaUDPClient_02() throws SocketException{
        sckt = new DatagramSocket();
        sckt.setSoTimeout(5000);
    }

    public void closeSocket() {
        sckt.close();
    }

    public void sendPacket(ByteBuffer bB, InetAddress addr, int iPort) throws IOException {     // Invia Pacchetto
        byte[] buff;
        DatagramPacket data;
        if (sckt.isClosed()) {
            throw new IOException();
        }
        data = new DatagramPacket(bB.array(), 8, addr, iPort);
        sckt.send(data);
    }
  
    public String receivePacket(InetAddress addr, int iPort) throws IOException {       // Riceve Pacchetto E Visualizza Successo O Insuccesso Operazione
        byte[] buff = new byte[8];
        DatagramPacket data = new DatagramPacket(buff, buff.length);
        data = new DatagramPacket(buff, buff.length, addr, iPort);
        sckt.receive(data);
        ByteBuffer bybu = ByteBuffer.wrap(buff,0,4);
        int a = bybu.getInt();
        return new String(((a==0)?"\t\tInserito":"\t\tErrore Inserimento"));
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        try {
            JavaUDPClient_02 jUDP = new JavaUDPClient_02();
            int nPort = 12345;
            System.out.println("Inserire Host");
            String host = input.next();
            while (true) {
                boolean check = true;
                ByteBuffer bybu = ByteBuffer.allocate(8);
                System.out.println("Selezionare Operazione: \n\t 1] ON \n\t 2] OFF \n\t 3] Esci \n\t\t(ON-OFF-Esci) \n\t\t(Inserimento Tipo Stringa - CaseSensitive)");
                String choose = input.next();
                switch (choose) {
                    case "ON":
                        bybu.putInt(1);
                        break;
                    case "OFF":               
                        bybu.putInt(0);
                        break;
                    case "Esci":
                        jUDP.closeSocket();
                        System.exit(1);
                        break;
                    default:
                        System.err.println("Errore Nell'Inserimento");
                        check = false;
                        break;
                }
                if (check) {
                    System.out.println("-> Inserire Tempo In Secondi <-");
                    int time = input.nextInt();
                    bybu.putInt(time);
                    InetAddress addr = InetAddress.getByName(host);
                    jUDP.sendPacket(bybu, addr, nPort);
                    System.out.println(jUDP.receivePacket(addr, nPort));
                }
            }
        } catch (SocketException SckEx) {
            SckEx.getStackTrace();
        } catch (IOException IOEx) {
            IOEx.getStackTrace();
        }

    }

}