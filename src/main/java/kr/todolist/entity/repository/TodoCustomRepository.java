package kr.todolist.entity.repository;

import java.util.List;

public interface TodoCustomRepository {

  void updateTodoCompleted(int id);

  List<String> selectTodoRefNotCompleted(int id);
}
