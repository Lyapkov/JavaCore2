package Lesson7.Server;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ClientHandler {

    private MyServer myServer;
    private Socket socket;
    private DataInputStream in;
    private DataOutputStream out;
    private final ScheduledExecutorService scheduledExecutor = new ScheduledThreadPoolExecutor(1);
    private boolean isAuthorization = false;

    private String name;

    public ClientHandler(MyServer myServer, Socket socket) {
        try {
            this.myServer = myServer;
            this.socket = socket;
            this.in = new DataInputStream(socket.getInputStream());
            this.out = new DataOutputStream(socket.getOutputStream());
            this.name = "";
            new Thread( () -> {
                try {
                    scheduledExecutor.schedule(() -> checkAuthorization(), 120, TimeUnit.SECONDS);
                    authentication();
                    readMessages();
                } catch (IOException e) {
                    e.printStackTrace();
                } finally {
                    closeConnection();
                }
            }).start();
        } catch (IOException e) {
            throw new RuntimeException("Проблемы при создании обработчика клиента");
        }
    }

    public String getName() {
        return name;
    }

    public void authentication() throws IOException {
        while (true) {
            String str = in.readUTF();
            if (str.startsWith("/auth")) {
                String[] parts = str.split("\\s");
                String nick = myServer.getAuthService().getNickByLoginPass(parts[1], parts[2]);
                if (nick != null) {
                    if (!myServer.isNickBusy(nick)) {
                        isAuthorization = true;
                        sendMsg("/authok" + nick);
                        name = nick;
                        myServer.broadcastMsg(name + " зашел в чат");
                        myServer.subscribe(this);
                        return;
                    } else {
                        sendMsg("Учетная запись уже используется");
                    }
                } else {
                    sendMsg("Неверные логин/пароль");
                }
            }
        }
    }

    public void readMessages() throws IOException {
        while (true) {
            String strFromClient = in.readUTF();
            if (strFromClient.startsWith("/w")) {
                String[] parts = strFromClient.split("\\s");
                if (myServer.personalMsg(parts[1], "Личное сообщение от " + name + ": " + unionString(parts))) {
                    myServer.personalMsg(name, "Сообщение успешно отправлено");
                } else {
                    myServer.personalMsg(name, "Пользователя нет в сети");
                }
            } else {
                System.out.println("от " + name + ": " + strFromClient);
                if (strFromClient.equals("/end")) {
                    return;
                }
                myServer.broadcastMsg(name + ": " + strFromClient);
            }
        }
    }

    private String unionString(String[] parts) {
        String str = null;
        for (int i = 2; i < parts.length; i++) {
            str += parts[i];
        }
        return str;
    }

    public void sendMsg(String msg) {
        try {
            out.writeUTF(msg);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void closeConnection() {
        myServer.unsubscribe(this);
        myServer.broadcastMsg(name + "");
        try {
            in.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void checkAuthorization(){
        if (!isAuthorization) {
            closeConnection();
        }
    }

}
