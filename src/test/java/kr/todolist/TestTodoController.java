package kr.todolist;

import kr.todolist.controller.TodoController;
import kr.todolist.entity.Todo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TestTodoController {

	@Autowired
	TodoController todoController;


	@Test
	public void testController() {
		Pageable pageable = PageRequest.of(0, 5);
		Object response = todoController.selectTodoList(pageable);
		System.out.println(response.toString());

		Todo todo1 = new Todo();
		todo1.setTitle("테스트1");
		response = todoController.createTodo(todo1);
		System.out.println(response.toString());

		Todo todo2 = new Todo();
		todo2.setTitle("테스트2");
		response = todoController.createTodo(todo2);
		System.out.println(response.toString());

		response = todoController.selectTodoList(pageable);
		System.out.println(response.toString());

		todo1.setTitle("테스트 11");
		response = todoController.updateTodo(1, todo1);
		System.out.println(response.toString());

		todo2.setTitle("테스트 2");
		response = todoController.updateTodo(2, todo2);
		System.out.println(response.toString());

		response = todoController.selectTodo(1);
		System.out.println(response.toString());

		response = todoController.updateTodoCompleted(1);
		System.out.println(response.toString());

		response = todoController.selectTodoList(pageable);
		System.out.println(response);
	}
}
