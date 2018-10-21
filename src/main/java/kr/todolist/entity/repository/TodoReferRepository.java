package kr.todolist.entity.repository;

import java.util.List;
import kr.todolist.entity.TodoRefer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TodoReferRepository extends JpaRepository<TodoRefer, Integer> {

  List<TodoRefer> findByTodoId(int id);

  Integer countByTodoIdAndTodoRefId(int todoId, int todoRefId);

  boolean existsByTodoIdAndTodoRefId(int todoId, int todoRefId);
}
