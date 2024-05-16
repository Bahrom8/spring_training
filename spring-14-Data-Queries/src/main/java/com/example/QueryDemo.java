package com.example;

import com.example.repository.DepartmentRepository;
import com.example.repository.EmployeeRepository;
import com.example.repository.RegionRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class QueryDemo implements CommandLineRunner {

    private final RegionRepository regionRepository;
    private final DepartmentRepository departmentRepository;
    private final EmployeeRepository employeeRepository;

    public QueryDemo(RegionRepository regionRepository, DepartmentRepository departmentRepository, EmployeeRepository employeeRepository) {
        this.regionRepository = regionRepository;
        this.departmentRepository = departmentRepository;
        this.employeeRepository = employeeRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        System.out.println("-------------REGIONS-----------------");

        System.out.println("find By Country: " + regionRepository.findByCountry("Canada"));
        System.out.println("find By Country Contains: " + regionRepository.findByCountryContains("United"));
        System.out.println("find By Country Contains Order By Region Desc: " + regionRepository.findByCountryContainsOrderByRegionDesc("United"));
        System.out.println("find Top By Country: " + regionRepository.findTopByCountry("United States"));
        System.out.println("find Top By 2 Country: " + regionRepository.findTop2ByCountry("United States"));
        System.out.println("find Top By Country Contains Order By Region: " + regionRepository.findTopByCountryContainsOrderByRegion("United States"));


        System.out.println("-------------DEPARTMENTS-----------------");

        System.out.println("find all by departments: " + departmentRepository.findAllByDepartment("Furniture"));
        System.out.println("find all by division: " + departmentRepository.findByDivision("Health"));
        System.out.println("findByDivisionEndingWith: " + departmentRepository.findByDivisionEndingWith("ics"));
        System.out.println("findDistinctTop3ByDivisionContains: " + departmentRepository.findDistinctTop3ByDivisionContains("Hea"));


        System.out.println("-------------EMPLOYEES-----------------");


        System.out.println("-------------JPQL-----------------");
        System.out.println(employeeRepository.retrieveEmployeeDetail());
        System.out.println(employeeRepository.retrieveEmployeeSalary());










    }
}
