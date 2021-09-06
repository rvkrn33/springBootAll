package com.example.demo.jpa;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;

import com.example.demo.jpa.oneToMany.Book;
import com.example.demo.jpa.oneToMany.BookRepository;
import com.example.demo.jpa.oneToMany.Page;

public class springBootJPAMappingApp implements CommandLineRunner{

	@Autowired
	BookRepository bookRepo;
	
		public static void main(String[] args) {
			SpringApplication.run(springBootJPAMappingApp.class, args);
		}

		@Override
		public void run(String... args) throws Exception {
			
			Book b=new Book();
			b.setAuthor("NagaRao");
			b.setTitle("Abc");
			b.setIsbn("ee");
		
			Set<Page> set=new HashSet();
			
			Page p1=new Page();
			p1.setChapter("First");
			p1.setContent("My first chapter");
			p1.setNumber(101);
			p1.setBook(b);
			
			Page p2=new Page();
			p2.setChapter("Second");
			p2.setContent("My Second chapter");
			p2.setNumber(102);
			p2.setBook(b);
			
			set.add(p1);
			set.add(p2);
			b.setPages(set);
			
			bookRepo.save(b);
			
			List<Book> bookList=bookRepo.findAll();
			
			for(Book book:bookList) {
				System.out.println("Book ==============="+book.getId());
				System.out.println(book.getAuthor()+","+book.getTitle());
				
				Set<Page> setPage=book.getPages();
				
				for(Page p: setPage) {
					
					System.out.println("Pages ------------"+p.getId());
					System.out.println(p.getChapter()+","+p.getContent()+","+p.getNumber());
				}
			}
			
		}
		
		
}
