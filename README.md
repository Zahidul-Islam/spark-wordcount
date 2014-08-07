#Apache Spark WordCount demo
A simple Spark application  that counts the number of occurences of each word in a given input file.

##Write WordCount app
The source code for wordcount app is available on [github](https://github.com/Zahidul-Islam/spark-wordcount).
For sbt to work correctly, we’ll need to layout out app according to the typical directory structure.

```
# Directory structure should look like this
$ find .
.
./build.sbt
./src
./src/main
./src/main/scala
./src/main/scala/WordCount.scala
```


##Building the App

To package a jar containing WordCount application, we use `sbt package` command:

```
$ cd ~/spark-wordcount
$ sbt package
```

##Running the app
To run the Spark program, we use the ***spark-submit*** script:
 
```
$ YOUR_SPARK_HOME/bin/spark-submit \
--class "WordCount" \
--master local \
target/scala-2.10/apache-spark-wordcount_2.10-1.0.jar <input file>      
```

> You’ll need to replace YOUR_SPARK_HOME with the location where Spark is installed in your machine.


This will run the application in a single local process. If the cluster is running a Spark standalone cluster manager, you can replace `--master local` with `--master spark://<master host>:<master port>`.

The output of the program should look something like this:

```
(Programs,1),(gladly,1),(agree,1),(cluster.,1),(have,2),(under,2),(legal,1)