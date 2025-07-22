package to_do_list_app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import to_do_list_app.model.Todo;

public interface TodoRepository extends JpaRepository<Todo,Long>{
	
}
