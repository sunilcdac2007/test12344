package com.harman.php;

import javax.script.*;

import php.java.bridge.*;
import php.java.script.*;
import php.java.servlet.*;

public class phpCallFromJava {

	public static void main(String[] args) {
		
		String code="echo 5+5; echo 'running'"; //sample bit of code
		ScriptEngineManager manager = new ScriptEngineManager();
		ScriptEngine engine = manager.getEngineByExtension("php");
		try {
		    engine.eval(code);
		} catch (ScriptException ex) {
		   ex.printStackTrace();
		}

		
	}

}
