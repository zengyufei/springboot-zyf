package com.zyf.springboot.controller.test;


import com.zyf.springboot.entity.test.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;
import java.util.Map;

@RestController
@RequestMapping("test")
public class TestController {

    private Logger log = LoggerFactory.getLogger(getClass());

    @PostMapping("test")
    public Test test(HttpServletRequest request, Test test) {
        log.info("开始调用 testController");
        Map<String, String[]> parameterMap = request.getParameterMap();
        for (Map.Entry<String, String[]> stringEntry : parameterMap.entrySet()) {
            System.out.println(stringEntry.getKey() + " = " + Arrays.toString(stringEntry.getValue()));
        }
        log.info("结束调用 testController");
        return test;
    }

}
