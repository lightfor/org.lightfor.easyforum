package org.lightfor.easyforum.mapper;

import org.lightfor.easyforum.pojo.Topic;

import java.util.List;

/**
 * 帖子mapper
 * Created by Light on 2017/4/16.
 */
public interface TopicMapper {
    List<Topic> listByForumId(long forumId);

    void save(Topic topic);

    Topic get(long id);
}
