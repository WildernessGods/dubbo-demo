package com.wilderness.consumer.action;

import com.wilderness.api.MergeService;
import org.apache.dubbo.config.annotation.DubboReference;
import org.apache.dubbo.config.annotation.Method;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author an_qiang
 */
@Component
public class MergeServiceAction {

    @DubboReference(interfaceClass = MergeService.class, timeout = 1000,
            methods = {@Method(name = "mergeResult", timeout = 3000, retries = 1)})
    private MergeService mergeService;

    public List<String> mergeResult(String s) {
        return mergeService.mergeResult(s);
    }
}
