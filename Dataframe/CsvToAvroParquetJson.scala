package com.spark.dataframe.miscellaneous

import org.apache.spark.sql.{SaveMode, SparkSession}

object CsvToAvroParquetJson extends App {

  val spark=SparkSession.builder().master("local[*]").appName("DataFrameExample").getOrCreate()

  spark.sparkContext.setLogLevel("ERROR")

  // Reading csv fle
  val df=spark.read.option("inferSchema","true")
    .option("header","true")
    .csv("/Users/SauravKumar/Desktop/Data_Files_READ/zipcodes.csv")

  df.printSchema()
  df.show(false)

  //convert to avro
  df.write.format("avro").mode(SaveMode.Overwrite)
    .save("/Users/SauravKumar/Desktop/Data_Files_Write/zipcodes_sk.avro")

  // convert to parquet

  df.write.format("parquet").mode(SaveMode.Overwrite)
    .save("/Users/SauravKumar/Desktop/Data_Files_Write/zipcodes_sk.parquet")

  // convert to json
  df.write.format("json").mode(SaveMode.Overwrite)
    .save("/Users/SauravKumar/Desktop/Data_Files_Write/zipcodes_sk.json")

}
