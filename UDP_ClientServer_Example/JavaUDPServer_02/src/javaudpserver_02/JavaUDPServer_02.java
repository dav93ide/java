/*********************************************
 *    ESERCIZIO NUMERO 4 PAGINA 113-114      *
 *********************************************/

package javaudpserver_02;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;
import java.nio.ByteBuffer;
import java.util.Calendar;

public class JavaUDPServer_02 implements Runnable {
    
    RegistroEventi op;
    DatagramSocket sckt;

    public JavaUDPServer_02() throws SocketException {
        sckt = new DatagramSocket(12345);
        sckt.setSoTimeout(1000);
    }

    public ByteBuffer decodeString(byte[] b,String sAdd) throws InterruptedException{
        ByteBuffer bybu;
        bybu = ByteBuffer.wrap(b,0,8);
        int a = bybu.getInt();
        int time = bybu.getInt();
        ByteBuffer ret = ByteBuffer.allocate(8);
        Calendar c = Calendar.getInstance();
        Calendar ct = Calendar.getInstance();
        ct.add(ct.SECOND,time);     // Aggiungo Secondi A Data Attuale
        if(op.addOp(a,ct,sAdd,c))
            ret.putInt(0);
        else
            ret.putInt(255);
        return ret;
    }

    @Override
    public void run() {                         // Esecuzione Server
        op = new RegistroEventi();              // Creo Thread "RegistroEventi" Di Simulazione Esecuzione
        op.start();
        DatagramPacket answer;
        byte[] buffer = new byte[8];
        DatagramPacket request = new DatagramPacket(buffer, buffer.length);
        while (true) {
            try {
                sckt.receive(request);
                String sAdd = request.getAddress().getHostAddress();
                ByteBuffer bybu = this.decodeString(request.getData(),sAdd);
                answer = new DatagramPacket(bybu.array(),4, request.getAddress(), request.getPort());
                sckt.send(answer);
            } catch (IOException exIO) {
                exIO.getStackTrace();
            }
            catch (InterruptedException inEx){
                inEx.getStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        try {
            Thread server = new Thread(new JavaUDPServer_02());
            server.start(); 
            server.join();
        } catch (IOException exception) {
            System.err.println("Errore!" + exception);
        } catch (InterruptedException exception) {
            System.err.println("Errore!" + exception);
        }
    }

}
