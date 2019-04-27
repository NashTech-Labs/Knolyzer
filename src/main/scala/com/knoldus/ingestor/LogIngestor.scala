package com.knoldus.ingestor

import scala.sys.process._

object LogIngestor extends App {

  def someProcessing(line: String): Unit = {
    // do whatever you want with that line
    print("[just read this line] ")
    println(line)
  }

  // the file to read
  val file = "mylogfile.txt"

  // the process to start
  val tail = Seq("tail", "-f", file)

  // continuously read lines from tail -f
  tail.lineStream.foreach(someProcessing)
  // careful: this never returns (unless tail is externally killed)

}
