package com.knowscieng.jepp.sclaython

object ScalaUtils {

 case class Person(firstName: String, lastName: String) 

 def reptileAgeGroupFunctionMaker (reptileAgeFunction: (Double) => Double) =
   reptileAgeFunction.andThen(ageGroupFunction)
 
 val ageGroupFunction = (age:Double) => {
   if (age <= 19)
     1
   else if (age <= 55)
     2
   else 
     3
  }

 def ageGroupMethod(age:Double):Int = ageGroupFunction(age)      

 val ages = collection.immutable.ListMap("Python" -> 21.0,
 	                                     "Scala" -> 9.0)

 val people = List(Person("Joe", "Smith"), Person("Ana", "Smith"))
}

