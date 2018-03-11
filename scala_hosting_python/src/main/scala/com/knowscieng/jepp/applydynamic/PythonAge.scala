package com.knowscieng.jepp.applydynamic

object PythonAge extends App {
  val pythonUtils = new PythonUtils
  val pythonAge: Double = pythonUtils.py_python_age(100.0)
  println(pythonAge.round)

}
