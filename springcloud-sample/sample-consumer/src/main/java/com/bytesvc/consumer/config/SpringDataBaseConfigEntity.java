package com.bytesvc.consumer.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component("springDataBaseConfigEntity")
public class SpringDataBaseConfigEntity implements java.io.Serializable{
    
	private static final long serialVersionUID = 3244343036234626791L;

	@Value("${master.datasource.url}")
    private String masterUrl;
 
    @Value("${master.datasource.username}")
    private String masterUser;
 
    @Value("${master.datasource.password}")
    private String masterPassword;
 
    @Value("${master.datasource.driverClassName}")
    private String masterDriverClass;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getMasterUrl() {
        return masterUrl;
    }

    public void setMasterUrl(String masterUrl) {
        this.masterUrl = masterUrl;
    }

    public String getMasterUser() {
        return masterUser;
    }

    public void setMasterUser(String masterUser) {
        this.masterUser = masterUser;
    }

    public String getMasterPassword() {
        return masterPassword;
    }

    public void setMasterPassword(String masterPassword) {
        this.masterPassword = masterPassword;
    }

    public String getMasterDriverClass() {
        return masterDriverClass;
    }

    public void setMasterDriverClass(String masterDriverClass) {
        this.masterDriverClass = masterDriverClass;
    }
}