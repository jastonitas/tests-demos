package com.astonitas.view.frameworks.demo.service;

import java.util.List;

import com.astonitas.view.frameworks.demo.bean.BaseBean;
import com.astonitas.view.frameworks.demo.bean.ToDo;

public interface ToDoService<T extends BaseBean> {
	void addToDo(ToDo todo);
	void updateToDo(ToDo todo);
	void deleteToDo(ToDo todo);
	List<ToDo> getToDoAll();
}
