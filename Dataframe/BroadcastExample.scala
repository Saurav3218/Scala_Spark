package com.spark.dataframe.miscellaneous

import org.apache.spark.sql.SparkSession

object BroadcastExample extends App {

  val spark=SparkSession.builder().master("local[*]").appName("DataFrameExample").getOrCreate();

  val states = Map(("NY","New York"),("CA","California"),("FL","Florida"))

  val countries = Map(("USA","United States of America"),("IN","India"))

  val broadcastStates=spark.sparkContext.broadcast(states)
  val broadcastCountry=spark.sparkContext.broadcast(countries)

  val data = Seq(("James","Smith","USA","CA"),
    ("Michael","Rose","USA","NY"),
    ("Robert","Williams","USA","CA"),
    ("Maria","Jones","USA","FL")
  )

  val columns=Seq("firstname","lastname","country","state")

  import spark.sqlContext.implicits._

  val df = data.toDF(columns:_*)

  val df2=df.map(row=>{
    val country=row.getString(2)
    val state=row.getString(3)

    val fullcountry=broadcastCountry.value.get(country).get
    val fullstate=broadcastStates.value.get(state).get
    (row.getString(0),row.getString(1),fullcountry,fullstate)

  }).toDF(columns:_*)

  df2.show(false)

}
