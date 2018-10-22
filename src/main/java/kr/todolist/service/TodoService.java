package kr.todolist.service;

import java.util.List;
import kr.todolist.entity.Response;
import kr.todolist.entity.RestStatus;
import kr.todolist.entity.Todo;
import kr.todolist.entity.repository.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

/**
 *  TODO Service
 */
@Service
public class TodoService {

  @Autowired
  private TodoRepository todoRepository;


  /**
   * TODO List 조회
   * @param pageable
   * @return
   */
  public Object selectTodoList(Pageable pageable) {

    return new Response(RestStatus.SUCCESS, null, todoRepository.findAll(pageable));
  }

  /**
   * ID를 이용하여 TODO 조회
   * @param id
   * @return
   */
  public Object selectTodoById(int id) {

    return new Response(RestStatus.SUCCESS, null, todoRepository.findById(id));
  }

  /**
   * TODO 생성
   * @param todo
   * @return
   */
  public Object createTodo(Todo todo) {

    return new Response(RestStatus.SUCCESS, null, todoRepository.save(todo));
  }

  /**
   * TODO 변경
   * @param id
   * @param todo
   * @return
   */
  public Object updateTodo(int id, Todo todo) {

    if (id != todo.getId()) {
      todo.setId(id);
    }

    return new Response(RestStatus.SUCCESS, null, todoRepository.save(todo));
  }

  /**
   * TODO 완료처리
   * @param id
   * @return
   */
  public Object updateTodoCompleted(int id) {

    List<String> notCompleted = todoRepository.selectTodoRefNotCompleted(id);

    if (notCompleted.size() > 0) {
      return new Response(RestStatus.FAIL, notCompleted + "가 먼저 완료되어야 합니다.", null);
    } else {
      todoRepository.updateTodoCompleted(id);
      return new Response(RestStatus.SUCCESS, null, todoRepository.findById(id));
    }
  }
}
