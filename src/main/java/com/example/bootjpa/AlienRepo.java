package com.example.bootjpa;

import com.example.bootjpa.Alien;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

import java.util.List;

public interface AlienRepo extends JpaRepository<Alien,Integer> {
List<Alien> findByTech(String tech);
@Query("from Alien where tech=?1 order by aname")
List<Alien> findByTechSorted(String tech);

}
//CurdRepository provides us all the basic features
// for writing your own queries @Query