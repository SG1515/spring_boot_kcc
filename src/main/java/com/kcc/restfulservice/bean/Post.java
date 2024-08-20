package com.kcc.restfulservice.bean;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String title;

    private String content;

    @ManyToOne(fetch = FetchType.LAZY)
    @JsonIgnore
    private User user;

    public Post(Integer id, String title, String content) {
        this.id = id;
        this.title = title;
        this.content = content;
    }
}
