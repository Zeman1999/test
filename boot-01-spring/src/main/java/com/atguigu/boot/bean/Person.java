package com.atguigu.boot.bean;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;
import sun.misc.Contended;

import java.util.List;


@ConfigurationProperties(prefix = "person")
@Component
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Person {
    private String userName;
    private String score;
    private String[] hobby;
    private List<Integer> price;
    private Cat cat;

}
