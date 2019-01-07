package com.hank.sample.springboot.course.jpa.lesson;

import com.hank.sample.springboot.course.jpa.course.Course;
import com.hank.sample.springboot.course.jpa.topic.Topic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class LessonController {

    @Autowired
    private LessonService lessonService;

    @RequestMapping("/topics/{topicId}/courses/{courseId}/lessons")
    public List<Lesson> getAllLessons(@PathVariable String topicId,
                                      @PathVariable String courseId) {
        return lessonService.getAllLessons(courseId);
    }

    @RequestMapping("/topics/{topicId}/courses/{courseId}/lessons/{id}")
    public Lesson getLessonById(@PathVariable String topicId,
                                @PathVariable String courseId,
                                @PathVariable String id) {
        return lessonService.getLessonById(id);
    }

    /**
     * deprecated
    @RequestMapping(method = RequestMethod.POST, value = "/topics/{topicId}/courses/{courseId}/lessons")
    public void addLesson(@PathVariable String topicId,
                          @PathVariable String courseId,
                          @RequestBody Lesson lesson) {
        lesson.setCourse(new Course(courseId, "", "", ""));
        lessonService.addLesson(courseId, lesson);
    }
     */

    @RequestMapping(method = RequestMethod.POST, value = "/topics/{topicId}/courses/{courseId}/lessons")
    public void addLessons(@PathVariable String topicId,
                          @PathVariable String courseId,
                          @RequestBody List<Lesson> lessons) {
        for (Lesson lesson:lessons) {
            lesson.setCourse(new Course(courseId, "", "", ""));
        }
        lessonService.addLessons(courseId, lessons);
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/topics/{topicId}/courses/{courseId}/lessons/{id}")
    public void updateLesson(@PathVariable String topicId,
                             @PathVariable String courseId,
                             @PathVariable String id,
                             @RequestBody Lesson lesson) {
        lesson.setCourse(new Course(courseId, "", "", ""));
        lessonService.updateLesson(courseId, id, lesson);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/topics/{topicId}/courses/{courseId}/lessons/{id}")
    public void deleteCourse(@PathVariable String topicId,
                             @PathVariable String courseId,
                             @PathVariable String id) {
        lessonService.removeLessonById(id);
    }

}
