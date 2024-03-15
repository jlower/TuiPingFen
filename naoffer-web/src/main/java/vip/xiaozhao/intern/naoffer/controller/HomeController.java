package vip.xiaozhao.intern.naoffer.controller;

import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/")
public class HomeController {

    @RequestMapping("")
    public String init(HttpServletRequest request) {
        return "hello";
    }
}
