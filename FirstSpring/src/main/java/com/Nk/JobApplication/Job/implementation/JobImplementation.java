package com.Nk.JobApplication.Job.implementation;


import com.Nk.JobApplication.Job.Job;
import com.Nk.JobApplication.Job.JobRepository;
import com.Nk.JobApplication.Job.JobServices;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

@Service
public class JobImplementation implements JobServices
{
   // private List<Job>jobs=new ArrayList<>();
    JobRepository jobRepository;
    //private Long nextId=1L;

    public JobImplementation(JobRepository jobRepository) {
        this.jobRepository = jobRepository;
    }


    private Long id;

    @Override
    public List<Job> findAll() {
        return jobRepository.findAll();
    }

    @Override
    public void createJob(Job job) {
       // job.setId(nextId++);
      //  job.setId(nextId++);
        jobRepository.save(job);

    }

    @Override
    public Job getJobById(Long id) {
//       for (Job job:jobs)
//       {
//           if (job.getId().equals(id))
//           {
//               return job;
//           }
//           //throw new RuntimeException("Job with ID " + id + " not found");
//
//       }
//        return null;
       return jobRepository.findById(id).orElse(null);
    }

    @Override
    public boolean deleteJobById(Long id) {
//        Iterator<Job> iterator = jobs.iterator();
//        while (iterator.hasNext()) {
//            Job job = iterator.next();
//            if (job.getId().equals(id)) {
//                iterator.remove(); // Use iterator's remove to avoid ConcurrentModificationException
//                return true;
//            }
//        }
//        return false;
        try {jobRepository.deleteById(id);
            return true;

        }catch (Exception e)
        {
            return false;
        }

    }

    @Override
    public boolean updateJob(Long id, Job updateJob) {
//       for (int i=0;i<jobs.size();i++)
//       {
//           if (jobs.get(i).getId().equals(id))
//           {
//               jobs.set(i,updateJob);
//               return true;
//           }
//       }
//       return false;
//        for (Job job:jobs)
//        {
//            if (job.getId().equals(id))
//            {
//                job.setTitle(updateJob.getTitle());
//                job.setDescription(updateJob.getDescription());
//                job.setMinSalary(updateJob.getMinSalary());
//                job.setMaxSalary(updateJob.getMaxSalary());
//                job.setLocation(updateJob.getLocation());
//                return true;
//
//            }
//        }
//        return false;

        Optional<Job>jobOptional =jobRepository.findById(id);
//
        if (jobOptional.isPresent()) {
            Job job = jobOptional.get();
            job.setTitle(updateJob.getTitle());
            job.setDescription(updateJob.getDescription());
            job.setMinSalary(updateJob.getMinSalary());
            job.setMaxSalary(updateJob.getMaxSalary());
            job.setLocation(updateJob.getLocation());
            jobRepository.save(job);
            return true;
        }

        return false;
    }


}

