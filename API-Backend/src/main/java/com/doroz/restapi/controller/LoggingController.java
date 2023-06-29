package com.doroz.restapi.controller;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RestController;

import java.util.Objects;

@RestController
public class LoggingController {

    private static final Logger logger = LoggerFactory.getLogger(LoggingController.class);


    public void logSomeInfo(String info, String logType) {
        if (Objects.equals(logType, "info")) {
            logger.info(info);
        } else if (Objects.equals(logType, "warn")) {
            logger.warn(info);
        }
    }
}
