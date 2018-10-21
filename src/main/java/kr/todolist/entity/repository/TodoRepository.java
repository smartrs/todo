package kr.todolist.entity.repository;

import kr.todolist.entity.Todo;
import org.springframework.data.jpa.repository.JpaRepository;


public interface TodoRepository extends JpaRepository<Todo, Integer>, TodoCustomRepository {

  Todo findById(int id);

  boolean existsById(int id);
}
