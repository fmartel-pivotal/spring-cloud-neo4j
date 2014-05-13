package com.pivotal.neo4j;

import org.springframework.cloud.cloudfoundry.CloudFoundryServiceInfoCreator;

import java.util.Map;
import java.util.List;


public class Neo4jServiceInfoCreator extends CloudFoundryServiceInfoCreator<Neo4jServiceInfo> {

	public Neo4jServiceInfoCreator(){
		super("neo4j");
	}
    public Neo4jServiceInfoCreator(String tag) {
       super("neo4j");
    }

    public Neo4jServiceInfo createServiceInfo(Map<String, Object> serviceData) {
        @SuppressWarnings("unchecked") 
        Map<String, Object> credentials = (Map<String, Object>) serviceData.get("credentials");

        String id = (String) serviceData.get("name");
        String host = (String) credentials.get("host");
        Integer port = (Integer) credentials.get("http_port");
        String user = (String) credentials.get("username");
        String password = (String) credentials.get("password");

        return new Neo4jServiceInfo(id, host, port, user, password);
    }

    @Override
    public boolean accept(Map<String, Object> serviceData) {
    	@SuppressWarnings("unchecked") 
		String label = (String) serviceData.get("label");
    	return label.contains("neo4j");
    }
}