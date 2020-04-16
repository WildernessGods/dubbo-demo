package com.wilderness.producer.service.impl;

import com.wilderness.api.MergeService;
import org.apache.dubbo.config.annotation.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author an_qiang
 */
@Service
public class MergeServiceImpl implements MergeService {

    @Override
    public List<String> mergeResult(String s) {
        return new ArrayList<String>() {{
            add("1");
            add("2");
            add("3");
            add(s);
        }};
    }
}
