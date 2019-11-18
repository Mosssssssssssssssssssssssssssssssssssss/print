package com.nnxy.print116.controller;

import com.nnxy.print116.entity.Print;
import com.nnxy.print116.service.PrintService;
import com.nnxy.print116.utils.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Controller
public class PrintController {
    @Autowired
    PrintService printService;
    @RequestMapping("/print")
    public @ResponseBody Message print(Print print,MultipartFile file){
        System.out.println(file);
        print.setGmtCreate(System.currentTimeMillis());
        print.setGmtModify(System.currentTimeMillis());
        System.out.println(print);
        String originalFilename = file.getOriginalFilename();
        String[] split = originalFilename.split("\\.") ;
        String cut = UUID.randomUUID().toString()+"."+split[split.length-1];
        String path = "D:/printFile/"+cut;
        print.setPath(cut);
        Boolean b = printService.insert(print);
        System.out.println(path);
        try {
            if (true==b) {
                file.transferTo(new File(path));
                return new Message("success", "预约成功!");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new Message("error","预约失败!","");
    }
    @RequestMapping("/uploadFile")
    public @ResponseBody Message uploadFile(MultipartFile file){

        return null;
    }
    @RequestMapping("/printQueue")
    public @ResponseBody List<Print> printQueue(){
        List<Print> list = new ArrayList<>();
        list = printService.select();
        System.out.println(list);
        return list;
    }
}
