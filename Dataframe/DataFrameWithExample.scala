package com.spark.dataframe.miscellaneous

import com.spark.dataframe.miscellaneous.CsvToAvroParquetJson.spark
import org.apache.spark.sql.SparkSession
import org.apache.spark.sql.functions.{col, when}

object DataFrameWithExample {

  def main(args: Array[String]): Unit = {

    val spark=SparkSession.builder().master("local[*]").appName("DataFrameExample").getOrCreate()

    spark.sparkContext.setLogLevel("ERROR")

    // Reading csv fle
    val df=spark.read.option("inferSchema","true")
      .option("header","true")
      .csv("/Users/SauravKumar/Desktop/Data_Files_READ/zipcodes.csv")

    df.printSchema()

    // Where in dataframe

 df.select("RecordNumber").where(col("ZipCodeType")==="STANDARD").sort("RecordNumber").show(false)

    //[1][2][10][61392][61393][4][39827][39828][49345][49347][10][3][54355][54356][76511][76512] collect().foreach(a=>print(a.toString()))

    //Filter
    df.filter(col("State")==="PR").select("State","City","zipcode").show(false)
    // == not working for matching === used here for equal

    // Distinct

    df.select("City").distinct().show(false)

    // total count

    println("Number of records " +df.count())
    //where with and and or conditions
  df.where(col("State")==="PR" && col("City").contains("DEL")).show(false)

    //Order or Sort by in this example it will fetch all columns and desc and asc happended only for mentioned below columns.


    df.orderBy(col("RecordNumber").desc,col("State").asc).show(false)



  }

}
