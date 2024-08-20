package com.kcc.restfulservice.bean;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Date;

@Data
@AllArgsConstructor
@JsonIgnoreProperties(value = {"password", "ssn"})
public class User {

    private Integer id;

    @Schema(title = "사용자 이름", description = "사용자 이름을 입력하세요.")
    @Size(min = 2, message = "name은 2글자 이상 입력해주세요.")
    private String name;

    @Schema(title = "사용자 등록일", description = "사용자 등록일을 입력하세요.")
    @Past(message = "등록일은 미래 날짜를 입력하실 수 없습니다.")
    private Date joinDate;

//    @JsonIgnore
    private String password;
//    @JsonIgnore
    private String ssn;
}
