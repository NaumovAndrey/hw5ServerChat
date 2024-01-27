package ru.gb;

import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите имя: ");
        String name = scanner.nextLine();

        try {
            Socket socket = new Socket(InetAddress.getLocalHost(), 5000); //создание подключение (ip, port)
            Client client = new Client(name, socket); // создание объекта Client
            InetAddress  inetAddress = socket.getInetAddress(); // получение ip, port сервера (изменяется после подключения по порту 5000)

            client.listenForMessage();
            client.sendMessage();

        } catch (UnknownHostException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}