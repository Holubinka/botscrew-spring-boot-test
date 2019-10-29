package com.holubinka.botscrewspringboottest.controller;

import com.holubinka.botscrewspringboottest.model.Departs;
import com.holubinka.botscrewspringboottest.model.Lector;
import com.holubinka.botscrewspringboottest.services.DepartmentService;
import com.holubinka.botscrewspringboottest.services.LectorsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.constraints.Null;
import java.util.List;

@RestController
public class LectorsController {

    @Autowired
    private LectorsService lectorsService;

    @Autowired
    private DepartmentService departmentService;

    @RequestMapping(value = "/department", method = RequestMethod.GET)
    @ResponseBody
    public ModelAndView getAll(ModelAndView vm) {
        vm.setViewName("department");
        vm.addObject("departments" ,departmentService.findAll());
        return vm;
    }

    @RequestMapping(value = "/departmentInfo", method = RequestMethod.GET)
    public ModelAndView getHeadOfDepartment(@RequestParam("headOfDepart") String headOfDepart, ModelAndView vm) {
        Departs departName = departmentService.findByHeadOfDepart(headOfDepart);
        vm.setViewName("departmentInfo");
        vm.addObject("department", departName);
        vm.addObject("assistCount", lectorsService.countByDegree_Degree_AndDeparts_DepartName("assistant", departName.getDepartName()));
        vm.addObject("associateProfCount", lectorsService.countByDegree_Degree_AndDeparts_DepartName("associate professor", departName.getDepartName()));
        vm.addObject("professorsCount", lectorsService.countByDegree_Degree_AndDeparts_DepartName("professor", departName.getDepartName()));
        vm.addObject("avgSalary", lectorsService.avgByDeparts_DepartName(departName.getDepartName()));
        vm.addObject("departCount", lectorsService.countByDeparts_DepartName(departName.getDepartName()));
        return vm;
    }

    @RequestMapping(value = "/department/search")
    public ModelAndView search(@RequestParam("name") String name, ModelAndView vm) {
        vm.setViewName("department");
        vm.addObject("departments", departmentService.findAll());
        vm.addObject("search", lectorsService.findByNameContainingIgnoringCase(name));
        return vm;
    }
}
