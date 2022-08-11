package com.codnamebear.spring5webapp.repositories;

import com.codnamebear.spring5webapp.model.Author;
import org.springframework.data.repository.CrudRepository;

public interface AuthorRepository extends CrudRepository<Author, Long> {



}
