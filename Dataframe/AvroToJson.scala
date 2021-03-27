package com.spark.dataframe.miscellaneous

import org.apache.spark.sql.{SaveMode, SparkSession}

object AvroToJson extends App {

  val spark=SparkSession.builder().master("local[*]").appName("DataFrameExample").getOrCreate()

  spark.sparkContext.setLogLevel("ERROR")

  /* Read AVRO FILE


   */

  val df =spark.read.format("avro")
    .option("header","true")
    .option("inferSchema","true")
    .load("/Users/SauravKumar/Desktop/Data_Files_READ/zipcodes.avro")
  df.printSchema()
  df.show()

  //convert to json
  df.write.mode(SaveMode.Overwrite)
    .json("/Users/SauravKumar/Desktop/Data_Files_Write/zipcodes.json")


}
