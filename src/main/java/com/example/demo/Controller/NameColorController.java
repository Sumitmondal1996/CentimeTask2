package com.example.demo.Controller;

import com.example.demo.Service.NameColorService;
import com.example.demo.annotation.LogMethodParam;
import com.example.demo.dtos.NameSubClassesDto;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController

public class NameColorController {

    private final NameColorService nameColorService;

    public NameColorController(NameColorService nameColorService) {
        this.nameColorService = nameColorService;
    }
    @LogMethodParam(logArguments = true, logExecutionTime = true)
    @RequestMapping("/getSubClasses")
    public List<NameSubClassesDto> getSubClasses()
    {
        return nameColorService.getSubClasses();
    }


}
