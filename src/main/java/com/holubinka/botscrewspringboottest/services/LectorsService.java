package com.holubinka.botscrewspringboottest.services;

import com.holubinka.botscrewspringboottest.model.Departs;
import com.holubinka.botscrewspringboottest.model.Lector;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface LectorsService {

    Long countByDegree_Degree_AndDeparts_DepartName(String degree, String departName);

    Long countByDeparts_DepartName(String departName);

    List<Lector> findByNameContainingIgnoringCase(String name);

    Double avgByDeparts_DepartName(String departName);
}
