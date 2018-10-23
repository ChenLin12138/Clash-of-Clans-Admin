package com.chenlin.cocadmin.utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class AppPropertiesUtil {
	
	private String propFile;
	
	private Properties props;
	
	
	public AppPropertiesUtil(){
		;
	}
	
	public AppPropertiesUtil(String propFile){
		this.propFile = propFile;
		props = new Properties();
		InputStream is = this.getClass().getResourceAsStream(propFile);
        try {
            props.load(is);
            is.close();
            is = null;
        } catch (IOException e) {
            throw new IllegalStateException("Could not load " + propFile, e);
        }
	}
	
	public Properties getProps(){

        return props;
	}
	
	public String getProperty(String prop){
        String value = getProps().getProperty(prop);
        if (value == null){
            throw new IllegalArgumentException("Could not find property " + prop);
        }
		return value;
	}
	

	public String getPropFile() {
		return propFile;
	}

	public void setPropFile(String propFile) {
		this.propFile = propFile;
	}
	
	
}
