package com.richardxu.script.js;

import java.io.Writer;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.script.Bindings;
import javax.script.Compilable;
import javax.script.CompiledScript;
import javax.script.ScriptContext;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

/**
 * JS ScriptEngine
 * 
 * @author <a href="463692574@qq.com">Richard Xu</a>
 * @version 1.0
 * @since 2016年2月28日
 */
public class JsScriptEngine {
	
	public static ScriptEngine getJavaScriptEngine() {
		ScriptEngineManager manager = new ScriptEngineManager();
		// 1. 通过名称
		// ScriptEngine engine = manager.getEngineByName("JavaScript");
		// 2. 通过文件扩展名 
		// ScriptEngine engine = manager.getEngineByExtension("js");
		// 3. 通过MIME类型
		ScriptEngine engine = manager.getEngineByMimeType("text/javascript");
		if (engine == null) 
			throw new RuntimeException("找不到JavaSCript语言执行引擎!");
		return engine;
	}
	
	public static void runScript(String script) throws ScriptException {
		ScriptEngine engine = getJavaScriptEngine();
		engine.eval(script);
	}
	
	public static void runScript(String script, Bindings bindings) throws ScriptException {
		ScriptEngine engine = getJavaScriptEngine();
		engine.eval(script, bindings);
	}
	
	public static void runScript(String script, Map<String, Object> attributes) throws ScriptException {
		ScriptEngine engine = getJavaScriptEngine();
		ScriptContext context = engine.getContext();
		for (Entry<String, Object> entry : attributes.entrySet()) {
			context.setAttribute(entry.getKey(), entry.getValue(), ScriptContext.GLOBAL_SCOPE);
		}
		engine.eval(script);
	}
	
	public static void runScript(String script, Writer writer) throws ScriptException {
		ScriptEngine engine = getJavaScriptEngine();
		ScriptContext context = engine.getContext();
		// 把脚本运行的结果输出到文件
		context.setWriter(writer);
		engine.eval(script);
	}
	
	/**
	 * 语言绑定对象的优先级顺序的示例
	 * @param script
	 * @param writer
	 * @throws ScriptException
	 */
	public static void runScript() throws ScriptException {
		ScriptEngine engine = getJavaScriptEngine();
		ScriptContext context = engine.getContext();
		Bindings bindings = engine.createBindings();		// 创建语言绑定对象
		bindings.put("name", "Alex");
		context.setBindings(bindings, ScriptContext.GLOBAL_SCOPE);
		Bindings bindings2 = engine.createBindings();
		bindings2.put("name", "Bob");
		context.setBindings(bindings2, ScriptContext.ENGINE_SCOPE);
		engine.eval("println(name);");
		
		System.out.println((context.getBindings(ScriptContext.ENGINE_SCOPE)));
	}
	
	public static List<Integer> getScopes() {
		ScriptEngine engine = getJavaScriptEngine();
		ScriptContext context = engine.getContext();
		
	    /**
	     * EngineScope attributes are visible during the lifetime of a single
	     * <code>ScriptEngine</code> and a set of attributes is maintained for each
	     * engine.
	     * GlobalScope attributes are visible to all engines created by same ScriptEngineFactory.
	     */
	    // ENGINE_SCOPE = 100;
	    // GLOBAL_SCOPE = 200;

		return context.getScopes();
	}
	
	/**
	 * 编译JS脚本
	 * @param script
	 * @return
	 * @throws ScriptException
	 */
	public static CompiledScript compile(String script) throws ScriptException {
		ScriptEngine engine = getJavaScriptEngine();
		if (engine instanceof Compilable) {
			CompiledScript compiledScript = ((Compilable) engine).compile(script);
			return compiledScript;
		}
		return null;
	}
	
}