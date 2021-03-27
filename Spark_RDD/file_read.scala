package com.spark_core.examples

import org.apache.spark.sql.SparkSession

object Demo2 {

  def main(args: Array[String]): Unit = {
    val spark=SparkSession.builder().master("local[*]").appName("FirstDataFrame").getOrCreate()
    val c=spark.read.option("header","true").option("inferSchema","true")
      .csv("/Users/SauravKumar/Desktop/Scala_Saurav/src/main/resources/movies.csv").toDF()
    c.show(4)
    c.explain(true) // This will create the whole execution plan
spark.stop()
  }

}
