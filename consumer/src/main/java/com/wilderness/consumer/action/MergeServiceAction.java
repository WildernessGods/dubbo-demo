package com.wilderness.consumer.action;

import com.wilderness.api.MergeService;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author an_qiang
 */
@Component
public class MergeServiceAction {

    @Reference
    private MergeService mergeService;

    public List<String> mergeResult(String s) {
        return mergeService.mergeResult(s);
    }
}
