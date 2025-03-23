package com.example.demo.Service.ServiceImpl;

import com.example.demo.Entity.NameColor;
import com.example.demo.Repository.NameColorRepository;
import com.example.demo.Service.NameColorService;
import com.example.demo.dtos.NameSubClassesDto;
import com.example.demo.dtos.SubClassDto;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ServiceImpl implements NameColorService {

    private NameColorRepository nameColorRepository;

    public ServiceImpl(NameColorRepository nameColorRepository) {
        this.nameColorRepository = nameColorRepository;
    }

    @Override
    public List<NameSubClassesDto> getSubClasses() {
        List<NameSubClassesDto> nameSubClassesDtosList = new ArrayList<>();
        List<NameColor> nameColors = nameColorRepository.findAll();
        for(NameColor nameColor : nameColors){
            NameSubClassesDto nameSubClassesDto = new NameSubClassesDto();
            nameSubClassesDto.setName(nameColor.getName());
            Long id = nameColor.getId();
            List<SubClassDto> nameList = new ArrayList<>();
            List<NameColor> nameColors1 = nameColorRepository.findAllByParentId(id);
            for(NameColor nameColor1 : nameColors1){
                SubClassDto subClassDto = new SubClassDto(nameColor1.getName());


                nameList.add(subClassDto);
            }
            nameSubClassesDto.setSubClasses(nameList);
            nameSubClassesDtosList.add(nameSubClassesDto);


        }
        return nameSubClassesDtosList;


    }
}
