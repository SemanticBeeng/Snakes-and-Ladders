package com.knowscieng.jython.jsr223

import java.io._
import javax.script._


object PythonAge extends App {
  val scriptEngineManager = new ScriptEngineManager()
  val pyEngine = scriptEngineManager.getEngineByName("python")
  val engine = pyEngine.asInstanceOf[ScriptEngine with Invocable]
  engine.eval(new FileReader("python_utils.py"))
  val age = 9.0.asInstanceOf[AnyRef]
  val pythonAge = engine.invokeFunction("py_python_age", age)
  System.out.println(pythonAge.asInstanceOf[Double].round)
}