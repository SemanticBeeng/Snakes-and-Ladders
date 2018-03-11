package com.knowscieng.jepp.applydynamic

import com.knowscieng.Code
import jep.{Jep, JepException}

import scala.language.dynamics


class PythonUtils() extends scala.Dynamic {
  val jep = new Jep()
  try {
    jep.runScript(s"${Code.path}jepp/applydynamic/" + "python_utils.py")
  } catch {
    case e: JepException => println(e.getMessage())
  }

  def applyDynamic[R](name: String)(args: Any*): R = {

    val plist = new Array[String](args.length)
    for (i <- 0 until args.length) {
      plist(i) =
        args(i) match {
          case s: String => "'" + s + "'"
          case _ => args(i).toString()
        }
    }

    val str = "python_utils." + name + "(" + plist.reduceLeft[String](_ + ", " + _) + ")"
    jep.getValue(str).asInstanceOf[R]
  }
}
