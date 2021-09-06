package com.example.demo.jpa.manytoMany;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table
public class Student {

    @Id
    Long id;

    @ManyToMany
    Set<Course> likedCourses;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Set<Course> getLikedCourses() {
		return likedCourses;
	}

	public void setLikedCourses(Set<Course> likedCourses) {
		this.likedCourses = likedCourses;
	}

    
    // additional properties
    // standard constructors, getters, and setters
}
