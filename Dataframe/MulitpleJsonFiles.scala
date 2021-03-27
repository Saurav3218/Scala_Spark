package com.spark.dataframe.miscellaneous

import org.apache.spark.sql.SparkSession
import org.apache.spark.sql.types.{BooleanType, DoubleType, LongType, StringType, StructType}

object MulitpleJsonFiles extends App{

  val spark=SparkSession.builder().master("local[*]").appName("DataFrameExample").getOrCreate()

  spark.sparkContext.setLogLevel("ERROR")

  //read multiline json file
  val df1=spark.read.json("/Users/SauravKumar/Desktop/Data_Files_READ/Zipcode_Streaming/*")
  df1.printSchema()
  df1.explain(false)
  df1.show(false)

  //read multiline json file

  val df2=spark.read.json("/Users/SauravKumar/Desktop/Data_Files_READ/Zipcode_Streaming/zipcode1.json",
    "/Users/SauravKumar/Desktop/Data_Files_READ/Zipcode_Streaming/zipcode2.json")

  print("class name"+ df2.getClass)

  df2.printSchema()
  df2.show(false)

  //Define custom schema
  val schema1 = new StructType()
    .add("City", StringType, true)
    .add("Country", StringType, true)
    .add("Decommisioned", BooleanType, true)
    .add("EstimatedPopulation", LongType, true)
    .add("Lat", DoubleType, true)
    .add("Location", StringType, true)
    .add("LocationText", StringType, true)
    .add("LocationType", StringType, true)
    .add("Long", DoubleType, true)
    .add("Notes", StringType, true)
    .add("RecordNumber", LongType, true)
    .add("State", StringType, true)
    .add("TaxReturnsFiled", LongType, true)
    .add("TotalWages", LongType, true)
    .add("WorldRegion", StringType, true)
    .add("X-AXIS", DoubleType, true)
    .add("Yaxis", DoubleType, true)
    .add("Zaxis", DoubleType, true)
    .add("Zipcode", StringType, true)
    .add("ZipCodeType", StringType, true)


  val df4=spark.read.schema(schema1).json(
    "/Users/SauravKumar/Desktop/Data_Files_READ/Zipcode_Streaming/zipcode1.json",
    "/Users/SauravKumar/Desktop/Data_Files_READ/Zipcode_Streaming/zipcode2.json",
    "/Users/SauravKumar/Desktop/Data_Files_READ/Zipcode_Streaming/zipcode3.json"
  )

  df4.printSchema()
  df4.show(false)

  // create a view from a dataframe and registeredd as view name for sql type query.

  df4.createOrReplaceTempView("ZIPCODEDATA")

  val cityOutput=spark.sql("select * from ZIPCODEDATA where city='MESA'");
  cityOutput.show(false)
}
