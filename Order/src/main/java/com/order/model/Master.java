package com.order.model;

import org.springframework.stereotype.Component;

@Component
public class Master {
	private String name;
	private Models models;
	private ConfigInfo config;
	private DatabaseInfo dbInfo;
	private ServerInfo serverInfo;
	public Master(){}
	
	public Master(String name, Models models, ConfigInfo config, DatabaseInfo dbInfo, ServerInfo serverInfo) {
		super();
		this.name = name;
		this.models = models;
		this.config = config;
		this.dbInfo = dbInfo;
		this.serverInfo = serverInfo;
	}

	public Models getModels() {
		return models;
	}
	public void setModels(Models models) {
		this.models = models;
	}
	public ConfigInfo getConfig() {
		return config;
	}
	public void setConfig(ConfigInfo config) {
		this.config = config;
	}
	public DatabaseInfo getDbInfo() {
		return dbInfo;
	}
	public void setDbInfo(DatabaseInfo dbInfo) {
		this.dbInfo = dbInfo;
	}
	public ServerInfo getServerInfo() {
		return serverInfo;
	}
	public void setServerInfo(ServerInfo serverInfo) {
		this.serverInfo = serverInfo;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	
}
