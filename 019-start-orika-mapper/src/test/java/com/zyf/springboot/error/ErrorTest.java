package com.zyf.springboot.error;

import com.zyf.springboot.Demo19ApplicationTests;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ErrorTest extends Demo19ApplicationTests {

    private static final Logger log = LoggerFactory.getLogger(ErrorTest.class);

    @Test
    public void get() {
        log.error("错误");
    }

}