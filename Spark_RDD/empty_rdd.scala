package com.spark_core.examples

import org.apache.spark.sql.SparkSession

object CreateEmptyRdd extends App {

  val spark=SparkSession.builder().master("local[*]").appName("EmptyRdd").getOrCreate()

  val rdd1=spark.sparkContext.emptyRDD
  val rddstring=spark.sparkContext.emptyRDD[String]
  println(rdd1)
  println(rddstring)
  println("Num of Partitions: "+rdd1.getNumPartitions)
  rddstring.saveAsTextFile("/Users/SauravKumar/Desktop/empty_rdd2.txt")

  // Pair RDD

  type dataType = (String,Int)
  var pairRDD = spark.sparkContext.emptyRDD[dataType]
  println(pairRDD)

}
