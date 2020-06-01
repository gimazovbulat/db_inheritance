package ru.itis.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class UserDto {
    private Long id;
    private String name;
    private Integer age;

    public UserDto(String name, Integer age) {
        this.name = name;
        this.age = age;
    }
}
