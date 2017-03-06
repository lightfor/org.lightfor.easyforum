package org.lightfor.easyforum.mapper;

import org.lightfor.easyforum.pojo.Forum;

import java.util.List;

/**
 * 版面
 * Created by Light on 2017/1/13.
 */
public interface ForumMapper {
    List<Forum> selectByParentId(long parentId);
}
