package com.procedures.controller;

import com.alibaba.fastjson.JSON;
import com.procedures.pojo.Consumer;
import com.procedures.pojo.Examinfo;
import com.procedures.service.ExaminfoService;
import com.procedures.service.ExamtypeService;
import com.procedures.service.WeChatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;


@RestController
@RequestMapping("/Exam")
public class ExamController {
    @Autowired
    private ExaminfoService examinfoService;

    @Autowired
    private ExamtypeService examtypeService;

    @Autowired
    private WeChatService weChatService;

    //根据题目类别id 随机选取5道题进行出题
    @GetMapping("/getExaminfoByTypeId")
    public Object getExaminfoByTypeId(@RequestParam("typeId") Integer typeId) {
        List<Examinfo> list;
        list = examinfoService.selectList(typeId);
        if (list.size() <= 5) {
            //如果题库出题小于等于5题时则直接返回
            return JSON.toJSONString(list);
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
            return JSON.toJSONString(list_new);
        }

    }

    public static int getRandomNum(int count) {
        Random random = new Random();
        return random.nextInt(count);
    }


    @GetMapping("/getExaminfo")
    public Object getExaminfo() {
        List<Examinfo> list = examinfoService.selectExam();
        ArrayList<Integer> li = new ArrayList<>();
        do {
            int result = getRandomNum(list.size());
            if (!li.contains(result)) {
                li.add(result);
            }
        } while (li.size() < 30);
        List<Examinfo> list_new = new ArrayList<>();
        for (int i = 0; i < li.size(); i++) {
            list_new.add(list.get(li.get(i)));
        }
        System.out.println(list_new.toString());
        return JSON.toJSONString(list_new);
    }
    /**
     * 获取所有题目类型
     *
     * @return
     */
    @GetMapping("/getExamtype")
    public Object getExamtype() {
        return JSON.toJSONString(examtypeService.getExamtype());
    }

    /**
     * 给用户增加积分
     *
     * @return
     */
    @GetMapping("/addIntegral")
    public Object addIntegral(@RequestParam("examNum") Integer examNum) {
        Consumer consumer = weChatService.getConsumerInfo();
        //答对题的个数的10倍生成积分加上原来的积分
        Integer examGrade = examNum * 10 + consumer.getGrade();
        consumer.setGrade(examGrade);
        weChatService.updateConsumerInfo(consumer);
        return JSON.toJSONString("success");
    }
}
