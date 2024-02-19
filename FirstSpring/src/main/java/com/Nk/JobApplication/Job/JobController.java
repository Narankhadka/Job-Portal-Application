package com.Nk.JobApplication.Job;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;


@RestController
@RequestMapping("/jobs") // this is parents and /job is handle by the requestmappping
public class JobController {

private  JobServices jobServices;

    public JobController(JobServices jobServices) {
        this.jobServices = jobServices;
    }

    @GetMapping
    public ResponseEntity<List <Job>> findAll(){

       return ResponseEntity.ok(jobServices.findAll());
    }

    @PostMapping
    public  ResponseEntity<String> createJob(@RequestBody Job job){

        jobServices.createJob(job);
        return new ResponseEntity<>("Job added succsesfully",HttpStatus.CREATED);
    }
    @GetMapping("/{id}") // {} this is dynamic parameter
    public ResponseEntity<Job> getJobById(@PathVariable Long id)
    {

        Job job=jobServices.getJobById(id);
        if (job!=null)
        return new ResponseEntity<>(job,HttpStatus.OK);
        else
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);

    }
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteJob(@PathVariable Long id) {
        boolean delete = jobServices.deleteJobById(id);
        if (delete) {
            return new ResponseEntity<>("Job deleted successfully", HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
 @PutMapping("/{id}")// this this for only fot put
    // we can use both
    //@RequestMapping(value = "/jobs/{id}",method =RequestMethod.PUT )
    public ResponseEntity<String>updateJob(@PathVariable Long id, @RequestBody Job updateJob){
        boolean updated=jobServices.updateJob(id,updateJob);
        if (updated)
        {
            return new ResponseEntity<>("Job Updated Sucessfully",HttpStatus.OK);

        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);

    }


}

