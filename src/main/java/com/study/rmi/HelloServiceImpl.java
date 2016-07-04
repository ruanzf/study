package com.study.rmi;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

/**
 * Created by ruan on 2016/7/4.
 */
public class HelloServiceImpl extends UnicastRemoteObject implements HelloService {

    protected HelloServiceImpl() throws RemoteException {}

    public String sayHello(String name) throws RemoteException {
        return String.format("Hello %s", name);
    }
}
