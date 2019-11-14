package com.nnxy.print116.service;

import com.nnxy.print116.dao.PrintMapper;
import com.nnxy.print116.entity.Print;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PrintService {
    @Autowired
    PrintMapper printMapper;
    public Boolean insert(Print print) {
        Integer insert = printMapper.inset(print);
        if(1==insert){
            return true;
        }else {
            return false;
        }
    }
}
