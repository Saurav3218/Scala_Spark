package com.spark.dataframe.miscellaneous

import org.apache.spark.sql.functions.col
import org.apache.spark.sql.types.{BooleanType, DateType, DoubleType, IntegerType, StringType, StructField, StructType}
import org.apache.spark.sql.{Row, SparkSession}

object CastColumnType {

  def main(args: Array[String]): Unit = {

    val spark = SparkSession.builder().master("local[*]").appName("DataFrameExample").getOrCreate()

    val simpleData = Seq(Row("James", 34, "2006-01-01", "true", "M", 3000.60),
      Row("Michael", 33, "1980-01-10", "true", "F", 3300.80),
      Row("Robert", 37, "06-01-1992", "false", "M", 5000.50)
    )

    println(simpleData.getClass)


    val simpleSchema = StructType(Array(
      StructField("firstName", StringType, true),
      StructField("age", IntegerType, true),
      StructField("jobStartDate", StringType, true),
      StructField("isGraduated", StringType, true),
      StructField("gender", StringType, true),
      StructField("salary", DoubleType, true)
    ))

    val df = spark.createDataFrame(spark.sparkContext.parallelize(simpleData), simpleSchema)
    /*df.printSchema()
    df.show(false)
*/

    val df2=df.withColumn("age",col("age").cast(StringType))
      .withColumn("isGraduated",col("isGraduated").cast(BooleanType))
      .withColumn(("jobStartDate"),col("jobStartDate").cast(DateType))

    df2.printSchema()
    df2.show(false)
    df2.createOrReplaceTempView("CastExample")
    val df4 = spark.sql("SELECT STRING(age),BOOLEAN(isGraduated), DATE(jobStartDate) from CastExample")
    df4.printSchema()
    df4.show(false)

  }
}
