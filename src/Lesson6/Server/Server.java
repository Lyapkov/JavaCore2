package Lesson6.Server;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Server {

    private String outMessage;
    private String inMessage;
    private DataInputStream in;
    private DataOutputStream out;
    Socket socket;
    private Scanner sc = new Scanner(System.in);
    private boolean isConnection = true;

    public void go(){
        try (ServerSocket serverSocket = new ServerSocket(8080)) {
            System.out.println("Сервер запущен, ожидаем подключения...");
            socket = serverSocket.accept();
            System.out.println("Клиент подключился");
            in = new DataInputStream(socket.getInputStream());
            out = new DataOutputStream(socket.getOutputStream());
            new Thread(new Runnable() {
                @Override
                public void run() {
                    while(isConnection)
                        acceptMessage();
                }
            }).start();

            new Thread(new Runnable() {
                @Override
                public void run() {
                    while (isConnection)
                        sendMessage();
                }
            }).start();

        } catch (IOException e) {
            e.printStackTrace();
        }
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
