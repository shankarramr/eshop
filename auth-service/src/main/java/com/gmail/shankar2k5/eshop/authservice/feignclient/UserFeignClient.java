package com.gmail.shankar2k5.eshop.authservice.feignclient;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;

@FeignClient(name = "user", configuration = ServiceSourceRequestInterceptor.class)
public interface UserFeignClient {

    @PostMapping("/user/get-user-by-username/{username}")
    UserDTO getUserByUsername(@RequestHeader("source") String source,
            @RequestHeader("accepted-language") String acceptedLanguage, @PathVariable("username") String username);

}
