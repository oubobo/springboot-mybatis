package com.oyb.springbootmybatis.vo;

import java.io.Serializable;

public class MybatisInfoVO implements Serializable{
    private String age;
    private String cupSize;
    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getCupSize() {
        return cupSize;
    }

    public void setCupSize(String cupSize) {
        this.cupSize = cupSize;
    }
}
