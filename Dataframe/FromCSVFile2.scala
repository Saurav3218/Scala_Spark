package com.spark.dataframe.miscellaneous

import org.apache.spark.sql.SparkSession
import org.apache.spark.sql.functions.col

object FromCSVFile2 extends App{

  val spark=SparkSession.builder().master("local[*]").appName("DataFrameExample").getOrCreate()

  val df=spark.read.option("header","true")
    .option("inferSchema","true")
    .csv("/Users/SauravKumar/Desktop/Data_Files_READ/zipcodes.csv")

  df.printSchema()
  df.show(false)


  val df2=spark.read.option("header","true")
    .option("inferSchema","true")
    .option("delimiter","|")
    .csv("/Users/SauravKumar/Desktop/Data_Files_READ/stream.csv")


  df2.show(false)

  val df3=df2.select("TotalCost","BirthDate","Gender","TotalChildren","ProductCategoryName")
    .filter(col("ProductCategoryName")==="Car" && (col("TotalChildren")).isNotNull)
    //.filter((col("TotalChildren")).isNotNull)

  df3.show(false)


println("Where StateMent ***************************")

  df2.select("Gender", "BirthDate", "TotalCost", "TotalChildren", "ProductCategoryName")
    .where(col("Gender").isNotNull && col("BirthDate").isNotNull && col("TotalChildren").isNotNull &&
      col("ProductCategoryName").isNotNull ).show(false)

}
