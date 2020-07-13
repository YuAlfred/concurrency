package com.ty.concurrency;


import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author : alfredt
 * @version : 1.0.0
 * @date : Created in 2020/7/4 8:42 下午
 * @description : 测试
 * @modified By  :
 */
@Controller
@Slf4j
public class TestController {

    @RequestMapping("/test")
    @ResponseBody
    public String test() {
        return "test";
    }

}
