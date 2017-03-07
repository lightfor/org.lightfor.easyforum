package org.lightfor.easyforum.service;

import org.lightfor.easyforum.pojo.Forum;

import java.util.List;

/**
 * 版面接口
 * Created by Light on 2017/1/13.
 */
public interface ForumService {
    List<Forum> listForumByParentId(long parentId);

    void save(Forum forum);

    Forum get(long id);

    void remove(long forum);
}
