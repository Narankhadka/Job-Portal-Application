package com.Nk.JobApplication.Job;

import java.util.List;

public interface
JobServices {
    List<Job> findAll();
   void createJob(Job job);

    Job getJobById(Long id);
    boolean deleteJobById(Long id);

    boolean updateJob(Long id, Job updateJob);
}
