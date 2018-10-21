package kr.todolist;

import kr.todolist.entity.Todo;
import kr.todolist.service.TodoService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TestTodoService {

	@Autowired
	TodoService todoService;


	@Test
	public void testService() {
		Todo todo1 = new Todo();
		todo1.setTitle("title1");
		Object object1 = todoService.createTodo(todo1);
		System.out.println(object1);


		Object object2 = todoService.selectTodoById(1);
		System.out.println(object2);

		Todo todo3 = new Todo();
		todo3.setId(1);
		todo3.setTitle("title2");

		Object object3 = todoService.updateTodo(todo3.getId(), todo3);
		System.out.println(object3);

		Object object4 = todoService.updateTodoCompleted(todo3.getId());
		System.out.println(object4);
	}

}
