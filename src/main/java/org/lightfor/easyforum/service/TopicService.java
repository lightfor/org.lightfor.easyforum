package org.lightfor.easyforum.service;

import org.lightfor.easyforum.pojo.Topic;

import java.util.List;

/**
 * 帖子Service
 * Created by Light on 2017/4/16.
 */
public interface TopicService {
    List<Topic> listByForumId(long forumId);

    void save(Topic topic);

    Topic get(long id);
}
