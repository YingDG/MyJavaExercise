package yingdg.exercise.se.rmi;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

/**
 * Created by yingdg on 2018/1/21.
 */
public class Hello extends UnicastRemoteObject implements IHello {

    // 继承类的构造函数必须也抛出RemoteException
    public Hello() throws RemoteException {

    }

    @Override
    public String sayHello() throws RemoteException {
        return "Hello Java RMI";
    }

}
