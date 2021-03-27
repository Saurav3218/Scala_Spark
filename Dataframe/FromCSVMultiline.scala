package com.spark.dataframe.miscellaneous

import org.apache.spark.sql.SparkSession

object FromCSVMultiline extends App{

  val spark=SparkSession.builder().master("local[*]").appName("DataFrameExample").getOrCreate()

  val df=spark.read
    .option("header","true")
    .option("inferSchema","true")
    //.option("multiLine","true")
    .csv("/Users/SauravKumar/Desktop/Data_Files_READ/address-multiline.csv")

  df.printSchema()
  df.show(false)

}
