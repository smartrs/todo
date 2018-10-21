package kr.todolist.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Response {

  private RestStatus status;
  private String message;
  private Object data;
}
