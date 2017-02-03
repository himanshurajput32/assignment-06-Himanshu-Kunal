package com.knoldus

import java.io.File
import scala.concurrent.ExecutionContext.Implicits.global
import scala.collection.mutable.ListBuffer
import scala.concurrent.Future


class FileCount {

  val result = new ListBuffer[File]

  def getListOfFiles(path: String): Future[List[File]] = Future {
    val file = new File(path)
    if (file.exists && file.isDirectory) {
      countFiles(file)
    }
    result.toList
  }

  def countFiles(f: File): List[File] = {
    for (ls <- f.listFiles.toList) {
      if (ls.isFile) {
        result += ls
      }
      else if (ls.isDirectory) {
        countFiles(ls)
      }
    }
    result.toList
  }

}




