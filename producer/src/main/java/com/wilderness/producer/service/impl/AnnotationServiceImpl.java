package com.wilderness.producer.service.impl;

import com.wilderness.producer.service.AnnotationService;
import org.springframework.stereotype.Service;

/**
 * @author an_qiang
 */
@Service
public class AnnotationServiceImpl implements AnnotationService {

    @Override
    public String sayHello(String name) {
        return "annotation: hello, " + name;
    }
}
