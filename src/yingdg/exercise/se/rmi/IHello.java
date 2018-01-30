package yingdg.exercise.se.rmi;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * Created by yingdg on 2018/1/21.
 */
public interface IHello extends Remote {
    // 接口的所有方法都必须抛出RemoteException以说明该方法是有风险的
    String sayHello() throws RemoteException;
}
