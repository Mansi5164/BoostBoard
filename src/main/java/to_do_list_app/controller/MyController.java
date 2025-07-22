package to_do_list_app.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import to_do_list_app.model.Todo;
import to_do_list_app.service.TodoService;

@Controller
public class MyController {
	
	@Autowired
	private TodoService todoservice;

	@GetMapping("/") // This handles normal browser access
	public String index(Model model) {
		List<Todo> list = todoservice.getAllList();
		model.addAttribute("todos", list);
		return "index";
	}

	@PostMapping("/add")
	public String addTodo(@RequestParam String task) {
		Todo todo = new Todo();
		todo.setTask(task);
		todo.setCompleted(false);
		todoservice.add(todo);
		return "redirect:/";
	}

	@PostMapping("/delete/{id}")
	public String deleteTodo(@PathVariable Long id) {
		todoservice.delete(id);
		return "redirect:/";
	}

	@PostMapping("/edit/{id}")
	public String editTodo(@PathVariable Long id, @RequestParam String task) {
		todoservice.edit(id, task);
		return "redirect:/";
	}

	@PostMapping("/toggle/{id}")
	public String toggleTodoCompleted(@PathVariable Long id) {
		todoservice.toggleCompleted(id);
		return "redirect:/";
	}
}
