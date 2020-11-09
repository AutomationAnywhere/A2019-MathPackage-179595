package com.automationanywhere.botcommand.sk;

import java.io.FileNotFoundException;

import javax.script.ScriptException;

public class test {

	public static void main(String[] args) throws Exception, ScriptException {
		// TODO Auto-generated method stub
		MathJS math = new MathJS();

	        System.out.println(math.eval("5.08 cm in inch",2));
	        System.out.println(math.eval("sin(45 deg) ^ 2",2));   
	        System.out.println(math.eval("9 / 3 + 2i",2));    
	        System.out.println(math.eval("det([-1, 2; 3, 1])",2));
	}

}
