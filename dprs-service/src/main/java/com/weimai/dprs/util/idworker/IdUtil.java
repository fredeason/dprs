package com.weimai.dprs.util.idworker;

import com.weimai.dprs.constant.Constants;
import com.weimai.wmcommon.idwork.SimpleIdWorkerFactory;
import com.weimai.wmcommon.util.spring.SpringUtil;
import org.springframework.core.env.Environment;

/**
 * Created by baiqian@myweimai.com on 2016/11/9.
 */
public class IdUtil {
    private static Long workerId = null;

    public static Long nextId(){
        return SimpleIdWorkerFactory.getInstance(getWorkId()).nextId();
    }

    private static Long getWorkId(){
        Environment env = SpringUtil.getBean(Environment.class);
        if(workerId == null){
            workerId = Long.valueOf(env.getProperty(Constants.SYS_WORK_ID_NAME));
        }
        return workerId;
    }

}