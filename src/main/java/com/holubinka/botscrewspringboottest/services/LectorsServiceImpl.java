package com.holubinka.botscrewspringboottest.services;

import com.holubinka.botscrewspringboottest.dao.LectorsDao;
import com.holubinka.botscrewspringboottest.model.Lector;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LectorsServiceImpl implements LectorsService {
    @Autowired
    private LectorsDao lectorsDao;

    @Override
    public Long countByDegree_Degree_AndDeparts_DepartName(String degree, String departName) {
        return lectorsDao.countByDegree_Degree_AndDeparts_DepartName(degree, departName);
    }

    @Override
    public Long countByDeparts_DepartName(String departName) {
        return lectorsDao.countByDeparts_DepartName(departName);
    }

    @Override
    public List<Lector> findByNameContainingIgnoringCase(String name) {
        return lectorsDao.findByNameContainingIgnoringCase(name);
    }

    @Override
    public Double avgByDeparts_DepartName(String departName) {
        return lectorsDao.avgByDeparts_DepartName(departName);
    }
}
