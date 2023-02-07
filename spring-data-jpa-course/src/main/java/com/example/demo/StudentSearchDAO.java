package com.example.demo;

import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.List;

@Repository
public class StudentSearchDAO {
    private final EntityManager em;

    public StudentSearchDAO(EntityManager em) {
        this.em = em;
    }

    public List<Student> findAllBySimpleQuery(
            String firstName,
            String lastName,
            String email
    ){
        CriteriaBuilder criteriaBuilder = em.getCriteriaBuilder();
        CriteriaQuery<Student> criteriaQuery =  criteriaBuilder.createQuery(Student.class);

        //SELECT * FROM Student;
        Root<Student> root = criteriaQuery.from(Student.class);

        //where clause
        //WHERE firstname like '%ali%'
        Predicate firstNamePredicate = criteriaBuilder
                .like(root.get("firstName"), "%" + firstName + "%");
        Predicate lastNamePredicate = criteriaBuilder
                .like(root.get("lastName"), "%" + lastName + "%");
        Predicate emailPredicate = criteriaBuilder
                .like(root.get("email"), "%" + email + "%");
        Predicate orPredicate = criteriaBuilder.or(
                firstNamePredicate,
                lastNamePredicate,emailPredicate
        );
        //final query ==> select * from employee where firs
        criteriaQuery.where(
                criteriaBuilder.and(firstNameOrlastNamePredicate, emailPredicate)
        )
    }
}
