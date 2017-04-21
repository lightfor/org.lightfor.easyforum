package org.lightfor.easyforum.controller;

import org.lightfor.easyforum.pojo.Topic;
import org.lightfor.easyforum.service.TopicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * 帖子控制器
 * Created by Light on 2017/4/16.
 */
@Controller
@RequestMapping("/t")
public class TopicController {

    @Autowired
    private TopicService topicService;

    @RequestMapping(value = "/s")
    public ModelAndView save(Topic topic){
        topicService.save(topic);
        ModelAndView mv = new ModelAndView();
        mv.setViewName("redirect:/f/");
        return mv;
    }


    @RequestMapping(value = {"/{id}"})
    public ModelAndView list(@PathVariable long id){
        ModelAndView mv = new ModelAndView();
        mv.setViewName("Topic");
        mv.addObject("topic", topicService.get(id));
        return mv;
    }
}
