package com.knoldus

import org.scalatest.FunSuite
import scala.concurrent.duration._
import scala.concurrent.duration.Duration
import scala.concurrent.{Await, Future}

/**
  * Created by knoldus on 2/2/17.
  */
class FileCountTest extends FunSuite {
  val obj = new FileCount
  val obj1 = new FileCount
  val obj2 = new FileCount
  test("No. of files") {
    assert((Await.result(obj.getListOfFiles("/home/knoldus/src/"), 10.second)).length == 3)
  }

  test("Empty Directory") {
    assert(Await.result(obj1.getListOfFiles("/home/knoldus/Music"), Duration.Inf) == Nil)
  }
  
  test("Directory Not Found") {
    assert(Await.result(obj1.getListOfFiles("/home/knoldus/Music1"), Duration.Inf) == Nil)
  }
}