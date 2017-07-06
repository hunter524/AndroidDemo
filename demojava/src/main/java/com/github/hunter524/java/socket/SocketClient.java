package com.github.hunter524.java.socket;

import dagger.Binds;
import dagger.Module;
import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.net.SocketAddress;
import java.net.UnknownHostException;
import javax.inject.Inject;

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
    Module annotation =SocketClient.class.getAnnotation(Module.class);
    Class<?>[] includes = annotation.includes();
    Class<SocketClient> socketClientClass = SocketClient.class;
    try {
      Socket socket1 = new Socket("localhost", 542);
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}
