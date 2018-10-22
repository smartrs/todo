package kr.todolist;

import kr.todolist.controller.TodoController;
import kr.todolist.controller.TodoReferController;
import kr.todolist.entity.Todo;
import kr.todolist.entity.TodoRefer;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TestTodoReferController {

	@Autowired
	TodoReferController todoReferController;

	@Autowired
	TodoController todoController;

	@Before
	public void testBefore() {
		Todo todo1 = new Todo();
		todo1.setTitle("test1");
		todoController.createTodo(todo1);

		Todo todo2 = new Todo();
		todo2.setTitle("test2");
		todoController.createTodo(todo2);
	}

	@Test
	public void testController() {
		TodoRefer todoRefer1 = new TodoRefer();
		todoRefer1.setTodoRefId(2);
		Object response = todoReferController.insertTodoRefer(1, todoRefer1);
		System.out.println(response.toString());


		response = todoReferController.selectTodoReferList(1);
		System.out.println(response.toString());
	}
}
