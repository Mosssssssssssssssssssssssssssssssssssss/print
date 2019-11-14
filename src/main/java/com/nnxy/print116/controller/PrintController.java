package com.nnxy.print116.controller;

import com.nnxy.print116.entity.Print;
import com.nnxy.print116.service.PrintService;
import com.nnxy.print116.utils.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class PrintController {
    @Autowired
    PrintService printService;
    @RequestMapping("/print")
    @ResponseBody
    public Message print(@RequestBody Print print){
        print.setGmtCreate(System.currentTimeMillis());
        print.setGmtModify(System.currentTimeMillis());
        System.out.println(print);
        Boolean b = printService.insert(print);
        if (true==b){
            return new Message("success","预约成功!","");
        }else {
            return new Message("error","预约失败!","");
        }
    }
}
