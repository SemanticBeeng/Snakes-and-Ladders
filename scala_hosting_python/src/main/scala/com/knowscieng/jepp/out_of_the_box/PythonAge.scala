package com.knowscieng.jepp.out_of_the_box

import com.knowscieng.Code
import jep.Jep


object PythonAge extends App {

  val jep = new Jep()
  jep.runScript(s"${Code.path}jepp/out_of_the_box/" + "python_utils.py")

  val age = (9.0).asInstanceOf[AnyRef]

  val pythonAge = jep.invoke("py_python_age", age)

  println(pythonAge.asInstanceOf[Double].round)
}
