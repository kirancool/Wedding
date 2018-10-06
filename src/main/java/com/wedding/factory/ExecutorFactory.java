/*package com.wedding.factory;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.wedding.common.Engine;
import com.wedding.executor.IExecutor;
import com.wedding.executor.MySqlExecutor;


@Component
public class ExecutorFactory {
	

	@Autowired
	MySqlExecutor mySqlExecutor;
	@Autowired
	Engine engine;
	
	public IExecutor getExecutor(String context) {
		String executionEngine = engine.getExecEngine();
		if(executionEngine != null && !StringUtils.isBlank(executionEngine) && executionEngine.equalsIgnoreCase("livy-spark"))
			executionEngine = "livy_spark";
		switch(context.toLowerCase()) {
		
			case "mysql": return mySqlExecutor;
			
		}
		return null;
	}
}
*/