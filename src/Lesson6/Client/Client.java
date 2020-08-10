package Lesson6.Client;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class Client {

    private static final String SERVER_HOST = "localhost";
    private static final int SERVER_PORT = 8080;

    private String outMessage;
    private String inMessage;
    private Scanner sc = new Scanner(System.in);
    private Socket socket;
    private DataInputStream in;
    private DataOutputStream out;
    private boolean isConnection = true;

    Client(){
        try {
            openConnection();
        } catch (IOException e) {
            System.out.println("Ошибка соединения!");
        }
    }

    private void openConnection() throws IOException {
        socket = new Socket(SERVER_HOST, SERVER_PORT);
        in = new DataInputStream(socket.getInputStream());
        out = new DataOutputStream(socket.getOutputStream());
        new Thread(new Runnable() {
            @Override
            public void run() {
                while (isConnection){
                    sendMessage();
                }
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                while (isConnection){
                    acceptMessage();
                }
            }
        }).start();
    }

    private void closeConnection(){
        try {
            socket.close();
        } catch (IOException e) {
            System.out.println("Сокет не закрылся!");
        }
        try {
            in.close();
        } catch (IOException e) {
            System.out.println("Входящий поток не закрылся!");
        }
        try {
            out.close();
        } catch (IOException e) {
            System.out.println("Выходящий поток не закрылся!");
        }
    }

    private void sendMessage(){
        try {
            outMessage = sc.next();
            if (outMessage.equalsIgnoreCase("/end")){
                out.writeUTF(outMessage);
                closeConnection();
                isConnection = false;
            } else
                out.writeUTF(outMessage);
        } catch (IOException e) {
            System.out.println("Ошибка отправки сообщения");
        }
    }

    private void acceptMessage(){
        try {
            inMessage = in.readUTF();
            if (inMessage.equalsIgnoreCase("/end")) {
                isConnection = false;
                closeConnection();
            }
            System.out.println(inMessage);
        } catch (IOException e)
        {
            System.out.println("Ошибка принятия сообщения");
        }
    }
}




