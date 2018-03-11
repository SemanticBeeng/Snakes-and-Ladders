package com.knowscieng.jepp.advanced

import java.sql.Timestamp

import com.knowscieng.Code
import com.knowscieng.jepp.a_la_spiewak.Scalathon


object AdvancedPythonAndR extends App with Scalathon {

  pythonImport(s"${Code.path}jepp/advanced/" + "ts_test")

  {
    val res: String = 'using_pandas (Seq("iris"))
    println(s"Res 1  $res")
  }

  {
    val res: Long = 'using_rstats (Seq.empty)
    println(s"Res 2 $res")
  }

  {
    val res: String = 'using_rpy2 (Seq.empty)
    println(s"Res 3 $res")
  }
}
