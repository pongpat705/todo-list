package com.pongpat.assignment.repository;

import javax.transaction.Transactional;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.pongpat.assignment.model.Task;

@Transactional
public interface TaskRepository extends PagingAndSortingRepository<Task, Long>{

}
