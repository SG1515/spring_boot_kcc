package com.kcc.restfulservice.bean;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

//@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Post implements Serializable {

//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String title;

    private String content;

//    @ManyToOne(fetch = FetchType.LAZY)
//    @JsonIgnore
    private Integer user_id;

}
