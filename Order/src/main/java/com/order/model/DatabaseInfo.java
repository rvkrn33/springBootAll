package com.order.model;

import org.springframework.stereotype.Component;

@Component
public class DatabaseInfo {
 
	private String H2;
	private String oracle;
	private String mysql;
	private String postgresSql;
	public DatabaseInfo() {}
	public DatabaseInfo(String h2, String oracle, String mysql, String postgresSql) {
		super();
		H2 = h2;
		this.oracle = oracle;
		this.mysql = mysql;
		this.postgresSql = postgresSql;
	}
	public String getH2() {
		return H2;
	}
	public void setH2(String h2) {
		H2 = h2;
	}
	public String getOracle() {
		return oracle;
	}
	public void setOracle(String oracle) {
		this.oracle = oracle;
	}
	public String getMysql() {
		return mysql;
	}
	public void setMysql(String mysql) {
		this.mysql = mysql;
	}
	public String getPostgresSql() {
		return postgresSql;
	}
	public void setPostgresSql(String postgresSql) {
		this.postgresSql = postgresSql;
	}
		
	
}
