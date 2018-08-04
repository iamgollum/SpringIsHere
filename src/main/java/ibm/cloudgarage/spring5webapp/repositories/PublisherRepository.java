package ibm.cloudgarage.spring5webapp.repositories;

import ibm.cloudgarage.spring5webapp.model.Publisher;
import org.springframework.data.repository.CrudRepository;

public interface PublisherRepository extends CrudRepository<Publisher, Long> {}
