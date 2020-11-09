package com.automationanywhere.botcommand.sk;




import java.io.BufferedReader;
import java.io.InputStream;
	import java.io.InputStreamReader;
	import java.util.stream.Collectors;
	
import javax.script.ScriptException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import com.eclipsesource.v8.*;




public class MathJS {
    protected static String MATHJS_FILE = "./lib/mathjs/math.js";

   
	  private static final Logger logger = LogManager.getLogger(MathJS.class);
	  
	  
    public String eval (String expr,Integer precision) throws ScriptException, Exception {
	    InputStream jsfile = getClass().getResourceAsStream("/js/math.min.js");

	    String jsstring = new BufferedReader(new InputStreamReader(jsfile))
	    		  .lines().collect(Collectors.joining("\n"));
	    V8 runtime = V8.createV8Runtime();
	    runtime.executeVoidScript(jsstring);
	    runtime.executeVoidScript("var parser = math.parser();");
	    runtime.executeVoidScript("var precision = "+precision+";");
	    String script = "math.format(parser.evaluate('"+expr+"'), precision);";
	    return runtime.executeStringScript(script);

    }


}