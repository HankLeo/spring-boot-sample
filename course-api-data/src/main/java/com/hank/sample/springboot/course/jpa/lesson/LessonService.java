package com.hank.sample.springboot.course.jpa.lesson;

import com.hank.sample.springboot.course.jpa.course.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LessonService {

    @Autowired
    private LessonRepository lessonRepository;

    @Autowired
    private CourseRepository courseRepository;

    public List<Lesson> getAllLessons(String courseId) {
        List<Lesson> lessons = lessonRepository.findLessonsByCourse_Id(courseId);
        return lessons;
    }

    public Lesson getLessonById(String id) {
        if (lessonRepository.existsById(id)) {
            return lessonRepository.findById(id).get();
        }
        return null;
    }

    public void addLesson(String courseId, Lesson lesson) {
        if (courseRepository.existsById(courseId)) {
            lessonRepository.save(lesson);
        }
    }

    public void addLessons(String courseId, List<Lesson> lessons) {
        if (courseRepository.existsById(courseId)) {
            lessonRepository.saveAll(lessons);
        }
    }

    public void updateLesson(String courseId, String id, Lesson lesson) {
        if (courseRepository.existsById(courseId)) {
            lessonRepository.save(lesson);
        }
    }

    public void removeLessonById(String id) {
        if (lessonRepository.existsById(id)) {
            lessonRepository.deleteById(id);
        }
    }
}
