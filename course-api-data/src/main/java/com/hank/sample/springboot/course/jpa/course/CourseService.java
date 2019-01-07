package com.hank.sample.springboot.course.jpa.course;

import com.hank.sample.springboot.course.jpa.topic.TopicRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseService {

    @Autowired
    private CourseRepository courseRepository;

    @Autowired
    private TopicRepository topicRepository;

    public List<Course> getAllCourses(String topicId) {
        List<Course> courses = courseRepository.findCoursesByTopic_Id(topicId);
        return courses;
    }

    public Course getCourseById(String id) {
        if (courseRepository.existsById(id)) {
            return courseRepository.findById(id).get();
        }
        return null;
    }

    public void addCourse(String topicId, Course course) {
        if (topicRepository.existsById(topicId)) {
            courseRepository.save(course);
        }
    }

    public void addCourses(String topicId, List<Course> courses) {
        if (topicRepository.existsById(topicId)) {
            courseRepository.saveAll(courses);
        }
    }

    public void updateCourse(String topicId, String id, Course course) {
        if (topicRepository.existsById(topicId)) {
            courseRepository.save(course);
        }
    }

    public void removeCourseById(String id) {
        if (courseRepository.existsById(id)) {
            courseRepository.deleteById(id);
        }
    }
}
