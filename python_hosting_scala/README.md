## How to Run

### Build and package module


```
sbt
> project python_hosting_scala
> package
```

To run PythonAge in all implementations:

```
. useJep.sh
export JAR=python_hosting_scala/target/scala-2.11/python_hosting_scala_2.11-0.1-SNAPSHOT.jar
export CODE_PATH=python_hosting_scala/src/main/scala/com/knowscieng
```

```
java -cp $JAR:$JEP_CP:/usr/share/scala/lib/scala-library.jar jep.Run $CODE_PATH/jepp/age_group.py
```

```
scala -cp $JAR:$JEP_CP $CODE_PATH/jython/age_group.py
```

```
scala -cp $JAR:$JEP_CP $CODE_PATH/jcc/age_group.py
```

```
scala -cp $JAR:$JEP_CP $CODE_PATH/jpype/age_group.py
```

