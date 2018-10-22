package kr.todolist.controller;

import kr.todolist.entity.Todo;
import kr.todolist.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TodoController {

  @Autowired
  private TodoService todoService;

  @GetMapping("/todo")
  public Object selectTodoList(@PageableDefault(size =5) Pageable pageable) {

    return todoService.selectTodoList(pageable);
  }

  @PostMapping("/todo")
  public Object createTodo(@RequestBody Todo todo) {

    return todoService.createTodo(todo);
  }

  @GetMapping("/todo/{id}")
  public Object selectTodo(@PathVariable(value = "id") int id) {

    return todoService.selectTodoById(id);
  }

  @PutMapping("/todo/{id}")
  public Object updateTodo(@PathVariable(value = "id") int id, @RequestBody Todo todo) {

    return todoService.updateTodo(id, todo);
  }

  @PutMapping("/todo/{id}/completed")
  public Object updateTodoCompleted(@PathVariable(value = "id") int id) {

    return todoService.updateTodoCompleted(id);
  }
}
