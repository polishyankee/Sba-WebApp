package com.example.sbawebapp.bootstrap;

import com.example.sbawebapp.domain.Author;
import com.example.sbawebapp.domain.Book;
import com.example.sbawebapp.domain.Publisher;
import com.example.sbawebapp.repository.AuthorRepository;
import com.example.sbawebapp.repository.BookRepository;
import com.example.sbawebapp.repository.PublisherRepository;

public class BootstrapData {

    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;
    private final PublisherRepository publisherRepository;

    public BootstrapData(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }
    public void run(String... args) throws Exception{
        System.out.println("Started in Bootstrap");

        Publisher publisher = new Publisher();
        publisher.setName("Third Reich");
        publisher.setCity("Monachium");
        publisher.setState("Bawaria");

        publisherRepository.save(publisher);

        System.out.println("Publisher count: " + publisherRepository.count());

        Author adolf = new Author("Adolf", "Hitler");
        Book mein = new Book("Mein Kampf","1935");
        adolf.getBooks().add(mein);
        mein.getAuthors().add(adolf);

        mein.setPublisher(publisher);
        publisher.getBooks().add(mein);

        authorRepository.save(adolf);
        bookRepository.save(mein);
        publisherRepository.save(publisher);

        Author rod = new Author("Rod", "Johnson");
        Book noEJB = new Book("J2EE Development", "1410");
        rod.getBooks().add(noEJB);
        noEJB.getAuthors().add(rod);

        noEJB.setPublisher(publisher);
        publisher.getBooks().add(noEJB);

        authorRepository.save(rod);
        bookRepository.save(noEJB);
        publisherRepository.save(publisher);

        System.out.println("Number of Books: " + bookRepository.count());
        System.out.println("Publisher number of books: " + publisher.getBooks().size());

    }
}
