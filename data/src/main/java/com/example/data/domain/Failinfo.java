package com.example.data.domain;

// 作 接受 gradeinfo 统计 结果
public class Failinfo {
    private String subject; // 科目

    private Integer personnum; // 挂科人数

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public Integer getPersonnum() {
        return personnum;
    }

    public void setPersonnum(Integer personnum) {
        this.personnum = personnum;
    }

    @Override
    public String toString() {
        return "Failinfo{" +
                "subject='" + subject + '\'' +
                ", personnum=" + personnum +
                '}';
    }
}
