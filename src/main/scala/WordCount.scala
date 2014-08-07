import org.apache.spark.SparkContext
import org.apache.spark.SparkContext._
import org.apache.spark.SparkConf


object WordCount {
  def main(args: Array[String]){
    val sc = new SparkContext(new SparkConf().setAppName("Apache Spark WordCount"))

    val file = sc.textFile(args(0))
    
    val wordCounts = file.flatMap(line => line.split(" ")) 
                        .map(word => (word, 1)) 
                        .reduceByKey(_ + _)

    println(wordCounts.collect().mkString(","))
    //wordCounts.saveAsTextFile(args(1))
  }
}
