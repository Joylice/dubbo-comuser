package com.monitor.comuser;

import com.alibaba.dubbo.config.annotation.Reference;


import com.dubbo.common.api.MonitorServiceInterface;
import com.dubbo.common.entity.ServerProperties;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: Joylice
 * @Date: 2020/4/1 11:10
 */
@RestController
@RequestMapping(value = "/pc")
public class ApiController {
    @Reference(check = false)
    public MonitorServiceInterface monitorServiceInterface;

    @RequestMapping(value = "/status")
    public ServerProperties getStatus() {
        return monitorServiceInterface.getPCState();
    }
}
