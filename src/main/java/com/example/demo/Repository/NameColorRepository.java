package com.example.demo.Repository;

import com.example.demo.Entity.NameColor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NameColorRepository extends JpaRepository<NameColor, Long> {
    public List<NameColor> findAllByParentId(Long parentId);
    public List<NameColor> findAll();

}
