package org.lightfor.easyforum.controller;

import org.lightfor.easyforum.pojo.Forum;
import org.lightfor.easyforum.service.ForumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
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

    @RequestMapping(value = {""}, method = RequestMethod.GET)
    public List<Forum> index(){
        return forumService.listForumByParentId(0L);
    }

    @RequestMapping(value = {"/{id}"})
    public List<Forum> list(@PathVariable long id){
        return forumService.listForumByParentId(id);
    }

    @RequestMapping(value = "/r/{id}")
    public String remove(@PathVariable long id){
        forumService.remove(id);
        return "success";
    }

    @RequestMapping(value = "/s")
    public String save(Forum forum){
        forumService.save(forum);
        return "success";
    }

}
