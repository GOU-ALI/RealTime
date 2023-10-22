package com.gouali

import org.apache.log4j.{Level, Logger}
import org.apache.spark.{SparkConf, SparkContext}

object FirstOwnerYamahaBikes extends App {
  Logger.getLogger("org").setLevel(Level.ERROR)

  // 1- set the SparkContext
  // Set the SparkContext
  private val conf = new SparkConf().setAppName("FirstOwnerYamahaBikes").setMaster("local")
  val sparkContext = new SparkContext(conf)
  // 2- read the csv file

  private val sourceBikesRdd = sparkContext.textFile("src/main/resources/Used_Bikes.csv")

  // 3- apply the use case logic
  private val splittedRdd = sourceBikesRdd.map(line => line.split(",").map(_.trim))

  private val resultRdd = splittedRdd.filter(bike => bike(4).equalsIgnoreCase("First Owner")
    && bike(6).toDouble > 150 && bike(7).equalsIgnoreCase("Yamaha"))

  // 4- write the dataset
  resultRdd.map(bike => (bike(0),bike(4))).distinct().foreach(println)

  println("Count of the final datasets : " + resultRdd.count())
}
