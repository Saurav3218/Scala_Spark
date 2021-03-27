package com.spark_core.examples

import org.apache.spark.sql.SparkSession

object pairrdd extends App {
  val spark=SparkSession.builder().master("local[*]").appName("PairRdd").getOrCreate()
  spark.sparkContext.setLogLevel("Error")
  val  KeyWithValue=Array("foo=A","Goo=B","Coo=C","foo=A")
  val data=spark.sparkContext.parallelize(KeyWithValue)
  val kv = data.map(_.split("=")).map(v => (v(0), v(1))).cache()
  kv.foreach(println)

  val studentRDD = spark.sparkContext.parallelize(Array(
    ("Joseph", "Maths", 83), ("Joseph", "Physics", 74), ("Joseph", "Chemistry", 91), ("Joseph", "Biology", 82),
    ("Jimmy", "Maths", 69), ("Jimmy", "Physics", 62), ("Jimmy", "Chemistry", 97), ("Jimmy", "Biology", 80),
    ("Tina", "Maths", 78), ("Tina", "Physics", 73), ("Tina", "Chemistry", 68), ("Tina", "Biology", 87),
    ("Thomas", "Maths", 87), ("Thomas", "Physics", 93), ("Thomas", "Chemistry", 91), ("Thomas", "Biology", 74),
    ("Cory", "Maths", 56), ("Cory", "Physics", 65), ("Cory", "Chemistry", 71), ("Cory", "Biology", 68),
    ("Jackeline", "Maths", 86), ("Jackeline", "Physics", 62), ("Jackeline", "Chemistry", 75), ("Jackeline", "Biology", 83),
    ("Juan", "Maths", 63), ("Juan", "Physics", 69), ("Juan", "Chemistry", 64), ("Juan", "Biology", 60)), 3)

  val studentKey=studentRDD.map(f=>(f._1,(f._2,f._3)))
  studentKey.foreach(println)

  spark.stop()

}
