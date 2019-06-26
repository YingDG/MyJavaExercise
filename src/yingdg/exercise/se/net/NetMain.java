package yingdg.exercise.se.net;

import sun.security.util.SecurityConstants;

import java.net.CookieHandler;
import java.net.FileNameMap;
import java.net.HttpURLConnection;
import java.net.IDN;
import java.net.MalformedURLException;
import java.net.PasswordAuthentication;
import java.net.ProxySelector;
import java.net.SocketOptions;
import java.net.StandardProtocolFamily;
import java.net.StandardSocketOptions;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.Arrays;

/**
 * @author YingDG
 * created in 2019/6/24 11:10 AM
 */
public class NetMain {
    public static void main(String[] args) {
        /*
        URL类
         */
        try {
            URL url = new URL("http://www.runoob.com/html/html-tutorial.html");
            System.out.println("URL 是 " + url.toString());
            System.out.println("协议是" + url.getProtocol());
            System.out.println("文件名是" + url.getFile());
            System.out.println("主机是" + url.getHost());
            System.out.println("路径是" + url.getPath());
            System.out.println("端口号是" + url.getPort());
            System.out.println("默认端口号是" + url.getDefaultPort());
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        System.out.println(URLEncoder.encode("hello"));
        System.out.println(URLDecoder.decode("hello"));

        /*
        ServerSocket类，Socket类
        SocketAddress, InetSocketAddress,
         */

        /*
        SocketOptions
         */
        System.out.println(SocketOptions.SO_KEEPALIVE);

        // BindException, ContentHandlerFactory, CookieManager, CookiePolicy, FileNameMap,
        // HttpCookie, InetAddress, Inet4Address, Inet6Address,
        // SocketAddress, InetSocketAddress, MulticastSocket, NetPermission,
        // Proxy, SocketOption, SocketPermissionCollection,

        CookieHandler cookieHandler = CookieHandler.getDefault();

        System.out.println(SecurityConstants.SOCKET_ACCEPT_ACTION);

        /*
        URLConnection, HttpURLConnection
         */
        System.out.println(HttpURLConnection.HTTP_OK);
        System.out.println(HttpURLConnection.HTTP_NOT_FOUND);

        System.out.println(IDN.toASCII("hello"));
        System.out.println(IDN.toUnicode("hello"));

        System.out.println(new PasswordAuthentication("yingdg", "password".toCharArray()));

        System.out.println(Arrays.toString(StandardProtocolFamily.values()));

        ProxySelector proxySelector = ProxySelector.getDefault();

        System.out.println(StandardSocketOptions.SO_KEEPALIVE);

        FileNameMap fileNameMap = URLConnection.getFileNameMap();

        try {
            URI uri = new URI("http://www.runoob.com/html/html-tutorial.html#");
            System.out.println(uri.getHost());
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }

        /*
        URLPermission
         */

    }
}
