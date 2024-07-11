package com.example.repository;

import ch.qos.logback.core.model.conditional.ElseModel;
import com.example.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

    //Display all employees with email address ""
    List<Employee> findAllByEmail(String email);

    //Display all employees with first name "" and last name "",
    //also show all employees with an email address ""
    List<Employee> findByFirstNameAndLastNameOrEmail(String firstname, String lastname, String email);

    //Display all employees where firstName is not ""
    List<Employee> findAllByFirstNameIsNot(String firstname);

    //Display all employees where lastname starts with " "
    List<Employee> findAllByLastNameStartingWith(String lastname);

    //Display all employees with salaries higher than ""
    List<Employee> findAllBySalaryGreaterThan(Integer amount);

    //Display all employees with salaries less than ""
    List<Employee> findAllBySalaryLessThan(Integer amount);

    //Display all employees that have been hired between "" and ""
    List<Employee> findByHireDateBetween(LocalDate startDate, LocalDate endDate);

    //Display all employees where salaries greater and equal to "" in order
    List<Employee> findBySalaryGreaterThanEqualOrderBySalary(Integer salary);

    //Display top unique 3 employees that are making less than ""
    List<Employee> findDistinctTop3BySalaryLessThan(Integer salary);

    //Display all employees that do not have email address

    List<Employee> findAllByEmailIsNull();


    //----------------JPQL------------------

    // e is an object in here
    @Query("SELECT e FROM Employee e WHERE e.email='amcnee1@google.es'")
    Employee retrieveEmployeeDetail();

    @Query("SELECT e.salary FROM Employee e WHERE e.email='amcnee1@google.es' ")
    Integer retrieveEmployeeSalary();

    //Not equal
    @Query("SELECT e FROM Employee e WHERE e.salary <> ?1")
    List<Employee> retrieveEmployeeSalaryNotEqual(int salary);

    //like / contains / startswith/ endswith
    @Query("SELECT e FROM Employee e WHERE e.firstName LIKE ?1")
    List<Employee> retrieveEmployeeFirstNameLike(String pattern);

    //Less than
    @Query("SELECT e FROM Employee e WHERE e.salary < ?1")
    List<Employee> retrieveEmployeeSalaryLessThan(int salary);

    //Greater than
    @Query("SELECT e FROM Employee e WHERE e.salary > ?1")
    List<Employee> retrieveEmployeeSalaryGreaterThan(int salary);

//    @Query("SELECT e.firstName FROM Employee e WHERE e.salary > ?1")
//    List<String> retrieveEmployeeSalaryGreaterThan(int salary);


    //Between
    @Query("SELECT e FROM Employee e WHERE e.salary BETWEEN ?1 AND ?2")
    List<Employee> retrieveEmployeeSalaryBetween(int salary1, int salary2);

    //before
    @Query("SELECT e FROM Employee e WHERE e.hireDate > ?1")
    List<Employee> retrieveEmployeeHireDateBefore(LocalDate date);

    //Null
    @Query("SELECT e FROM Employee e WHERE e.email IS NULL")
    List<Employee> retrieveEmployeeEmailIsNull();

    //Not Null
    @Query("SELECT e FROM Employee e WHERE e.email IS NOT NULL")
    List<Employee> retrieveEmployeeEmailIsNotNull();

    //Sorting is Asc Order
    @Query("SELECT e FROM Employee e ORDER BY e.salary ASC")
    List<Employee> retrieveEmployeeSalaryOrderAsc();

    //Sorting is Desc Order
    @Query("SELECT e FROM Employee e ORDER BY e.salary DESC")
    List<Employee> retrieveEmployeeSalaryOrderDesc();


    //----------------NATIVE QUERY------------------

    @Query(value = "SELECT * FROM employees WHERE salary = ?1", nativeQuery = true)
    List<Employee> retrieveEmployeeDetailBySalary(int salary);

    //Named Parameter
    @Query("SELECT e from Employee e WHERE e.salary = :salary")
    List<Employee> retrieveEmployeeSalary(@Param("salary") int salary);








}
