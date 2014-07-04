package com.richardxu.service;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
public class TestService {
	
	@Cacheable(key = "#name", value="messageCache", condition="'Xufeng'.equals(#name)")
    public String getMessage(String name) {
        System.out.println("Executing TestService" + 
                        ".getHelloMessage(\"" + name + "\")");
 
        return "Hello " + name + "!";
    }
}
