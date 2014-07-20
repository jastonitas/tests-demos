package com.astonitas.view.frameworks.demo.persist;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.astonitas.view.frameworks.demo.bean.BaseBean;

public class PersistenceRepository<T extends BaseBean> {

	Map<String, List<T>> master = new HashMap<String, List<T>>();
	
	public boolean createPersistenceRepository(Class<T> clazz) {
		String className = clazz.toString(); 
		List<T> repository = new ArrayList<T>();
		master.put(className, repository);
		return true;
	}
	
	@SuppressWarnings("unchecked")
	public boolean persistData(T o) {
		Class<T> clazz = (Class<T>) o.getClass();
		List<T> dataList = retrieveDataListFromMaster(clazz);
		T objectToRemove = findObjectInList(dataList, o);
		
		if (objectToRemove != null) {
			dataList.remove(objectToRemove);
		}
		
		dataList.add(o);
		
		return true;
	}

	@SuppressWarnings("unchecked")
	public boolean deleteData(T o) {
		Class<T> clazz = (Class<T>) o.getClass();
		List<T> dataList = retrieveDataListFromMaster(clazz);
		T objectToRemove = findObjectInList(dataList, o);
		
		if (objectToRemove != null) {
			dataList.remove(objectToRemove);
		}
		
		return true;
	}
	
	public List<T> retrieveAll(Class<T> clazz) {
		return retrieveDataListFromMaster(clazz);
	}
	
	private T findObjectInList(List<T> dataList, T o) {
		T objectToFind = null; 
		
		for (T t : dataList) {
			if (t.getId().equals(o.getId())) {
				objectToFind = t;
			}
		}
		
		return objectToFind;
	}
	
	private List<T> retrieveDataListFromMaster(Class<T> clazz) {
		String className = clazz.toString();
		return master.get(className);
	}
	
}