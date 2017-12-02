package com.javalei.control;


import com.javalei.pojo.Detailed;
import com.javalei.service.NoteTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;


@Controller
public class NoteTypeControl {

    @Autowired
    private NoteTypeService noteTypeService;

     @RequestMapping("all")
     @ResponseBody
    public List<Detailed> selectAllDetailed(){



         return noteTypeService.getDetailedList();

     }

    public static void main(String[] args) {


        String s="<p style=\"font-family:'微软雅黑','Microsoft YaHei';font-size:12px;\"></p>";
        System.out.println(  s.replaceAll("'","\\\\'"));
    }

}
