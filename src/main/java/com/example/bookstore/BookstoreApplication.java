package com.example.bookstore;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.bookstore.domain.Book;
import com.example.bookstore.domain.BookRepository;
import com.example.bookstore.domain.Category;
import com.example.bookstore.domain.CategoryRepository;

@SpringBootApplication
public class BookstoreApplication {
	private static final Logger log = LoggerFactory.getLogger(BookstoreApplication.class);


	public static void main(String[] args) {
		SpringApplication.run(BookstoreApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner bookDemo(BookRepository brepository, CategoryRepository crepository) {
		return (args) -> {
			log.info("save a couple of books");
			crepository.save(new Category("Adventure"));
			crepository.save(new Category("Horror"));
			crepository.save(new Category("Fantasy"));
			
			
			brepository.save(new Book("A Fareweel to Arms", "Ernest Hemingway", 1929, "1232323-21", 70, crepository.findByName("Adventure").get(0)));
			brepository.save(new Book("Animal Farm", "George Orwell", 1945, "2212343-5", 100, crepository.findByName("Horror").get(0)));	
			
			log.info("fetch all books");
			for (Book book : brepository.findAll() ) {
				log.info(book.toString());
			}
		};
	}
}
