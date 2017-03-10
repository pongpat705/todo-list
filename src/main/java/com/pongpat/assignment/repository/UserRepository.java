package com.pongpat.assignment.repository;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.pongpat.assignment.model.TaskUser;

public interface UserRepository extends PagingAndSortingRepository<TaskUser, Long>{

}
