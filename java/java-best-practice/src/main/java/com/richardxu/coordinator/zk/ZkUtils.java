package com.richardxu.coordinator.zk;

import java.util.List;

import javax.annotation.Resource;

import org.I0Itec.zkclient.IZkChildListener;
import org.I0Itec.zkclient.ZkClient;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.google.common.collect.Lists;

/**
 * Zookeeper Client Util
 */
public class ZkUtils {

    private static final Log logger = LogFactory.getLog(ZkUtils.class);
    
    @Resource
    private ZkClient zkClient;
    
    /**
     * 是否存在节点
     * @param path
     * @return
     */
    public boolean exists(String path) {
        if (StringUtils.isBlank(path)) 
            throw new IllegalArgumentException();
        
        return zkClient.exists(path);
    }

    /**
     * 新增持久化节点
     * @param path
     */
    public boolean createPersistent(String path) {
        if (StringUtils.isBlank(path)) 
            throw new IllegalArgumentException();
        
        try {
            zkClient.createPersistent(path, true);
            return true;
        } catch (Exception e) {
            if (logger.isErrorEnabled()) {
                logger.error("##ZkUtils: createPersistent error, path: [" + path + "], error: " + e);
            }
        }
        return false;
    }
    
    /**
     * 新增持久化节点，并同时插入数据
     * @param path
     * @param data
     */
    public boolean createPersistentWithData(String path, Object data) {
        if (StringUtils.isBlank(path)) 
            throw new IllegalArgumentException();
        
        if (createPersistent(path)) {
            try {
                zkClient.writeData(path, data);
                return true;
            } catch (Exception e) {
                if (logger.isErrorEnabled()) {
                    logger.error("##ZkUtils: createPersistentWithData error, path: [" + path + "], data: [" + data + "], error: " + e);
                }
            }
        }
        return false;
    }
    
    /**
     * 创建瞬时节点
     * @param path
     * @param data
     */
    public boolean createEphemeral(String path) {
        if (StringUtils.isBlank(path)) 
            throw new IllegalArgumentException();

        try {
            zkClient.createEphemeral(path);
            return true;
        } catch (Exception e) {
            if (logger.isErrorEnabled()) {
                logger.error("##ZkUtils: creatEphemeral error, path: [" + path + "], error: " + e);
            }
        }
        return false;
    }

    /**
     * 创建瞬时节点
     * @param path
     * @param data
     */
    public boolean createEphemeralWithData(String path, String data) {
        if (StringUtils.isBlank(path))
            throw new IllegalArgumentException();

        try {
            zkClient.createEphemeral(path, data);
            return true;
        } catch (Exception e) {
            if (logger.isErrorEnabled()) {
                logger.error("##ZkUtils: creatEphemeralWithData error, path: [" + path + "], data: [" + data + "], error: " + e);
            }
        }
        return false;
    }

    /**
     * 写数据
     * 
     * @param path
     * @param data
     * @return
     */
    public boolean writeData(String path, String data) {
        if (StringUtils.isBlank(path)) 
            throw new IllegalArgumentException();
        
        try {
            zkClient.writeData(path, data);
            return true;
        } catch (Exception e) {
            if (logger.isErrorEnabled()) {
                logger.error("##ZkUtils: writeData error, path: [" + path + "], data: [" + data + "], error: " + e);
            }
        }
        return false;
    }
    
    /**
     * 读数据
     * 
     * @param path
     * @param data
     * @return
     */
    public Object readData(String path) {
        if (StringUtils.isBlank(path)) 
            throw new IllegalArgumentException();
        
        try {
            return zkClient.readData(path, true);
        } catch (Exception e) {
            if (logger.isErrorEnabled()) {
                logger.error("##ZkUtils: writeData error, path: [" + path + "], error: " + e);
            }
        }
        return null;
    }

    /**
     * 删除节点
     * 
     * @param path
     * @return
     */
    public boolean delete(String path) {
        if (StringUtils.isBlank(path))
            throw new IllegalArgumentException();
        
        try {
            zkClient.delete(path);
            return true;
        } catch (Exception e) {
            if (logger.isErrorEnabled()) {
                logger.error("##ZkUtils: deleteNode error, path: " + path + ", error: " + e);
            }
        }
        return false;
    }
    
    /**
     * 是否拥有子节点
     * 
     * @param path
     * @return
     */
    public boolean hasChildren(String path) {
        if (StringUtils.isBlank(path))
            throw new IllegalArgumentException();
        
        try {
            return zkClient.getChildren(path).size() > 0;
        } catch (Exception e) {
            if (logger.isErrorEnabled()) {
                logger.error("##ZkUtils: hasChildren error, path: " + path + ", error: " + e);
            }
        }
        return false;
    }

    /**
     * 获取path子节点名列表
     * 
     * @param path
     * @return
     */
    public List<String> getChildren(String path) {
        if (StringUtils.isBlank(path))
            throw new IllegalArgumentException();
        
        try {
            return zkClient.getChildren(path);
        } catch (Exception e) {
            if (logger.isErrorEnabled()) {
                logger.error("##ZkUtils: getChildren error, path: " + path + ", error: " + e);
            }
        }
        return Lists.newArrayList();
    }
    
    /**
     * 获取第一个子节点名
     * 
     * @param path
     * @return
     */
    public String getFirstChild(String path) {
        if (StringUtils.isBlank(path))
            throw new IllegalArgumentException();
        
        try {
            return zkClient.getChildren(path).get(0);
        } catch (Exception e) {
            if (logger.isErrorEnabled()) {
                logger.error("##ZkUtils: getChildren error, path: " + path + ", error: " + e);
            }
        }
        return null;
    }
    
    public void subscribeStateChange(String path, IZkChildListener listener) {
//         zkClient.subscribeStateChanges(listener);
    }

}