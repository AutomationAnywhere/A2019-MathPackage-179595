
package com.automationanywhere.botcommand.sk;



import com.automationanywhere.botcommand.data.impl.StringValue;
import com.automationanywhere.botcommand.exception.BotCommandException;
import com.automationanywhere.commandsdk.annotations.BotCommand;
import com.automationanywhere.commandsdk.annotations.CommandPkg;
import com.automationanywhere.commandsdk.annotations.Idx;
import com.automationanywhere.commandsdk.annotations.Pkg;
import com.automationanywhere.commandsdk.annotations.rules.NotEmpty;
import com.automationanywhere.commandsdk.model.AttributeType;
import com.automationanywhere.commandsdk.model.DataType;
import com.automationanywhere.commandsdk.annotations.Execute;


/**
 * @author Stefan Karsten
 *
 */

@BotCommand
@CommandPkg(label = "Math Expression", name = "mathevaluate",
        description = "Math Expression Parser",
        node_label = "Math Expression Parser", icon = "pkg.svg", comment = true , text_color = "#707fb7" , background_color =  "#707fb7" ,
        return_type=DataType.STRING,  return_label="Result", return_required=true)

public class Expression {
	   
	@Execute
    public StringValue action(@Idx(index = "1", type = AttributeType.TEXT)  @Pkg(label = "Expression"  , default_value_type = DataType.STRING ) @NotEmpty String expression,
    						  @Idx(index = "2", type = AttributeType.NUMBER)  @Pkg(label = "Precision"  , default_value_type = DataType.NUMBER ,default_value="2") @NotEmpty Number precision ) throws Exception
     {
		String result = "";
	//	try {
				MathJS math = new MathJS();
				String expr = expression;
		         result =math.eval(expr,precision.intValue());
//		}
//		catch (Exception e) {
	//		throw new BotCommandException("Math Exception : "+expression);
	//	}
		return new StringValue(result);

	}

		
	
}