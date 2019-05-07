package com.knolyzer.parser

import org.scalatest.{FlatSpec, Matchers}

class LogParserSpec extends FlatSpec with Matchers {

  "LogParser" should "parse log and populate the Log model" in {
    val parser = new LogParser {}
    val args = Array("log=resources/example.log", "topic=MagAD", "key1=value1", "key2=value2")

    val log = parser.parse(args)

    log.get.topic shouldBe "MagAD"
    log.get.filePath shouldBe "resources/example.log"
    log.get.meta.contains("key1") should be(true)
    log.get.meta.contains("key2") should be(true)

  }

  "LogParser" should "throw an exception if args are not in format {key=value}" in {
    val parser = new LogParser {}
    val args = Array("invalidkey")

    val exception = intercept[IllegalArgumentException] {
      parser.parse(args)
    }

    exception.getMessage should be("Arguments should be provided in {key=val} format")

  }
}
