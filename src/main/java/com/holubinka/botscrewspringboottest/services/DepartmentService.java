package com.holubinka.botscrewspringboottest.services;

import com.holubinka.botscrewspringboottest.model.Departs;

import java.util.List;

public interface DepartmentService {

    List<Departs> findAll();

    Departs findByHeadOfDepart (String headOfDepart);
}
