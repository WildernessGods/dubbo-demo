package com.wilderness.consumer.action;

import com.wilderness.api.AsyncService;
import lombok.extern.slf4j.Slf4j;
import org.apache.dubbo.config.annotation.DubboReference;
import org.apache.dubbo.config.annotation.Method;
import org.apache.dubbo.rpc.RpcContext;
import org.springframework.stereotype.Component;

import java.util.concurrent.CompletableFuture;

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
//        asyncService.sayHello(s).whenComplete((s1, throwable) -> {
//            if (throwable != null) {
//                throwable.printStackTrace();
//            } else {
//                log.debug("Response: " + s1);
//            }
//        });

        asyncService.sayHello(s);
        CompletableFuture<String> helloFuture = RpcContext.getContext().getCompletableFuture();
        helloFuture.whenComplete((retValue, exception) -> {
            if (exception == null) {
                log.debug("Response2: " + retValue);
            } else {
                exception.printStackTrace();
            }
        });
    }
}
