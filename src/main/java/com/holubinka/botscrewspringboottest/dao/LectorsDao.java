package com.holubinka.botscrewspringboottest.dao;

import com.holubinka.botscrewspringboottest.model.Lector;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface LectorsDao extends JpaRepository<Lector, Long> {

    Long countByDegree_Degree_AndDeparts_DepartName(String degree, String departName);

    Long countByDeparts_DepartName(String departName);

    List<Lector> findByNameContainingIgnoringCase(String name);

    @Query("SELECT AVG(l.salary) from Lector l inner join l.departs d where d.departName = :departName")
    Double avgByDeparts_DepartName(@Param("departName")String departName);

}
