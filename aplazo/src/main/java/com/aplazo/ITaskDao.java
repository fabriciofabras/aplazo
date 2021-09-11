package com.aplazo;

import org.springframework.data.repository.CrudRepository;
import com.aplazo.entity.Task;

public interface ITaskDao extends CrudRepository<Task, Long> {

}