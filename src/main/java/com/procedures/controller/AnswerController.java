package com.procedures.controller;

import com.procedures.pojo.Answerresult;
import com.procedures.pojo.Studentsanswer;
import com.procedures.service.AnswerResultService;
import com.procedures.service.StudentsAnswerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/answer")
public class AnswerController {

    @Autowired
    private AnswerResultService answerResultService;

    @Autowired
    private StudentsAnswerService studentsAnswerService;

    @PostMapping("/addExamResult")
    @Transactional()
    public Map<String, Object> addExamResult(@RequestParam Map<String, Object> params) {
        String[] examid = params.get("examid").toString().split(",");
        String[] a = params.get("a").toString().split(",");
        String[] b = params.get("b").toString().split(",");
        String[] c = params.get("c").toString().split(",");
        String[] d = params.get("d").toString().split(",");
        String[] correctanswer = params.get("correctanswer").toString().split(",");
        String examtypeid = params.get("examtypeid").toString();
        String studentid = params.get("studentid").toString();
        String examinfoname = params.get("examinfoname").toString();
        String[] studentanswer = params.get("studentanswer").toString().split(",");

        Double trueNum = getTrueNum(examid, studentanswer, correctanswer);
        Integer grade = (int) ((trueNum / examid.length) * 5);//计算成绩百分比

        Date createtime = new Date();

        //1.添加答题主表
        Studentsanswer ss = new Studentsanswer();
        ss.setExamtypeid(Integer.valueOf(examtypeid));
        ss.setStudentid(Integer.valueOf(studentid));
        ss.setGrade(grade);
        ss.setCreatetime(createtime);
        studentsAnswerService.insert(ss);
        System.out.println("新增后主表ID=" + ss.getId());
        //2.添加答题详细表
        Integer ssid = ss.getId();

        for (int i = 0; i < examid.length; i++) {
            Answerresult as = new Answerresult();
            as.setSsid(ssid);
            as.setStudentid(Integer.valueOf(studentid));
            as.setExamid(Integer.valueOf(examid[i]));
            as.setA(a[i]);
            as.setB(b[i]);
            as.setC(c[i]);
            as.setD(d[i]);
            as.setStudentanswer(studentanswer[i].replace("0", ""));
            as.setCorrectanswer(correctanswer[i]);
            as.setIstrue(studentanswer[i].equals(correctanswer[i]) == true ? "1" : "0");
            as.setCreatetime(createtime);
            answerResultService.insert(as);
        }
        Map<String, Object> map = new HashMap<>();
        map.put("ssid", ssid);
        map.put("studentid", studentid);
        map.put("examinfoname", examinfoname);
        map.put("grade", grade);
        map.put("createtime", createtime);
        return map;

    }

    public Double getTrueNum(String[] examid, String[] studentanswer, String[] correctanswer) {
        Double count = 0.0;
        for (int i = 0; i < examid.length; i++) {
            if (studentanswer[i].replace("0", "").equals(correctanswer[i])) {
                count++;
            }
        }
        return count;
    }
}
