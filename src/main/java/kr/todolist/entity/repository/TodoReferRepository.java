package kr.todolist.entity.repository;

import java.util.List;
import kr.todolist.entity.TodoRefer;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *  TODO Refer Repository
 *  Table : TODO_REFER
 */
public interface TodoReferRepository extends JpaRepository<TodoRefer, Integer> {

  /**
   * TODO_ID를 이용하여 TODO_REFER를 조회
   * @param id
   * @return List<TodoRefer>
   */
  List<TodoRefer> findByTodoId(int id);

  /**
   * TODO_ID와 TODO_REF_ID를 이용하여 TODO_REFER가 존재 여부 검사
   * @param todoId
   * @param todoRefId
   * @return boolean
   */
  boolean existsByTodoIdAndTodoRefId(int todoId, int todoRefId);
}
