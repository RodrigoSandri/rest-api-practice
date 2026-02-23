package br.com.ulbra.demo.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import br.com.ulbra.demo.models.Task;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {

    List<Task> findByUser_Id(Long id);

   //@Query( value = "SELECT * FROM task t WHERE t.user_id = :id", nativeQuery = true)
   //List<Task> findByUser_id(@Param("id") Long id);

}