package org.lightfor.easyforum.service.impl;

import org.lightfor.easyforum.mapper.ForumMapper;
import org.lightfor.easyforum.pojo.Forum;
import org.lightfor.easyforum.service.ForumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 版面
 * Created by Light on 2017/1/13.
 */
@Service("forumService")
public class ForumServiceImpl implements ForumService{

    @Autowired
    private ForumMapper forumMapper;

    public List<Forum> findForumByParentId(long parentId) {
        return forumMapper.selectByParentId(parentId);
    }
}
