package com.example.RestAPIServices;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

@RestController
public class TopicController {

    Logger log = LoggerFactory.getLogger(TopicController.class);

    @Autowired
    private TopicService topicService;

    @RequestMapping("/topics")
    public List<Topic> getAllTopics(HttpServletRequest request){
        String RequestURI = request.getRequestURI();
        String RemoteAddr = request.getRemoteAddr();
        log.info("the RemoteAddr is : " + RemoteAddr);
        log.info("the RequestURI is : " + RequestURI);
        return topicService.getAllTopics();
    }



    @RequestMapping("/topics/{id}")
    public Topic getTopic(@PathVariable String id){
        return topicService.getTopic(id);
    }

    @RequestMapping(method = RequestMethod.POST,value = "/topics")
    public void addTopic(@RequestBody Topic topic){
        topicService.addTopic(topic);
    }
    //example to get bodyrequest into map
//    @RequestMapping(method = RequestMethod.POST,value = "/topics")
//    public void addTopic(@RequestBody Map<String, String> json){
//        log.info("The description is : " + json.get("description"));
//    }

    @RequestMapping(method = RequestMethod.PUT,value = "/topics/{id}")
    public String updateTopic(@RequestBody Topic topic, @PathVariable String id){
        topicService.updateTopic(id,topic);
        return "good job!!!";
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/topics/{id}")
    public String deleteTopic(@PathVariable String id){
        topicService.deleteTopic(id);
        return " the id: " + id + " has deleted";
    }
}
