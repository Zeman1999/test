package com.atguigu.boot.controller;

import com.atguigu.boot.bean.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class PersonController {

    @Autowired
    Person person;

    @GetMapping("/goto")
    public String gotoPage(HttpServletRequest request) {

        request.setAttribute("msg","成功了..");
        request.setAttribute("code",200);
        return "forward:/success";
    }

    @GetMapping("/car/{id}/owner/{username}")
    public Map<String,Object> getCar(@PathVariable("id") Integer id,
                                     @PathVariable("username")String name,
                                     @PathVariable Map<String,String> pv,
                                     @RequestHeader("User-Agent")String userAgent,
                                     @RequestHeader Map<String,String> header,
                                     @RequestParam("age") Integer age,
                                     @RequestParam("inters") List<String> inters,
                                     @RequestParam Map<String,String> params,
                                     @CookieValue("_ga") String _ga,
                                     @CookieValue("_ga") Cookie cookie) {

        Map<String,Object> map = new HashMap<>();
        map.put("age",age);
        map.put("inters",inters);
        map.put("param",params);
        return map;

    }

    public Map success(@RequestAttribute("msg") String msg,
                       @RequestAttribute("code") String code,
                       HttpServletRequest request) {
        Map<String,String> map = new HashMap<>();
        map.put("msg",msg);
        map.put("code",code);
        return map;
    }
}
