package com.github.hunter524.java.socket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.InetAddress;
import java.net.Socket;

/**
 * Created by hunter on 2017/7/6.
 */

public class SocketClient {
  public static void main(String[] arg){
    byte[] addr = { 127, 0, 0, 1 };
    InetAddress address = null;
    //try {
    //  address = SocketAddress
    //} catch (UnknownHostException e) {
    //  e.printStackTrace();
    //}
    Socket socket = null;
    InputStream inputStream = null;
    try {
      socket = new Socket("localhost", 542);
     inputStream = socket.getInputStream();
    } catch (IOException e) {
      e.printStackTrace();
    }

    while (true){
      try {
        //InputStreamReader inputStreamReader = new InputStreamReader(inputStream, "utf-8");
        //BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
        //System.out.println(bufferedReader.readLine());
        //IO读取不到数据会阻塞线程
        //也可以这么读 每次获取一个char
        char read = (char) inputStream.read();
        System.out.print(read);
        int available = inputStream.available();
        System.out.println("available :"+available);
      } catch (IOException e) {
        e.printStackTrace();
      }
    }
  }
}
