package com.richardxu.coordinator.zk;

import javax.annotation.Resource;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.commons.lang.StringUtils;
import com.richardxu.utils.IPUtil;

/**
 * 全局锁，用于在多个实例间抢夺执行任务的锁.
 */
public class GlobalLock {
	
	private static final Log logger = LogFactory.getLog(GlobalLock.class);
	
	// 默认的目录分隔符
    public final static String DEFAULT_SEPARATOR       = System.getProperty("file.separator");
    
	public final static String DEFAULT_GLOBAL_LOCK     = "/got/lock";
    
    private static final String LOCKNAME = IPUtil.getLocalIP();
    private final static String PATH = DEFAULT_GLOBAL_LOCK + DEFAULT_SEPARATOR + LOCKNAME;
    
    @Resource
    private ZkUtils zkUtils;
    
    public void init() {
        if (!zkUtils.exists(DEFAULT_GLOBAL_LOCK))
            zkUtils.createPersistent(DEFAULT_GLOBAL_LOCK);
        
        selfRegister();
    }
    
    public void destroy() {
        zkUtils.delete(PATH);
    }

    /**
     * @return true 获取锁成功，false 获取锁失败
     */
    public boolean lock() {
        boolean result;
        try {
            String firstChildNode = zkUtils.getFirstChild(DEFAULT_GLOBAL_LOCK);
            // 如果ZK全局锁结点的第一个子节点不为空
            if (StringUtils.isNotBlank(firstChildNode)) {
                if (firstChildNode.equals(LOCKNAME))
                    return true;            // 且是自己, 返回true 
                else
                    return false;           // 不是自己, 返回false
            } else {
                selfRegister();
                result = true;
            }
        } catch (Throwable t) {
            result = false;
            if (logger.isErrorEnabled()) {
                logger.error("Failed to lock " + LOCKNAME, t);
            }
        }
        return result;
    }

    private void selfRegister() {
        zkUtils.createEphemeral(PATH);
        if (logger.isInfoEnabled()) {
            logger.info("zk register, path: " + PATH);
        }
    }

}