package com.umkc.sparkML

import java.io.{FileWriter, BufferedWriter, File}

import scala.io.Source

/**
 * Created by Venu on 7/20/15.
 */
object SparkConversion {

  def main(args: Array[String]) {

    val filename  = "src/main/resources/HospitalSurvey.csv"

    val hospitalFile = new File("Hospital.dat")

    val ratingsFile = new File("Ratings.dat")

    val bhwriter = new BufferedWriter(new FileWriter(hospitalFile))

    val brwriter = new BufferedWriter(new FileWriter(ratingsFile))

    for( line <- Source.fromFile(filename).getLines()){

      val words =line.split(",").distinct

      if(words.size > 2){
        val fileLine = words(0)+"::"+words(1)+"::"+words(2)

        bhwriter.write(fileLine+"\n")
      }
      //words.collect().foreach()


    }

  }

}
