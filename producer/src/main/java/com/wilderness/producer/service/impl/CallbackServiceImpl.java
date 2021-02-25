package com.wilderness.producer.service.impl;

import com.wilderness.api.CallbackListener;
import com.wilderness.api.CallbackService;
import lombok.extern.slf4j.Slf4j;
import org.apache.dubbo.config.annotation.Argument;
import org.apache.dubbo.config.annotation.DubboService;
import org.apache.dubbo.config.annotation.Method;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author an_qiang
 */
@DubboService(methods = {@Method(name = "addListener", arguments = @Argument(index = 1, callback = true))})
@Slf4j
public class CallbackServiceImpl implements CallbackService {

    @Override
    public void addListener(String key, CallbackListener listener) {
        log.debug("addListener " + key);
        listener.changed(getChanged(key));
    }

    private String getChanged(String key) {
        return "Changed: " + key + " " + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
    }
}
