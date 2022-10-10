package com.order.model;

import java.util.Map;

import org.springframework.stereotype.Component;

@Component
public class Models {
	private Map<String, String> classMap;
	private Actions actions;
	public Models() {}
	public Map<String, String> getClassMap() {
		return classMap;
	}
	public void setClassMap(Map<String, String> classMap) {
		this.classMap = classMap;
	}
	public Actions getActions() {
		return actions;
	}
	public void setActions(Actions actions) {
		this.actions = actions;
	}

	
}
