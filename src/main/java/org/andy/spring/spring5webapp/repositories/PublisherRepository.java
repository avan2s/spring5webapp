package org.andy.spring.spring5webapp.repositories;

import org.andy.spring.spring5webapp.model.Publisher;
import org.springframework.data.repository.CrudRepository;

public interface PublisherRepository extends CrudRepository<Publisher, Long> {
}
