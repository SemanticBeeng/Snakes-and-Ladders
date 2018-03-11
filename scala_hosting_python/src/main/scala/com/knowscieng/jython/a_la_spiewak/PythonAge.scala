package com.knowscieng.jython.a_la_spiewak


object PythonAge extends App with Scalathon {
  pythonImport("python_utils")
  val age: Double = 'py_python_age (Seq(9.0))
  println(age.round)
}