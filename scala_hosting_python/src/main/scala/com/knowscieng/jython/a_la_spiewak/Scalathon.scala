package com.knowscieng.jython.a_la_spiewak

import java.io._
import javax.script._

import scala.language.implicitConversions


trait Scalathon {

  val scriptEngineManager = new ScriptEngineManager()

  val engine = scriptEngineManager.getEngineByName("python")

  val invocableEngine = engine.asInstanceOf[ScriptEngine with Invocable]

  def pythonImport(scriptName: String) = {
    invocableEngine.eval(new FileReader("python_utils.py"));
  }

  implicit def sym2Method[R](sym: Symbol): (Any*) => R =
    new PyFunction[R](sym)

  class PyFunction[R](method: Symbol) extends ((Any*) => R) {

    def apply(params: Any*) = {
      val paramObjects = params.map(_.asInstanceOf[AnyRef])
      val result = invocableEngine.invokeFunction(sym2string(method), paramObjects: _*)
      result.asInstanceOf[R]
    }

    def sym2string(sym: Symbol) = {
      val back = sym.toString()
      back.substring(1, back.length())
    }

  }

}