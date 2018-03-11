## How to Run

### Build and package module


```
sbt
> project scala_hosting_python
> package
```

To run PythonAge in all implementations:

```
. useJep.sh
export JAR=scala_hosting_python/target/scala-2.11/scala_hosting_python_2.11-0.1-SNAPSHOT.jar
```

```
scala -cp $JAR:$JEP_CP com.knowscieng.jepp.out_of_the_box.PythonAge
```

```
scala -cp $JAR:$JEP_CP com.knowscieng.jepp.a_la_spiewak.PythonAge
```

```
scala -cp $JAR:$JEP_CP com.knowscieng.jepp.applydynamic.PythonAge
```