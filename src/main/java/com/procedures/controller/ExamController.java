package com.procedures.controller;

import com.procedures.pojo.Examinfo;
import com.procedures.service.ExaminfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;


@RestController
@RequestMapping("/Exam")
public class ExamController {
    @Autowired
    private ExaminfoService examinfoService;

    //根据题目类别id 随机选取5道题进行出题
    @PostMapping("/getExaminfoByTypeId")
    public List<Examinfo> getExaminfoByTypeId(@RequestBody Integer typeId) {
        List<Examinfo> list;
        list = examinfoService.selectList(typeId);
        if (list.size() <= 5) {
            //如果题库出题小于等于5题时则直接返回
            return list;
        } else {
            ArrayList<Integer> li = new ArrayList<>();
            do {
                int result = getRandomNum(list.size());
                if (!li.contains(result)) {
                    li.add(result);
                }
            } while (li.size() < 5);
            List<Examinfo> list_new = new ArrayList<>();
            for (int i = 0; i < li.size(); i++) {
                list_new.add(list.get(li.get(i)));
            }
            System.out.println(list_new.toString());
            return list_new;
        }

    }

    public static int getRandomNum(int count) {
        Random random = new Random();
        return random.nextInt(count);
    }
}
