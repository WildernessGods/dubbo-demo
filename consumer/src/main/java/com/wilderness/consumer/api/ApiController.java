package com.wilderness.consumer.api;

import com.wilderness.consumer.action.AsyncServiceAction;
import com.wilderness.consumer.action.CallbackServiceAction;
import com.wilderness.consumer.action.MergeServiceAction;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author an_qiang
 */
@RestController
@Slf4j
public class ApiController {

    @Resource
    private MergeServiceAction mergeServiceAction;

    @Resource
    private AsyncServiceAction asyncServiceAction;

    @Resource
    private CallbackServiceAction callbackServiceAction;

    @GetMapping("/api")
    public void api(String s) {

//        log.debug(String.valueOf(mergeServiceAction.mergeResult(s)));
//        asyncServiceAction.sayHello(s);
        callbackServiceAction.callback(s);
    }
}
