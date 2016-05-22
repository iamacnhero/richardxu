package com.richardxu.script.js;

import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.script.Bindings;
import javax.script.CompiledScript;
import javax.script.ScriptException;
import javax.script.SimpleBindings;

import org.junit.Test;

/**
 * @author <a href="463692574@qq.com">Richard Xu</a>
 * @version 1.0
 * @since 2016年2月28日
 */
public class JsScriptEngineTest {
	
	@Test
	public void testRunScript() throws ScriptException {
		String script = "println('Hello!');";
		JsScriptEngine.runScript(script);
	}
	
	@Test
	public void testRunScriptWithBindings() throws ScriptException {
		Bindings bindings = new SimpleBindings();
		bindings.put("hobby", "play games");
		String script = "hobby.replace('games', 'basketball');";
		long start = System.currentTimeMillis();
		for (int i = 0; i < 100; i++) {
			JsScriptEngine.runScript(script, bindings);	
		}
		System.out.println("run " + (System.currentTimeMillis() - start) + " ms");	// run 934 ms
	}
	
	@Test
	public void testRunScriptOutput() throws ScriptException, IOException {
		String script = "println('Hello World!');";		
		JsScriptEngine.runScript(script, new FileWriter("/Users/xu/script.out"));
	}
	
	@Test
	public void testRunScriptWithAttributes() throws ScriptException {
		Map<String, Object> attributes = new HashMap<String, Object>();
		attributes.put("country", "china");
		String script = "println('I like [' + country + ']!');";
		JsScriptEngine.runScript(script, attributes);
	}
	
	@Test
	public void testRunScriptWithCompiled() throws ScriptException {
		Bindings bindings = new SimpleBindings();
		bindings.put("hobby", "play games");
		String script = "hobby.replace('games', 'basketball');";
		// 运行编译后的脚本
		CompiledScript compiledScript = JsScriptEngine.compile(script);
		long start = System.currentTimeMillis();
		for (int i = 0; i < 100; i++) {
			compiledScript.eval(bindings);
		}
		System.out.println("run " + (System.currentTimeMillis() - start) + " ms");	// 285ms, 编译后运行更快
	}
	
}