package com.hank.sample.springboot.course.jpa.course;

import com.hank.sample.springboot.course.jpa.topic.Topic;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CourseRepository extends CrudRepository<Course, String> {

    /*
     Do not have to implement the method
     Spring JPA will implement the method with specific name
      */
    public List<Course> findCoursesByTopicId(String topicId);
}
