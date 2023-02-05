package com.example.Book.Book;

import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.List;

@Repository

public class BookDao {
    EntityManager entityManager;

    List<Book> findBooksByAuthorNameAndTitle(String authorName, String title){
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Book> criteriaQuery = criteriaBuilder.createQuery(Book.class);

        Root<Book> book = criteriaQuery.from(Book.class);
        Predicate authorNamePredicate = criteriaBuilder.equal(book.get("author"), authorName);
        Predicate titlePredicate = criteriaBuilder.like(book.get("title"), "%" + title + "%");
        criteriaQuery.where(authorNamePredicate, titlePredicate);

        TypedQuery<Book> query = entityManager.createQuery(criteriaQuery);

        return query.getResultList();


    }

}
