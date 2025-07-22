package to_do_list_app.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import to_do_list_app.model.Todo;
import to_do_list_app.repository.TodoRepository;

@Service
public class TodoService {
	
	@Autowired
	private TodoRepository todorepository;
	
	public void add(Todo todo) {
		todorepository.save(todo);
	}
	
	public void delete(Long id) {
		todorepository.deleteById(id);
	}
	
	public List<Todo> getAllList() {
		return todorepository.findAll();
	}
	
	public void toggleCompleted(Long id) {
		Todo todo = todorepository.findById(id).orElse(null);
		if(todo != null) {
			todo.setCompleted(!todo.getCompleted());
			todorepository.save(todo);
		}
	}
	
	public void edit(Long id,String taskName) {
		Todo todo = todorepository.findById(id).orElse(null);
		if(todo != null) {
			todo.setTask(taskName);
			todorepository.save(todo);
		}
	}
}
