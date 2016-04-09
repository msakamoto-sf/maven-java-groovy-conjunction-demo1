maven-java-groovy-conjunction-demo1
====================================

Maven Samples for Groovy and Java Conjunction Project.

### References

- [Groovy - The groovyc Ant Task](http://groovy.codehaus.org/The+groovyc+Ant+Task)
- [Maven AntRun Plugin](http://maven.apache.org/plugins/maven-antrun-plugin/)
- [GMaven](http://groovy.github.io/gmaven/) (not recomendded. GMaven 2.x no longer supports any integration for compilation of Groovy sources.)
- [Groovy Eclipse Maven plugin](https://github.com/groovy/groovy-eclipse/wiki/Groovy-Eclipse-Maven-plugin) (modern & latest at 2016-04)

sample1 : 00-only-groovy-antrun
------

- `*.groovy` code only.
- compile `*.groovy` by `groovyc` Ant-Task via maven-antrun-plugin.

sample2 : 00-only-groovy-gmaven
------

- `*.groovy` code only.
- compile `*.groovy` by GMaven's `groovy:compile`, `groovy:testCompile` goals.

sample3 : 01-groovy-refer-java-antrun
------

- includes `*.java` and `*.groovy` code.
- `*.groovy` refer `*.java` code.
- `*.java` does NOT  refer `*.groovy` code. No need for "conjunction" compilation:)
- compile `*.java` by default maven-compiler-plugin goals.
- compile `*.groovy` by `groovyc` Ant-Task via maven-antrun-plugin.

sample4 : 01-groovy-refer-java-gmaven
------

- includes `*.java` and `*.groovy` code.
- `*.groovy` refer `*.java` code.
- `*.java` does NOT  refer `*.groovy` code. No need for "conjunction" compilation:)
- compile `*.java` by default maven-compiler-plugin goals.
- compile `*.groovy` by GMaven's `groovy:compile`, `groovy:testCompile` goals.

sample5 : 02-java-refer-groovy-antrun
------

This integration pattern was **full of challenges**.

- includes `*.java` and `*.groovy` code.
- `*.groovy` refer `*.java` code.
- `*.java` **does refer** `*.groovy` code, **so we need "join compilation" !!**.
  * see [Joint Compilation document.](http://groovy.codehaus.org/The+groovyc+Ant+Task)
- **Disalbed default maven-compiler-plugin** (becauese nested `javac` task do it.)
- compile `*.groovy` by `groovyc` Ant-Task **with nested `javac` task**  via maven-antrun-plugin.
  * "joint compile" automatically generate Java "stub" codes for each `*.groovy` sources.
  * `*.java` sources and "stub" source codes are compiled by nested `javac` task.
  * finally, original `*.groovy` codes are compiled.

sample6 : 02-java-refer-groovy-gmaven
------

- includes `*.java` and `*.groovy` code.
- `*.groovy` refer `*.java` code.
- `*.java` **does refer** `*.groovy` code, **so we need "join compilation" !!**.
  * GMaven smartly supports "joint compilation".
- GMaven and maven-compile-plugin do : 
  1. GMaven generate Java stub files for `src/main/groovy` directory via `groovy:generateStubs` goal in `generate-sources` phase.
  2. `*.java` codes under `src/main/java` are compiled by maven-compile-plugin in `compile` phase with Java stub files.
  3. GMaven compiles `*.groovy` codes under `src/main/groovy` via `groovy:compile` golad in `compile` phase.
  4. In `generate-test-sources` phase, GMaven generate Java stub files for `src/test/groovy` directory by `groovy:generateTestStubs` goal.
  5. `*.java` codes under `src/test/java` are compiled by maven-compile-plugin in `test-compile` phase with Java stub files.
  6. GMaven compiles `*.groovy` codes under `src/test/groovy` via `groovy:testCompile` golad in `test-compile` phase.

sample7-9 : 00-only-groovy-201604, 01-groovy-refer-java-201604, 02-java-refer-groovy-201604
------

- compile `*.groovy` by Groovy Eclipse Maven plugin ( https://github.com/groovy/groovy-eclipse/wiki/Groovy-Eclipse-Maven-plugin ).

