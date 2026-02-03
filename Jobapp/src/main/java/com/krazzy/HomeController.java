package com.krazzy;

import com.krazzy.Model.JobPost;
import com.krazzy.Service.Jobservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class HomeController {

    @Autowired
    public Jobservice service;

    @GetMapping({"/","home"})
    public String home(){
        return "home";
    }

    @GetMapping("/viewalljobs")
    public String Viewjobs(Model model){
        List<JobPost> jobPosts=service.getallJobs();
        System.out.println(jobPosts);
        model.addAttribute("jobPosts",jobPosts);
        return "viewalljobs";
    }

    @GetMapping("/addjob")
    public String addjobs(){

        return "addjob";
    }

    @PostMapping("/handleForm")
    public String handleForm(JobPost jobPost, Model model)  {
        System.out.println(jobPost);
        service.addJob(jobPost);
        model.addAttribute("jobPost", jobPost);
        return "success";
    }

}
