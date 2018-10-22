package kr.todolist.entity.repository;

import java.util.List;

/**
 *  TODO Custom Repository
 *  Table : TODOS, TODO_REFER
 */
public interface TodoCustomRepository {

  /**
   * ID에 해당하는 TODO를 완료 처리
   * @param id
   */
  void updateTodoCompleted(int id);

  /**
   * TODO_REF_ID를 이용하여 완료 처리가 안된 TODO를 조회
   * @param todoRefId
   * @return
   */
  List<String> selectTodoRefNotCompleted(int todoRefId);
}
