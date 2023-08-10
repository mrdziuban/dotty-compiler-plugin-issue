# dotty compiler plugin issue

To reproduce the issue:

1. Clone this repo
2. `cd` into it
3. Run `sbt package` to build the compiler plugin
4. Run `scala -Xplugin:target/scala-3.3.0/example-compiler-plugin_3-0.1.0-SNAPSHOT.jar`
5. Within the scala REPL evaluate two statements, e.g.
    1. `val x = 1`
    2. `val y = 2`

When you evaluate the second statement you will see an error:

```
Exception in thread "main" java.lang.AssertionError: assertion failed: phase example has already been used once; cannot be reused
  at scala.runtime.Scala3RunTime$.assertFailed(Scala3RunTime.scala:8)
  at dotty.tools.dotc.core.Phases$Phase.init(Phases.scala:403)
  at dotty.tools.dotc.core.Phases$Phase.init(Phases.scala:417)
  at dotty.tools.dotc.core.Phases$PhasesBase.usePhases(Phases.scala:168)
  at dotty.tools.dotc.core.Phases$PhasesBase.usePhases$(Phases.scala:37)
  at dotty.tools.dotc.core.Contexts$ContextBase.usePhases(Contexts.scala:836)
  at dotty.tools.dotc.Run.compileUnits$$anonfun$1(Run.scala:232)
  at dotty.tools.dotc.Run.compileUnits$$anonfun$adapted$1(Run.scala:280)
  at dotty.tools.dotc.util.Stats$.maybeMonitored(Stats.scala:67)
  at dotty.tools.dotc.Run.compileUnits(Run.scala:280)
  at dotty.tools.dotc.Run.compileUnits(Run.scala:201)
  at dotty.tools.repl.ReplCompiler.compile(ReplCompiler.scala:87)
  at dotty.tools.repl.ReplDriver.compile(ReplDriver.scala:307)
  at dotty.tools.repl.ReplDriver.interpret(ReplDriver.scala:269)
  at dotty.tools.repl.ReplDriver.loop$1(ReplDriver.scala:169)
  at dotty.tools.repl.ReplDriver.runUntilQuit$$anonfun$1(ReplDriver.scala:172)
  at dotty.tools.repl.ReplDriver.withRedirectedOutput(ReplDriver.scala:211)
  at dotty.tools.repl.ReplDriver.runBody$$anonfun$1(ReplDriver.scala:185)
  at dotty.tools.runner.ScalaClassLoader$.asContext(ScalaClassLoader.scala:80)
  at dotty.tools.repl.ReplDriver.runBody(ReplDriver.scala:185)
  at dotty.tools.repl.ReplDriver.runUntilQuit(ReplDriver.scala:172)
  at dotty.tools.repl.ReplDriver.tryRunning(ReplDriver.scala:134)
  at dotty.tools.repl.Main$.main(Main.scala:7)
  at dotty.tools.MainGenericRunner$.run$1(MainGenericRunner.scala:193)
  at dotty.tools.MainGenericRunner$.process(MainGenericRunner.scala:270)
  at dotty.tools.MainGenericRunner$.main(MainGenericRunner.scala:281)
  at dotty.tools.MainGenericRunner.main(MainGenericRunner.scala)
```
