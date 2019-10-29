package com.holubinka.botscrewspringboottest.services;

import com.holubinka.botscrewspringboottest.dao.DepartmentDao;
import com.holubinka.botscrewspringboottest.model.Departs;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmentServiceImpl implements DepartmentService {

    @Autowired
    DepartmentDao departmentDao;

    @Override
    public List<Departs> findAll() {
        return departmentDao.findAll();
    }

    @Override
    public Departs findByHeadOfDepart(String headOfDepart) {
        return departmentDao.findByHeadOfDepart(headOfDepart);
    }
}
