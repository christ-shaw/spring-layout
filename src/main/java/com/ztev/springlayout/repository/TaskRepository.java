package com.ztev.springlayout.repository;

import com.ztev.springlayout.pojo.Task;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by ${xiaozb} on 2017/12/11.
 *
 * @copyright by ztev
 */
@Repository
public interface TaskRepository extends PagingAndSortingRepository<Task, Long> {

}