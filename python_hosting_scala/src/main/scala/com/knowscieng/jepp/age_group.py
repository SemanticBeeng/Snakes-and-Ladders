from com.knowscieng.jepp.sclaython import *

ageGroup = ScalaUtils.ageGroupMethod(21.0)
print(ageGroup + 1)

ages = ScalaUtils.ages()
print(ages.head().toString())

people = ScalaUtils.people()
print(people)
