package com.study.rmi;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * Created by ruan on 2016/7/4.
 */
public interface HelloService extends Remote {

    String sayHello(String name) throws RemoteException;

}
