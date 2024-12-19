# Create a new project

In a brand new directory do a gradle init. settings.gradle is the only file that should be required 
to be identified as a new project.



buildSrc is a separate build whose purpose is to build any tasks, plugins, or other classes which are intended to be used in build scripts of the main build, but don't have to be shared across builds.(*) It wouldn't be possible to build such classes as part of the main build, because they have to exist before the main build's build scripts can even be compiled/evaluated, and Gradle compiles/evaluates all build scripts before it does any work (configuration vs. execution phase).

Compared to putting all build code into build scripts, buildSrc gives you a way to develop build code more like regular code, as classes that you can test, import into your IDE, etc. It is one way to keep build scripts simple and DRY even for more complicated builds.

buildSrc is more often seen in multi-project builds simply because larger builds are more likely to implement their own custom tasks and plugins.

Over time, buildSrc will grow into a more general capability of executing multiple dependent builds in a single Gradle invocation.

(*) Sharing classes across builds is possible but more involved. In particular, you'll need to publish the classes to a repository, and consuming builds have to explicitly import them from there, similar to when sharing production libraries between builds.
  