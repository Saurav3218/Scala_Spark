package com.spark.rdd.examples

import org.apache.spark.sql.types.{ArrayType, StringType, StructType}
import org.apache.spark.sql.{Row, SparkSession}

object ArrayToColumn extends App {

  val spark=SparkSession.builder().master("local[*]").appName("DataFrameExample").getOrCreate()

  val arayData=Seq(
    Row("Saurav",List("PYTHON","SPARK","HIVE")),
      Row("Gaurav",List("Angular","HTML5","CSS")),
      Row("Diwakar",List("PYTHON","AWS","AZURE")),
      Row("Siddharth",List("Cassandra","KAFKA","SPARK"))
    )

    val arraySchema=new StructType().add("name",StringType).add("Subjects",ArrayType(StringType))

  val arrayDF=spark.createDataFrame(spark.sparkContext.parallelize(arayData),arraySchema)
  arrayDF.printSchema()
  arrayDF.show(false)
  arrayDF.explain(false)
}
