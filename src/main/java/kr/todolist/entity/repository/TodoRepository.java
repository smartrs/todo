package kr.todolist.entity.repository;

import kr.todolist.entity.Todo;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *  TODO Repository
 *  Table : TODOS
 *
 */
public interface TodoRepository extends JpaRepository<Todo, Integer>, TodoCustomRepository {

  /**
   * ID를 이용하여 TODO를 조회
   * @param id
   * @return Todo
   */
  Todo findById(int id);

  /**
   * ID를 이용하여 TODO가 존재 여부 검사
   * @param id
   * @return boolean
   */
  boolean existsById(int id);
}
