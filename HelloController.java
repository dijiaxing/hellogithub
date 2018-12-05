package com.neusoft.controller;


import com.neusoft.domain.Dept;
import com.neusoft.domain.UserInfo;
import com.neusoft.mapper.DeptMapper;
import com.neusoft.service.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletResponse;
import javax.xml.registry.infomodel.PersonName;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2018/11/28.
 */
@Controller
public class HelloController {

    @Value("${user_name}")
    private String uname;


    @Value("${chengmi_crawl_timer_enable}")
    private Boolean bbb;

    @Autowired
    HelloService helloService;

    @RequestMapping("/hello")
    public String hello()
    {
        System.out.println(uname + bbb);
        Dept dept = helloService.getDeptByID(20);
        System.out.println(dept);
        return "hello";
    }
    @RequestMapping("/register")
    @ResponseBody
    public Dept register(UserInfo userInfo) throws IOException {
        System.out.println(userInfo);
        Dept dept = new Dept();
        dept.setDeptno(33);
        dept.setDname("销售部");
        dept.setLoc("沈阳");
        return dept;
    }

    @RequestMapping("/check/{username}")
    @ResponseBody
    public List<Dept> check(HttpServletResponse response,@PathVariable String username) throws IOException {
        response.setContentType("text/html;charset=utf8");
        List<Dept> deptList = new ArrayList<Dept>();

        Dept dept = new Dept();
        dept.setDeptno(33);
        dept.setDname("销售部");
        dept.setLoc("沈阳");

        deptList.add(dept);

        Dept dept2 = new Dept();
        dept2.setDeptno(45);
        dept2.setDname("研发部");
        dept2.setLoc("大连");

        deptList.add(dept2);

        return deptList;

//        String strJson = JSON.toJSONString(deptList);
//        System.out.println(strJson);
//        if(username.length() < 6)
//        {
//            response.getWriter().println(strJson);
//        }
//        else
//        {
//            response.getWriter().println(strJson);
//        }

    }
    @RequestMapping("/get_tab_content/{id}")
    @ResponseBody
    public String getTabContent(@PathVariable Integer id)
    {
        Map<Integer,String> integerStringMap = new HashMap<>();
        integerStringMap.put(0,"zhangsan");
        integerStringMap.put(1,"lisi");
        integerStringMap.put(2,"wangwu");

        String content = integerStringMap.get(id);
        return content;
    }
}
