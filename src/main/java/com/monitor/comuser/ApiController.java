package com.monitor.comuser;

import com.alibaba.dubbo.config.annotation.Reference;


import com.dubbo.common.api.MonitorServiceInterface;
import com.dubbo.common.entity.HardwareProperties;
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
    @Reference(version = "192.168.1.231", check = false, interfaceClass = MonitorServiceInterface.class)
    public MonitorServiceInterface monitorServiceInterface;

    @Reference(version = "192.168.1.232", check = false, interfaceClass = MonitorServiceInterface.class)
    public MonitorServiceInterface monitorServiceInterface02;

    @Reference(version = "192.168.1.235", check = false, interfaceClass = MonitorServiceInterface.class)
    public MonitorServiceInterface monitorServiceInterface03;

    @RequestMapping(value = "/status")
    public ServerProperties getStatus() {
        return monitorServiceInterface.getPCState();
    }

    @RequestMapping(value = "/hand")
    public HardwareProperties getHand() {
        return monitorServiceInterface.getHardwarePro();
    }

    @RequestMapping(value = "/status02")
    public ServerProperties getStatus02() {
        return monitorServiceInterface02.getPCState();
    }

    @RequestMapping(value = "/status03")
    public ServerProperties getStatus03() {
        return monitorServiceInterface03.getPCState();
    }

}
