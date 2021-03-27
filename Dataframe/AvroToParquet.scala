package com.spark.dataframe.miscellaneous

import com.spark.dataframe.miscellaneous.AvroToJson.spark
import org.apache.spark.sql.{SaveMode, SparkSession}

object AvroToParquet extends App{

  val spark=SparkSession.builder().master("local[*]").appName("DataFrameExample").getOrCreate()

  spark.sparkContext.setLogLevel("ERROR")

  /* Read AVRO FILE


   */

  val df1 =spark.read.format("avro")
   // .option("header","true")
   // .option("inferSchema","true")
    .load("/Users/SauravKumar/Desktop/Data_Files_READ/zipcodes.avro")
  df1.printSchema()
  df1.show()

  /* Write the Avro file in Parquet */

  df1.write.mode(SaveMode.Overwrite)
    .partitionBy("ZipCodeType")
    .parquet("/Users/SauravKumar/Desktop/Data_Files_Write/zipcodes.parquet")

  spark.stop()


}
