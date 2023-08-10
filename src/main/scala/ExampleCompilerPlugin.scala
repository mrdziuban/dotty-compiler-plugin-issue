package com.example

import dotty.tools.dotc.core.Contexts.Context
import dotty.tools.dotc.plugins.{PluginPhase, StandardPlugin}

class ExampleCompilerPlugin extends StandardPlugin { self =>
  val name = "example"
  val description = name

  override def init(opts: List[String]): List[PluginPhase] = List(Phase())

  class Phase extends PluginPhase {
    override val phaseName = self.name
    override val runsAfter = Set("typer")

    override def run(using Context): Unit = {
      println(s"********* running example compiler plugin")
      super.run
    }
  }
}
