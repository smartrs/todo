package kr.todolist.entity.repository;

import java.util.List;
import org.springframework.jdbc.core.JdbcTemplate;

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

  @Override
  public void updateTodoCompleted(int id) {
    jdbcTemplate.update(UPDATE_TODO_COMPLETED, id);
  }

  @Override
  public List<String> selectTodoRefNotCompleted(int id) {
    return jdbcTemplate.queryForList(SELECT_TODO_REF_NOT_COMPLETED, String.class, id);
  }

}
