package com.warehouse.app.beans.platform;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/api/v1/platform")
public class PlatformController {

    @Autowired
    private PlatformService service;
    @Autowired
    private FactoryPlatform factory;

}
