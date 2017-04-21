package org.lightfor.easyforum.service.impl;

import org.lightfor.easyforum.mapper.TopicMapper;
import org.lightfor.easyforum.pojo.Topic;
import org.lightfor.easyforum.service.TopicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 帖子Service实现类
 * Created by Light on 2017/4/16.
 */
@Service
public class TopicServiceImpl implements TopicService {

    @Autowired
    private TopicMapper topicMapper;


    public List<Topic> listByForumId(long forumId) {
        return topicMapper.listByForumId(forumId);
    }

    public void save(Topic topic) {
        topicMapper.save(topic);
    }

    public Topic get(long id) {
        return topicMapper.get(id);
    }
}
