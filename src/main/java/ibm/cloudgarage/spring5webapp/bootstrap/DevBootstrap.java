package ibm.cloudgarage.spring5webapp.bootstrap;

import ibm.cloudgarage.spring5webapp.model.Author;
import ibm.cloudgarage.spring5webapp.model.Book;
import ibm.cloudgarage.spring5webapp.model.Publisher;
import ibm.cloudgarage.spring5webapp.repositories.AuthorRepository;
import ibm.cloudgarage.spring5webapp.repositories.BookRepository;
import ibm.cloudgarage.spring5webapp.repositories.PublisherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Component
public class DevBootstrap implements ApplicationListener<ContextRefreshedEvent> {

    private PublisherRepository publisherRepository;
    private AuthorRepository authorRepository;
    private BookRepository bookRepository;

    public DevBootstrap(PublisherRepository publisherRepository, AuthorRepository authorRepository, BookRepository bookRepository) {
        this.publisherRepository = publisherRepository;
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
    }

    private void InitData() {
        // Eric
        Publisher packt = new Publisher("Packt", "23 UK Lane", "Po Box 234", "UK", "Birmingham", "Birmingham", "00234-65");
        publisherRepository.save(packt);

        Author eric = new Author("Eric", "Evans");
        Book d = new Book("Domain Driven Design", "1234", packt);
        eric.getBooks().add(d);
        d.getAuthors().add(eric);

        authorRepository.save(eric);
        bookRepository.save(d);

        // Rod
        Publisher orielly = new Publisher("Orielly", "006 USA Lane", "Po Box 90", "USA", "New York", "NY", "10024");
        publisherRepository.save(orielly);

        Author rod = new Author("Rod", "Johnson");
        Book noEJB = new Book("No EJB", "23444", orielly);
        rod.getBooks().add(d);
        noEJB.getAuthors().add(rod);

        authorRepository.save(rod);
        bookRepository.save(noEJB);
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        InitData();
    }
}
