package com.wilderness.consumer.action;

import com.wilderness.api.AsyncService;
import lombok.extern.slf4j.Slf4j;
import org.apache.dubbo.config.annotation.DubboReference;
import org.apache.dubbo.config.annotation.Method;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

/**
 * @author an_qiang
 */
@Component
@Slf4j
public class AsyncServiceAction {

    @DubboReference(interfaceClass = AsyncService.class, timeout = 1000,
            methods = {@Method(name = "sayHello", timeout = 5000, retries = 1)})
    private AsyncService asyncService;

    public void sayHello(String s) {
        try {
            log.debug("sayHello" + asyncService.sayHello(s).get(5, TimeUnit.SECONDS));
        } catch (Exception e) {
            log.error(e.getLocalizedMessage());
        }
    }
}
