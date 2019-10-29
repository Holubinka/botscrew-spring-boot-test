package com.holubinka.botscrewspringboottest.dao;


import com.holubinka.botscrewspringboottest.model.Departs;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartmentDao extends JpaRepository<Departs, Long> {

    Departs findByHeadOfDepart (String headOfDepart);
}
