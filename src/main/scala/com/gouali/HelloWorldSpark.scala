package com.gouali

import org.apache.spark.SparkContext

object HelloWorldSpark extends App {

  private val sparkContext = new SparkContext("local","Hello World")

  private val sourceRdd = sparkContext.textFile("C:\\BigData\\datasets\\sample_input.txt")
  sourceRdd.take(1).foreach(println)



}
