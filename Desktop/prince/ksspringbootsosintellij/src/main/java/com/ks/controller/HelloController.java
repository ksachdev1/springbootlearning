package com.ks.controller;

import com.ks.service.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by kasachde on 7/20/2016.
 */
@RestController
public class HelloController {
    @Autowired
    HelloService helloService;
    @RequestMapping(value="/hello", method = RequestMethod.GET)
    public ResponseEntity<?> getHello() throws Exception {
        return new ResponseEntity<HelloService>(helloService, HttpStatus.MULTI_STATUS.OK);
    }
    @RequestMapping(value="/secure/hello", method = RequestMethod.GET)
    public ResponseEntity<?> getSecureHello() throws Exception {
        helloService.setServiceStr("From secure hello");
        return new ResponseEntity<HelloService>(helloService, HttpStatus.MULTI_STATUS.OK);
    }
    @RequestMapping(value="/oauth2/hello", method = RequestMethod.GET)
    public ResponseEntity<?> getOauth2Hello() throws Exception {
        helloService.setServiceStr("From Oauth2 hello");
        return new ResponseEntity<HelloService>(helloService, HttpStatus.MULTI_STATUS.OK);
    }
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    @RequestMapping(value="/admin/hello", method = RequestMethod.GET)
    public ResponseEntity<?> getAdminHello() throws Exception {
        helloService.setServiceStr("From admin hello");
        return new ResponseEntity<HelloService>(helloService, HttpStatus.MULTI_STATUS.OK);
    }
    @RequestMapping(value="/hello", method = RequestMethod.POST)
    public ResponseEntity<?> setHello(@RequestBody HelloService service) throws Exception {
        service.setServiceStr("I am returning:"+service.getServiceStr());
        return new ResponseEntity<HelloService>(service, HttpStatus.MULTI_STATUS.CREATED);
    }


}
