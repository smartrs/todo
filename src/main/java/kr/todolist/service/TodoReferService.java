package kr.todolist.service;

import kr.todolist.entity.Response;
import kr.todolist.entity.RestStatus;
import kr.todolist.entity.TodoRefer;
import kr.todolist.entity.repository.TodoReferRepository;
import kr.todolist.entity.repository.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TodoReferService {

  @Autowired
  private TodoRepository todoRepository;

  @Autowired
  private TodoReferRepository todoReferRepository;

  public Object selectTodoReferList(int todoId) {
    return new Response(RestStatus.SUCCESS, null, todoReferRepository.findByTodoId(todoId));
  }

  public Object insertTodoRefer(int todoId, TodoRefer todoRefer) {
    if (todoRepository.existsById(todoRefer.getTodoRefId())) {
      todoRefer.setTodo(todoRepository.findById(todoId));

      TodoRefer resTodoRefer = null;
      if (!todoReferRepository.existsByTodoIdAndTodoRefId(todoId, todoRefer.getTodoRefId())) {
        resTodoRefer = todoReferRepository.save(todoRefer);
      }

      return new Response(RestStatus.SUCCESS, null, resTodoRefer);
    } else {
      return new Response(RestStatus.FAIL, "정상적인 참조 할 일 ID를 입력하세요", null);
    }
  }
}
