package com.umkc.sparkML

import org.apache.spark.sql.SQLContext
import org.apache.spark.{SparkContext, SparkConf}

/**
 * Created by Venu on 7/20/15.
 */
object SparkScala {

  def main(args: Array[String]) {

    val conf = new SparkConf()
      .setAppName("SparkDataConversion")
      .set("spark.executor.memory", "2g").setMaster("local[*]")
    val sc = new SparkContext(conf)

    val sqlContext = new SQLContext(sc)

    val inputFileData = sc.textFile("src/main/resources/HospitalSurvey.csv")

    inputFileData.map(l=>l.split(",")(0)).collect().foreach(println)




/*
   // val inputFileData = sc.textFile("src/main/resources/HospitalJson.json").filter(l=>l.trim != "")

    val inputJsonFile = sqlContext.jsonFile("src/main/resources/HospitalJson.json")


    // val inputJsonFile = sqlContext.jsonRDD("src/main/resources/HospitalJson.json")

    inputJsonFile.registerTempTable("HospitalData")

    inputJsonFile.printSchema()
   // val HospitalData = sqlContext.sql("select ")*/
  }
}
