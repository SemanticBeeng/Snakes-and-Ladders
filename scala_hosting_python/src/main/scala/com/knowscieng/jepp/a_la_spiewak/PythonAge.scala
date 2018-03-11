package com.knowscieng.jepp.a_la_spiewak

import com.knowscieng.Code

import scala.language.implicitConversions


object PythonAge extends App with Scalathon {
  pythonImport(s"${Code.path}jepp/a_la_spiewak/" + "python_utils")
  val pythonAge: Double = 'py_python_age (Seq(9.0))
  println(pythonAge.round)
}
