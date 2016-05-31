package com.richardxu.loadbalance;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;

public class LoadBalancer {
    private Map<String, Integer> serverWeightMap = new HashMap<String, Integer>();
    {
        serverWeightMap.put("192.168.1.100", 1);
        serverWeightMap.put("192.168.1.101", 1);
        serverWeightMap.put("192.168.1.102", 4);
        serverWeightMap.put("192.168.1.103", 1);
        serverWeightMap.put("192.168.1.104", 1);
        serverWeightMap.put("192.168.1.105", 3);
        serverWeightMap.put("192.168.1.106", 1);
        serverWeightMap.put("192.168.1.107", 2);
        serverWeightMap.put("192.168.1.108", 1);
        serverWeightMap.put("192.168.1.109", 1);
        serverWeightMap.put("192.168.1.110", 1);
    }

    private Integer pos = 0;

    // 轮询
    public String roundRobin() {
        // 重建一个map，避免出现由于服务器上线和下线导致的并发问题
        Map<String, Integer> serverMap = new HashMap<String, Integer>();
        serverMap.putAll(serverWeightMap);

        // 取得IP地址list
        Set<String> keySet = serverMap.keySet();
        List<String> keyList = new ArrayList<String>();
        keyList.addAll(keySet);

        String server = null;

        synchronized (pos) {
            if (pos >= keySet.size()) {
                pos = 0;
            }
            server = keyList.get(pos);
            pos++;
        }
        return server;
    }

    // 随机: 基于概率统计，吞吐量越大，随机算法的效果越接近轮询算法的效果
    public String random() {
        // 重建一个map，避免出现由于服务器上线和下线导致的并发问题
        Map<String, Integer> serverMap = new HashMap<String, Integer>();
        serverMap.putAll(serverWeightMap);

        // 取得IP地址list
        Set<String> keySet = serverMap.keySet();
        List<String> keyList = new ArrayList<String>();
        keyList.addAll(keySet);

        Random random = new Random();
        int randomPos = random.nextInt(keyList.size());
        return keyList.get(randomPos);
    }

    public String ipHash(String remoteIp) {
        // 重建一个map，避免出现由于服务器上线和下线导致的并发问题
        Map<String, Integer> serverMap = new HashMap<String, Integer>();
        serverMap.putAll(serverWeightMap);

        // 取得IP地址list
        Set<String> keySet = serverMap.keySet();
        List<String> keyList = new ArrayList<String>();
        keyList.addAll(keySet);

        int hashCode = remoteIp.hashCode();
        int serverListSize = keyList.size();
        int serverPos = Math.abs(hashCode % serverListSize);
        return keyList.get(serverPos);
    }

    public String weightRoundRobin() {
        // 重建一个map，避免出现由于服务器上线和下线导致的并发问题
        Map<String, Integer> serverMap = new HashMap<String, Integer>();
        serverMap.putAll(serverWeightMap);

        // 取得IP地址list
        Set<String> keySet = serverMap.keySet();
        Iterator<String> it = keySet.iterator();
        
        List<String> serverList = new ArrayList<String>();
        while (it.hasNext()) {
            String server = it.next();
            Integer weight = serverMap.get(server);
            for (int i = 0; i < weight; i++) {
                serverList.add(server);
            }
        }
        
        String server = null;
        synchronized (pos) {
            if (pos >= serverList.size()) {
                pos = 0;
            }
            server = serverList.get(pos);
            pos++;
        }
        return server;
    }
    
    // 加权随机
    public String weightRandom() {
        // 重建一个map，避免出现由于服务器上线和下线导致的并发问题
        Map<String, Integer> serverMap = new HashMap<String, Integer>();
        serverMap.putAll(serverWeightMap);

        // 取得IP地址list
        Set<String> keySet = serverMap.keySet();
        Iterator<String> it = keySet.iterator();
        
        List<String> serverList = new ArrayList<String>();
        while (it.hasNext()) {
            String server = it.next();
            Integer weight = serverMap.get(server);
            for (int i = 0; i < weight; i++) {
                serverList.add(server);
            }
        }
        
        Random random = new Random();
        int randomPos = random.nextInt(serverList.size());
        return serverList.get(randomPos);
    }

    public static void main(String[] args) {
        LoadBalancer lb = new LoadBalancer();
        for (int i = 0; i < 10; i++) {
            System.out.println(lb.random());
        }

        System.out.println("--------------------");
        for (String ip : lb.getServerWeightMap().keySet()) {
            System.out.println(ip + ", " + lb.ipHash(ip));
        }
        
        System.out.println("--------------------");
        for (int i = 0; i < 10; i++) {
            System.out.println(lb.weightRoundRobin());
        }
        
        System.out.println("--------------------");
        for (int i = 0; i < 10; i++) {
            System.out.println(lb.weightRandom());
        }
    }

    public Map<String, Integer> getServerWeightMap() {
        return serverWeightMap;
    }

}
