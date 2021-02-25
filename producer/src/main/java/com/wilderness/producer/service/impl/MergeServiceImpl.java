package com.wilderness.producer.service.impl;

import com.wilderness.api.MergeService;
import lombok.extern.slf4j.Slf4j;
import org.apache.dubbo.config.annotation.DubboService;

import java.util.ArrayList;
import java.util.List;

/**
 * @author an_qiang
 */
@DubboService
@Slf4j
public class MergeServiceImpl implements MergeService {

    @Override
    public List<String> mergeResult(String s) {
        log.debug("mergeResult " + s);
        return new ArrayList<String>() {{
            add("1");
            add("2");
            add("3");
            add(s);
        }};
    }
}
