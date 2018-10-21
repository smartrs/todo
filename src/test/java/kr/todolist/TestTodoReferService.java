package kr.todolist;

import kr.todolist.entity.Todo;
import kr.todolist.entity.TodoRefer;
import kr.todolist.service.TodoReferService;
import kr.todolist.service.TodoService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TestTodoReferService {

	@Autowired
	TodoService todoService;

	@Autowired
	TodoReferService todoReferService;

	@Before
	public void before() {
		Todo todo1 = new Todo();
		todo1.setTitle("test1");
		todoService.createTodo(todo1);

		Todo todo2 = new Todo();
		todo2.setTitle("test2");
		todoService.createTodo(todo2);

		Todo todo3 = new Todo();
		todo3.setTitle("test3");
		todoService.createTodo(todo3);
	}

	@Test
	public void testService() {
		TodoRefer todoRefer1 = new TodoRefer();
		todoRefer1.setTodoRefId(2);
		Object response = todoReferService.insertTodoRefer(1, todoRefer1);
		System.out.println(response.toString());

		TodoRefer todoRefer2 = new TodoRefer();
		todoRefer2.setTodoRefId(1000);
		response = todoReferService.insertTodoRefer(1, todoRefer1);
		System.out.println(response.toString());

		TodoRefer todoRefer3 = new TodoRefer();
		todoRefer3.setTodoRefId(3);
		response = todoReferService.insertTodoRefer(1000, todoRefer1);
		System.out.println(response.toString());


		response = todoReferService.selectTodoReferList(1);
		System.out.println(response.toString());
	}

}
