package com.kcc.restfulservice.bean;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Date;

@Data
@AllArgsConstructor
public class User {
    private Integer id;
    @Size(min = 2, message = "name은 2글자 이상 입력해주세요.")
    private String name;
    @Past(message = "등록일은 미래 날짜를 입력하실 수 없습니다.")
    private Date joinDate;

    @JsonIgnore
    private String password;
    @JsonIgnore
    private String ssn;
}
