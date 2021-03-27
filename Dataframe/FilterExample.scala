package com.spark.dataframe.miscellaneous

import org.apache.spark.sql.functions.{array_contains, col}
import org.apache.spark.sql.types.{ArrayType, StringType, StructField, StructType}
import org.apache.spark.sql.{Row, SparkSession}

object FilterExample extends App {

  val spark=SparkSession.builder().master("local[*]").appName("DataFrameExample").getOrCreate()

  spark.sparkContext.setLogLevel("ERROR")

  val arrayStructureData = Seq(
    Row(Row("James","","Smith"),List("Java","Scala","C++"),"OH","M"),
    Row(Row("Anna","Rose",""),List("Spark","Java","C++"),"NY","F"),
    Row(Row("Julia","","Williams"),List("CSharp","VB"),"OH","F"),
    Row(Row("Maria","Anne","Jones"),List("CSharp","VB"),"NY","M"),
    Row(Row("Jen","Mary","Brown"),List("CSharp","VB"),"NY","M"),
    Row(Row("Mike","Mary","Williams"),List("Python","VB"),"OH","M")
  )

  val arrayStructureSchema=new StructType()
    .add("name",new StructType()
    .add("firstName",StringType)
    .add("middleName",StringType)
    .add("lastName",StringType))
    .add("languages",ArrayType(StringType))
    .add("state",StringType)
    .add("gender",StringType)

  val df=spark.createDataFrame(spark.sparkContext.parallelize(arrayStructureData),arrayStructureSchema)

  df.printSchema()
  df.show(false)

// Multiple filter columns

df.filter(col("gender")==='M' && col("state")==="NY").show(false)

  //Array condition
  df.filter(array_contains(col("languages"),"Java"))
    .show(false)

  //Struct condition

  df.filter(col("name.lastname") === "Williams")
    .show(false)



}
