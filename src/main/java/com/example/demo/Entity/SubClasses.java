package com.example.demo.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;

import java.util.List;

@Entity
public class SubClasses extends BaseEntity {
    @OneToMany
    @JoinColumn(name = "name_color_id")
    private List<NameColor> nameColors;

    public List<NameColor> getNameColors() {
        return nameColors;
    }

    public void setNameColors(List<NameColor> nameColors) {
        this.nameColors = nameColors;
    }
}
