package com.example.demo;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

import com.example.demo.jpa.Address;
import com.example.demo.jpa.Employee;
import com.example.demo.jpa.EmployeeRespository;
import com.example.demo.jpa.manytoMany.Course;
import com.example.demo.jpa.manytoMany.Student;
import com.example.demo.jpa.manytoMany.StudentRepository;
import com.example.demo.jpa.oneToMany.Book;
import com.example.demo.jpa.oneToMany.BookRepository;
import com.example.demo.jpa.oneToMany.Page;
import com.example.demo.model.Customer;
import com.example.demo.model.User;
import com.example.demo.repository.CustomerRepository;
import com.example.demo.repository.UserRepository;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
//@EnableSwagger2
@EnableWebSecurity
public class DemoApplication implements CommandLineRunner{

	@Autowired
	CustomerRepository custRepo;
	
	@Autowired
	UserRepository userRepository;
	
	@Autowired
	EmployeeRespository empRepo;
	
	@Autowired
	BookRepository bookRepo;
	
	@Autowired
	StudentRepository studRepo;
	
	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		prepareData();
		
		//oneToOneMapping();
		
		//oneToMany();
	
		/*
		 * Student s1=new Student(); s1.setId(201L);
		 * 
		 * Student s2=new Student(); s2.setId(202L);
		 * 
		 * Course c1=new Course(); c1.setId(501L);
		 * 
		 * Course c2=new Course(); c2.setId(502L);
		 * 
		 * Set<Student> studSet= new HashSet(); studSet.add(s1); studSet.add(s2);
		 * 
		 * Set<Course> cSet= new HashSet(); cSet.add(c1); cSet.add(c2);
		 * 
		 * s1.setLikedCourses(cSet); s2.setLikedCourses(cSet);
		 * 
		 * c1.setLikes(studSet); c2.setLikes(studSet);
		 * 
		 * 
		 * studRepo.save(s1); studRepo.save(s2);
		 * 
		 * List<Student> sList=studRepo.findAll();
		 * 
		 * for(Student st: sList) { System.out.println("Student Id --> "+st.getId());
		 * 
		 * for(Course c: st.getLikedCourses())
		 * System.out.println("Course : "+c.getId()); }
		 */	}
	

	private void oneToMany() {
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

	private void oneToOneMapping() {
		Employee e=new Employee();
		e.setName("ravi");
		
		Address a=new Address();
		a.setCity("pune");
		a.setPincode(411046);
		a.setEmp(e);
		
		e.setAddress(a);
		
		empRepo.save(e);
		
		List<Employee> empList=empRepo.findAll();
		
		for(Employee em:empList) {
			System.out.println(e);
			System.out.println(e.getAddress().getCity());
		}
	}

	private void prepareData() {
		Customer c=new Customer("ravi",7852369852L,"Pune");
		Customer c1=new Customer("ajit",7852369852L,"Goa");
		Customer c2=new Customer("rajesh",7852369852L,"Mumbai");
		
		custRepo.save(c);
		custRepo.save(c1);
		custRepo.save(c2);
		
		System.out.println("Data Saved ");
		
		User u=new User();
		u.setUserName("ravi");
		u.setPassword("$2a$12$8I0ZBFS1EWCcSj3JubMHuOM.zorvkGRINApgNXiYPm2daD/bDbvsu");
		u.setRole("ADMIN");
	
		//$2a$12$nZypQU3CWtpJA9w7A/HrC.hhflppokqSDtecACK7snAk7eEDkrrZy
		
		User u1=new User();
		u1.setUserName("ajit");
		u1.setPassword("$2a$12$nZypQU3CWtpJA9w7A/HrC.hhflppokqSDtecACK7snAk7eEDkrrZy");
		u1.setRole("USER");
		
		userRepository.save(u);
		userRepository.save(u1);
	}

}
