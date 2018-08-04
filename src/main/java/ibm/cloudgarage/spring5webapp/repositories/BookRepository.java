package ibm.cloudgarage.spring5webapp.repositories;

import ibm.cloudgarage.spring5webapp.model.Book;
import org.springframework.data.repository.CrudRepository;

public interface BookRepository extends CrudRepository<Book, Long> {}
