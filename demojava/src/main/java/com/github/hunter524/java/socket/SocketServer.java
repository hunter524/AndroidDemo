package com.github.hunter524.java.socket;

import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.StringReader;
import java.io.StringWriter;
import java.io.UnsupportedEncodingException;
import java.net.Inet4Address;
import java.net.Inet6Address;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;
import jdk.net.Sockets;

/**
 * Created by hunter on 2017/7/6.
 */

public class SocketServer {
  public static void main(String[] arg){
    InetAddress localhost = null;
    ServerSocket serverSocket = null;
    try {
     localhost = InetAddress.getByAddress("localhost", new byte[] { 127, 0, 0, 1 });
    } catch (UnknownHostException e) {
      e.printStackTrace();
    }
    try {
      serverSocket = new ServerSocket(542,10,localhost);
    } catch (IOException e) {
      e.printStackTrace();
    }
    while (true){
      try {
        Socket accept = serverSocket.accept();
        new SocketServerThread(accept).start();
      } catch (IOException e) {
        e.printStackTrace();
      }
    }
  }

  public static class SocketServerThread extends Thread{
    Socket mSocket;

    public SocketServerThread(Socket socket) {
      mSocket = socket;
    }

    @Override public void run() {
      super.run();
      OutputStream outputStream = null;
      OutputStreamWriter outputStreamWriter = null;
      try {
        outputStream = mSocket.getOutputStream();
        outputStreamWriter= new OutputStreamWriter(outputStream,"utf-8");
      } catch (UnsupportedEncodingException e) {
        e.printStackTrace();
      } catch (IOException e) {
        e.printStackTrace();
      }
      while (true){
        try {
          Thread.sleep(2000);
          outputStreamWriter.write(System.currentTimeMillis()+"ThreadName"+Thread.currentThread().getName());
        } catch (InterruptedException e) {
          e.printStackTrace();
        } catch (IOException e) {
          e.printStackTrace();
        }
      }
    }
  }
}
