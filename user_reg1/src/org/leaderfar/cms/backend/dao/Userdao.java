package org.leaderfar.cms.backend.dao;

public class Userdao {
    public boolean login(String username ,String password){
    	
    	if(username.equals("admin")&&password.equals("admin")){
    		return true;
    	}
    	return false;
    }
}
