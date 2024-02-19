package com.Nk.JobApplication.Job;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

//public interface JobRepository extends CrudRepository {
//    we use this repository for the basic
//}
public interface JobRepository extends JpaRepository<Job,Long > { // we need to say the primary key datatype

}
