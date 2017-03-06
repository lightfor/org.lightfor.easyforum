package org.lightfor.easyforum.controller;

import org.lightfor.easyforum.pojo.Forum;
import org.lightfor.easyforum.service.ForumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 版面
 * Created by Light on 2017/1/13.
 */
@RestController
@RequestMapping("/f")
public class ForumController {

    @Autowired
    private ForumService forumService;


    @RequestMapping("/")
    public List<Forum> index(){
        return forumService.findForumByParentId(0L);
    }
}
