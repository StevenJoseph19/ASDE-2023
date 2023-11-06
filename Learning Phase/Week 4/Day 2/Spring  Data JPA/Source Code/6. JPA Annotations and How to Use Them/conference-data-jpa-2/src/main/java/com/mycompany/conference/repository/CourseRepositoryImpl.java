package com.mycompany.conference.repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.mycompany.conference.model.Course;

@Repository
public class CourseRepositoryImpl implements CourseRepository {

	@PersistenceContext
	private EntityManager entityManager;

	public Course save(Course course) {

		entityManager.persist(course);

		return course;
	}

}
