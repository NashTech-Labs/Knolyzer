package com.knolyzer.parser

import com.knolyzer.models.Log
import java.io.File
import scala.util.Try

trait LogParser {

  /**
    * Parses all arguments passed inside args into a key-val Map and then transforms it into a Log model
    * @param args
    * @return
    */
  private def argsAsMap(args: Array[String]): Map[String, String] = {

    val map = scala.collection.mutable.Map.empty[String, String]
    args.map { arg =>
      arg.split("=").toList match {
        case key::value::Nil => map += key -> value
        case _ => throw new IllegalArgumentException("Arguments should be provided in {key=val} format")
      }
    }
    map.toList.toMap
  }

  def parse(args: Array[String]): Option[Log] = {
    val argsMap = argsAsMap(args)
    for {
     logPath <- argsMap.get("log")
     topic <- argsMap.get("topic")
    } yield Log(logPath, argsMap, topic)
  }
}
