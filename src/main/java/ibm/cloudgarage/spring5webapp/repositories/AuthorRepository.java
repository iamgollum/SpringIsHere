package ibm.cloudgarage.spring5webapp.repositories;

import ibm.cloudgarage.spring5webapp.model.Author;
import org.springframework.data.repository.CrudRepository;

public interface AuthorRepository extends CrudRepository<Author, Long> {}
