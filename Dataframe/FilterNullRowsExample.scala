package com.spark.dataframe.miscellaneous

import org.apache.spark.sql.SparkSession
import org.apache.spark.sql.functions.col

object FilterNullRowsExample extends App {

  val spark=SparkSession.builder().master("local[*]").appName("DataFrameExample").getOrCreate()

  spark.sparkContext.setLogLevel("ERROR")

  val data = Seq(
    ("James",null,"M"),
    ("Anna","NY","F"),
    ("Julia",null,null),
    ("Saurav","Bihar","M")
  )

  import spark.sqlContext.implicits._
  val columns=Seq("name","state","gender")

  val df=data.toDF(columns:_*)

  df.printSchema()
  df.show(false)

  //filter

  df.filter("state is NOT NULL").show(false)
//
  df.filter(col("state").isNotNull).show(false)
//
  df.filter("state is NULL AND gender is NULL").show(false)

  df.createOrReplaceTempView("DATA")

  println("Spark SQL Example")
  spark.sql("Select * from DATA where state is not null and gender is not null").show(false)

}
