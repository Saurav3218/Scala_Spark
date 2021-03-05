package com.spark_core.examples

import org.apache.spark.sql.SparkSession

object CreateEmptyRdd extends App {

  val spark=SparkSession.builder().master("local[*]").appName("EmptyRdd").getOrCreate()

  val rdd1=spark.sparkContext.emptyRDD
  val rddstring=spark.sparkContext.emptyRDD[String]
  println(rdd1)
  println(rddstring)
  println("Num of Partitions: "+rdd1.getNumPartitions)

}
