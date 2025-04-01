package com.example.demo.dtos;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class NameSubClassesDto {
    private String name;
    private List<SubClassDto> subClasses;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<SubClassDto> getSubClasses() {
        return subClasses;
    }

    public void setSubClasses(List<SubClassDto> subClasses) {
        this.subClasses = subClasses;
    }
}
