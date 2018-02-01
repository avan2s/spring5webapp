package org.andy.spring.spring5webapp.bootstrap;

import org.andy.spring.spring5webapp.model.Author;
import org.andy.spring.spring5webapp.model.Book;
import org.andy.spring.spring5webapp.repositories.AuthorRepository;
import org.andy.spring.spring5webapp.repositories.BookRepository;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Component
public class DevBootstrap implements ApplicationListener<ContextRefreshedEvent> {

    // autowired is not required, constructor auto injection
    private AuthorRepository authorRepository;

    private BookRepository bookRepository;


    public DevBootstrap(AuthorRepository authorRepository, BookRepository bookRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        initData();
    }

    private void initData() {
        //Eric
        Author a1 = new Author("Eric", "Evans");
        Book b1 = new Book("Domain Driven Design", "1234", "Marper Collins");
        a1.getBooks().add(b1);
        b1.getAuthors().add(a1);

        this.authorRepository.save(a1);
        this.bookRepository.save(b1);

        // Rod
        Author a2 = new Author("Rod", "Johnson");
        Book b2 = new Book("J2EE Development without EJB", "23444", "Worx");
        a2.getBooks().add(b2);
        b2.getAuthors().add(a2);

        this.authorRepository.save(a2);
        this.bookRepository.save(b2);
    }
}
