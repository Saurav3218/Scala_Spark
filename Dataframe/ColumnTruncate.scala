package com.spark.dataframe.miscellaneous

import org.apache.spark.sql.SparkSession

object ColumnTruncate {

  def main(args: Array[String]): Unit = {

    val spark=SparkSession.builder().master("local[*]").appName("DataFrameExample").getOrCreate()

    import spark.sqlContext.implicits._
    val data = Seq(("1", "Be the change that you wish to see in the world"),
      ("2", "Everyone thinks of changing the world, but no one thinks of changing himself."),
      ("3", "The purpose of our lives is to be happy."))

    val columns=Seq("Seqno.","Quote")

    val df=data.toDF(columns:_*)

    df.show()// In this record will be truncated by default its true.
    df.show(false) // Record won't be truncated.

  }
}
