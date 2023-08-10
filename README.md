# dotty compiler plugin issue

To reproduce the issue:

1. Clone this repo
2. `cd` into it
3. Run `sbt tests/compile`

You will see an error:

```scala
-- [E161] Naming Error: /Users/matt/dotty-compiler-plugin-issue/tests/src/main/scala/Test.scala:3:0
3 |object test {
  |^
  |test is already defined as object test in /Users/matt/dotty-compiler-plugin-issue/tests/src/main/scala/Test.scala
one error found
```
