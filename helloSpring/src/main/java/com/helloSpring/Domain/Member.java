package com.helloSpring.Domain;


import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
public class Member {
    private Long id;
    private String name;

    @Builder
    Member(Long id, String name){
        this.id = id;
        this.name = name;
    }
}
