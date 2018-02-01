package org.andy.spring.spring5webapp.repositories;

import org.andy.spring.spring5webapp.model.Book;
import org.springframework.data.repository.CrudRepository;

public interface BookRepository extends CrudRepository<Book, Long> {
}
