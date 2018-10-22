package kr.todolist.entity.repository;

import java.util.List;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 *  TODO Custom Repository Implements
 *  Table : TODOS, TODO_REFER
 */
public class TodoCustomRepositoryImpl implements TodoCustomRepository {

  private final JdbcTemplate jdbcTemplate;

  public TodoCustomRepositoryImpl(JdbcTemplate jdbcTemplate) {
    this.jdbcTemplate = jdbcTemplate;
  }

  final String UPDATE_TODO_COMPLETED
    = "UPDATE TODOS"
    + "   SET completed_at = current_timestamp,"
    + "       updated_at = current_timestamp"
    + " WHERE id = ?";

  final String SELECT_TODO_REF_NOT_COMPLETED
    = "SELECT B.title"
    + "  FROM TODO_REFER A LEFT JOIN"
    + "       TODOS B ON A.todo_id = B.id"
    + " WHERE A.todo_ref_id = ?"
    + "   AND B.completed_at IS NULL";

  /**
   * ID에 해당하는 TODO를 완료 처리
   * @param id
   */
  @Override
  public void updateTodoCompleted(int id) {
    jdbcTemplate.update(UPDATE_TODO_COMPLETED, id);
  }

  /**
   * TODO_REF_ID를 이용하여 완료 처리가 안된 TODO를 조회
   * @param todoRefId
   * @return
   */
  @Override
  public List<String> selectTodoRefNotCompleted(int todoRefId) {
    return jdbcTemplate.queryForList(SELECT_TODO_REF_NOT_COMPLETED, String.class, todoRefId);
  }

}
