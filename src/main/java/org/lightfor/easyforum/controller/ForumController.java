package org.lightfor.easyforum.controller;

import org.lightfor.easyforum.pojo.Forum;
import org.lightfor.easyforum.service.ForumService;
import org.lightfor.easyforum.service.TopicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

/**
 * 版面
 * Created by Light on 2017/1/13.
 */
@Controller
@RequestMapping("/f")
public class ForumController {

    @Autowired
    private ForumService forumService;

    @Autowired
    private TopicService topicService;

    @RequestMapping(value = {"/"})
    public ModelAndView index(){
        ModelAndView mv = new ModelAndView();
        mv.setViewName("Forum");
        mv.addObject("forum", forumService.listForumByParentId(0L));
        mv.addObject("topic", topicService.listByForumId(0L));
        return mv;
    }

    @RequestMapping(value = {"/{id}"})
    public ModelAndView list(@PathVariable long id, HttpServletResponse response){
        Cookie cookie = new Cookie("id", String.valueOf(id));
        response.addCookie(cookie);
        ModelAndView mv = new ModelAndView();
        mv.setViewName("Forum");
        mv.addObject("forum", forumService.listForumByParentId(id));
        mv.addObject("topic", topicService.listByForumId(id));
        return mv;
    }

    @RequestMapping(value = "/d/{id}")
    @ResponseBody
    public String delete(@PathVariable long id){
        forumService.remove(id);
        return "success";
    }

    @RequestMapping(value = "/s")
    @ResponseBody
    public String save(Forum forum){
        forumService.save(forum);
        return "success";
    }

}
