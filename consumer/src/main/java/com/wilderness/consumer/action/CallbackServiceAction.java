package com.wilderness.consumer.action;

import com.wilderness.api.CallbackService;
import lombok.extern.slf4j.Slf4j;
import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.stereotype.Component;

/**
 * @author an_qiang
 */
@Component
@Slf4j
public class CallbackServiceAction {

    @DubboReference(interfaceClass = CallbackService.class, timeout = 1000)
    private CallbackService callbackService;

    public void callback(String s) {
        callbackService.addListener(s, msg -> log.debug("callback " + msg));
    }
}
