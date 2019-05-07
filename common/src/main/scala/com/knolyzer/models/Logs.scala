package com.knolyzer.models

import java.io.File


case class RawLog(file: File)

case class LogMeta(rawLog: RawLog, meta: Map[String, String])