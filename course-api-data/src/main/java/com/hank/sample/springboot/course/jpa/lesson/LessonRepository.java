package com.hank.sample.springboot.course.jpa.lesson;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface LessonRepository extends CrudRepository<Lesson, String> {

    /*
     Do not have to implement the method
     Spring JPA will implement the method with specific name
      */
    public List<Lesson> findLessonsByCourse_Id(String courseId);

}
