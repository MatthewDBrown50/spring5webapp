package com.codnamebear.spring5webapp.bootstrap;

import com.codnamebear.spring5webapp.model.Author;
import com.codnamebear.spring5webapp.model.Book;
import com.codnamebear.spring5webapp.model.Publisher;
import com.codnamebear.spring5webapp.repositories.AuthorRepository;
import com.codnamebear.spring5webapp.repositories.BookRepository;
import com.codnamebear.spring5webapp.repositories.PublisherRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component // Makes Spring detect this as a Spring-managed component.
public class BootStrapData implements CommandLineRunner {

    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;
    private final PublisherRepository publisherRepository;

    public BootStrapData(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }


    // --- Implemented Method ---

    @Override
    public void run(String... args) throws Exception {
        System.out.println("Started in Bootstrap");

        Publisher sfg = new Publisher();
        sfg.setName("SFG Publishing");
        sfg.setAddressLine1("2342 Some Dr");
        sfg.setCity("St Petersburg");
        sfg.setState("FL");
        sfg.setZip("12324");

        publisherRepository.save(sfg);

        System.out.println("Publisher Count: " + publisherRepository.count());

        Author eric = new Author("Eric", "Evans");
        Book ddd = new Book("Domain Driven Design", "122321");
        eric.getBooks().add(ddd);
        ddd.getAuthors().add(eric);
        ddd.setPublisher(sfg);
        sfg.getBooks().add(ddd);

        authorRepository.save(eric);
        bookRepository.save(ddd);
        publisherRepository.save(sfg);

        Author rod = new Author("Rod", "Johnson");
        Book noEJB = new Book("J2EE Development without EJB", "4353454");
        rod.getBooks().add(noEJB);
        noEJB.getAuthors().add(rod);
        noEJB.setPublisher(sfg);
        sfg.getBooks().add(noEJB);

        authorRepository.save(rod);
        bookRepository.save(noEJB);
        publisherRepository.save(sfg);

        System.out.println("Number of books: " + bookRepository.count());
    }
}
