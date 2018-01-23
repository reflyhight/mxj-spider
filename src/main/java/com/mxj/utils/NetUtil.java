package cn.entgroup.utils;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class NetUtil {

	public static String getIpAddr() throws UnknownHostException{
		InetAddress server = InetAddress.getLocalHost();
		return server.getHostAddress();
	}
}
