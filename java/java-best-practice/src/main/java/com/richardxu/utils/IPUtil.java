package com.richardxu.utils;

import java.net.InetAddress;
import java.net.NetworkInterface;
import java.util.Enumeration;
import java.util.regex.Pattern;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class IPUtil {

    private static final Log LOG = LogFactory.getLog(IPUtil.class);

    private static volatile InetAddress LOCAL_ADDRESS = null;
    private static final    Pattern     IP_PATTERN    = Pattern.compile("\\d{1,3}(\\.\\d{1,3}){3,5}$");

    public static final String LOCALHOST = "127.0.0.1";
    public static final String ANYHOST   = "0.0.0.0";

    public static String getLocalIP() {
        InetAddress address = getLocalIPAddress();
        return address == null ? LOCALHOST : address.getHostAddress();
    }

    public static InetAddress getLocalIPAddress() {
        if (LOCAL_ADDRESS != null) return LOCAL_ADDRESS;
        InetAddress localAddress = getLocalAddress0();
        LOCAL_ADDRESS = localAddress;
        return localAddress;
    }

    private static InetAddress getLocalAddress0() {
        InetAddress localAddress = null;
        try {
            localAddress = InetAddress.getLocalHost();
            if (isValidAddress(localAddress)) {
                return localAddress;
            }
        } catch (Throwable e) {
            LOG.warn("Failed to retrieving ip address, " + e.getMessage(), e);
        }
        try {
            Enumeration<NetworkInterface> interfaces = NetworkInterface.getNetworkInterfaces();
            if (interfaces != null) {
                while (interfaces.hasMoreElements()) {
                    try {
                        NetworkInterface network = interfaces.nextElement();
                        Enumeration<InetAddress> addresses = network.getInetAddresses();
                        if (addresses != null) {
                            while (addresses.hasMoreElements()) {
                                try {
                                    InetAddress address = addresses.nextElement();
                                    if (isValidAddress(address)) {
                                        return address;
                                    }
                                } catch (Throwable e) {
                                    LOG.warn("Failed to retrieving ip address, " + e.getMessage(), e);
                                }
                            }
                        }
                    } catch (Throwable e) {
                        LOG.warn("Failed to retrieving ip address, " + e.getMessage(), e);
                    }
                }
            }
        } catch (Throwable e) {
            LOG.warn("Failed to retrieving ip address, " + e.getMessage(), e);
        }
        LOG.error("Could not get local host ip address, will use 127.0.0.1 instead.");
        return localAddress;
    }

    private static boolean isValidAddress(InetAddress address) {
        if (address == null || address.isLoopbackAddress()) return false;
        String name = address.getHostAddress();
        return (name != null && !ANYHOST.equals(name) && !LOCALHOST.equals(name) && IP_PATTERN.matcher(name).matches());
    }

    public static boolean isValidIp(String ip) {
        return (ip != null && !ANYHOST.equals(ip) && !LOCALHOST.equals(ip) && IP_PATTERN.matcher(ip).matches());
    }
    
    public static boolean isFuzzyQuery(String ip) {
        if (ip != null && ip.endsWith("*")) {
            return true;
        }
        return false;
    }

    public static String getFuzzyQueryIp(String ip) {
        if (ip != null && ip.length() > 1) {
            return ip.substring(0, ip.length() - 1);
        }
        return null;
    }
    
    /**
    *
    * @param request 请求信息
    * @return 请求来源真实的IP
    * 注意：仅在集团的生产网或者集团的标准环境下有效，不保证本地测试环境下有效
    */
   public static String getIpAddress(HttpServletRequest request){
       String clientIP = request.getHeader("NS-Client-IP");
       if(clientIP != null){
            return clientIP;
       } 
       
       clientIP = request.getHeader("X-Real-IP");
       if (StringUtils.isBlank(clientIP) || "unknown".equalsIgnoreCase(clientIP)) {
           clientIP = request.getHeader("X-Forwarded-For");
       }
       if (StringUtils.isBlank(clientIP) || "unknown".equalsIgnoreCase(clientIP)) {
           clientIP = request.getRemoteAddr();
       }
       return clientIP;
   }
    
}