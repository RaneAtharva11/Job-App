package com.krazzy.Service;

import com.krazzy.Model.JobPost;
import com.krazzy.Repo.JobRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class Jobservice {
    private JobRepo repo;
    public JobRepo getRepo() {
        return repo;
    }
        @Autowired
    public void setRepo(JobRepo repo) {
        this.repo = repo;
    }



    public void addJob(JobPost jobs){
        repo.addJobs(jobs);

    }

    public List<JobPost> getallJobs(){
         return repo.getallJobs();
    }




}
