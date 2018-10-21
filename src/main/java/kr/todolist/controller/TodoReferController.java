package kr.todolist.controller;

import kr.todolist.entity.TodoRefer;
import kr.todolist.service.TodoReferService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TodoReferController {

  @Autowired
  private TodoReferService todoReferService;

  @GetMapping("/todo/{todoId}/refer")
  public Object selectTodoReferList(@PathVariable(value = "todoId") int todoId) {
    return todoReferService.selectTodoReferList(todoId);
  }

  @PostMapping("/todo/{todoId}/refer")
  public Object insertTodoRefer(@PathVariable(value = "todoId") int todoId,
    @RequestBody TodoRefer todoRefer) {
    return todoReferService.insertTodoRefer(todoId, todoRefer);
  }
}
