package com.hank.sample.springboot.course.jpa.topic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TopicService {

    @Autowired
    private TopicRepository topicRepository;

    public List<Topic> getAllTopics() {
        List<Topic> topics = new ArrayList<>();
        topicRepository.findAll().forEach(topics::add);
        return topics;
    }

    public Topic getTopicById(String id) {
        if (topicRepository.existsById(id)) {
            return topicRepository.findById(id).get();
        }
        return null;
    }

    public void addTopic(Topic topic) {
        topicRepository.save(topic);
    }

    public void updateTopic(String id, Topic topic) {
        topicRepository.save(topic);
    }

    public void removeTopicById(String id) {
        if (topicRepository.existsById(id)) {
            topicRepository.deleteById(id);
        }
    }
}
