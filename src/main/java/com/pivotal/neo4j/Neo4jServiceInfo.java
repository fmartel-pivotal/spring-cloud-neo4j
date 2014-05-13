package com.pivotal.neo4j;
import org.springframework.cloud.service.BaseServiceInfo;
import org.springframework.cloud.service.ServiceInfo.ServiceLabel;

@ServiceLabel("neo4j")
public class Neo4jServiceInfo  extends BaseServiceInfo {
	String host;
	Integer port;
	String user;
	String password;
	
	Neo4jServiceInfo(String id, String host, Integer port, String usr, String password){
		super(id);
		this.host=host;
		this.port=port;
		this.user=usr;
		this.password=password;
	}
	@ServiceProperty
	public String getHost(){
		return host;
	}
	@ServiceProperty
	public Integer getPort(){
		return port;
	}
	@ServiceProperty
	public String getUser(){
		return user;
	}
	@ServiceProperty
	public String getPassword(){
		return password;
	}
}
