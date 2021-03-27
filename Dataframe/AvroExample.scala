package com.spark.dataframe.miscellaneous

import org.apache.log4j.Logger
import org.apache.spark.sql.SparkSession

object AvroExample {

  @transient lazy val logger: Logger = Logger.getLogger(getClass.getName)

  def main(args: Array[String]): Unit = {

    logger.info("Starting Spark Application")
    val spark=SparkSession.builder().master("local[*]").appName("DataFrameExample").getOrCreate()
    val data = Seq(("James ", "", "Smith", 2018, 1, "M", 3000),
      ("Michael ", "Rose", "", 2010, 3, "M", 4000),
      ("Robert ", "", "Williams", 2010, 3, "M", 4000),
      ("Maria ", "Anne", "Jones", 2005, 5, "F", 4000),
      ("Jen", "Mary", "Brown", 2010, 7, "", -1)
    )
    val columns = Seq("firstname", "middlename", "lastname", "dob_year",
      "dob_month", "gender", "salary")
    import spark.sqlContext.implicits._
    val df = data.toDF(columns: _*)
    /**
     * Write Avro File
     */
    val df2=df.write
      .partitionBy("dob_year")
      //.bucketBy(2,"gender")
      .format("parquet")
      .mode(saveMode = "Overwrite")
      .save("/Users/SauravKumar/Desktop/Avro_File/person_details.parquet")
      // In save doesnot support bucketBy option.
    /*
    Exception in thread "main" org.apache.spark.sql.AnalysisException: 'save' does not support bucketBy right now;

     */

// vvi point
    //Exception in thread "main" org.apache.spark.sql.AnalysisException: bucketing column 'dob_year' should not be part of partition columns 'dob_year, dob_month';

    //Avro Read file
  val paequetRead=spark.read.format("parquet").load("/Users/SauravKumar/Desktop/Avro_File/person_details.parquet")
    paequetRead.printSchema()
    paequetRead.show(false)


 /*val df3=spark.sql("select * from persondata_new_parquet")
    df3.printSchema()
    df3.show(false)*/



    logger.info("Closing Spark Application")
    spark.stop()
  }



}
