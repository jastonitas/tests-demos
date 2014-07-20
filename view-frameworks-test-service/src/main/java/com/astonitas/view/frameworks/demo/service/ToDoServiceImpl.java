package com.astonitas.view.frameworks.demo.service;

import java.util.List;

import com.astonitas.view.frameworks.demo.bean.ToDo;
import com.astonitas.view.frameworks.demo.persist.PersistenceRepository;

public class ToDoServiceImpl implements ToDoService<ToDo> {

	private PersistenceRepository<ToDo> repository;
	
	public ToDoServiceImpl() {
		if (repository == null) {
			 repository = new PersistenceRepository<ToDo>();
		}
	}
	
	public void addToDo(ToDo todo) {
		repository.persistData(todo);
	}

	public void updateToDo(ToDo todo) {
		repository.persistData(todo);
	}

	public void deleteToDo(ToDo todo) {
		repository.deleteData(todo);
	}

	public List<ToDo> getToDoAll() {
		return repository.retrieveAll(ToDo.class);
	}

}
