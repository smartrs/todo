package kr.todolist.service;

import java.util.List;
import kr.todolist.entity.Response;
import kr.todolist.entity.RestStatus;
import kr.todolist.entity.Todo;
import kr.todolist.entity.repository.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class TodoService {

  @Autowired
  private TodoRepository todoRepository;



  public Object selectTodoList(Pageable pageable) {

    return new Response(RestStatus.SUCCESS, null, todoRepository.findAll(pageable));
  }

  public Object selectTodoById(int id) {

    return new Response(RestStatus.SUCCESS, null, todoRepository.findById(id));
  }

  public Object createTodo(Todo todo) {

    return new Response(RestStatus.SUCCESS, null, todoRepository.save(todo));
  }

  public Object updateTodo(int id, Todo todo) {

    if (id != todo.getId()) {
      todo.setId(id);
    }

    return new Response(RestStatus.SUCCESS, null, todoRepository.save(todo));
  }

  public Object updateTodoCompleted(int id) {

    //Select 해서 List 조
    List<String> notCompleted = todoRepository.selectTodoRefNotCompleted(id);

    if (notCompleted.size() > 0) {
      return new Response(RestStatus.FAIL, notCompleted + "가 먼저 완료되어야 합니다.", null);
    } else {
      todoRepository.updateTodoCompleted(id);
      return new Response(RestStatus.SUCCESS, null, todoRepository.findById(id));
    }
  }
}
