# Create a new project

In a brand new directory do a gradle init. settings.gradle is the only file that should be required 
to be identified as a new project.

./gradle <task> --console=plain  gives a detailed task level output instead of gradle decided output

you can abbreviate tasks. ./gradlew :qualityCheckAll can be abbreviated as ./gradlew :qCA

also do not run a task without a colon. gradle will search for the name in all submodules and executes it
so ./gradlew qualityCheckAll is not a best practice. Instead do a ./gradlew :qualityCheckAll

buildSrc is a separate build whose purpose is to build any tasks, plugins, or other classes which are intended to be used in build scripts of the main build, but don't have to be shared across builds.(*) It wouldn't be possible to build such classes as part of the main build, because they have to exist before the main build's build scripts can even be compiled/evaluated, and Gradle compiles/evaluates all build scripts before it does any work (configuration vs. execution phase).

Compared to putting all build code into build scripts, buildSrc gives you a way to develop build code more like regular code, as classes that you can test, import into your IDE, etc. It is one way to keep build scripts simple and DRY even for more complicated builds.

buildSrc is more often seen in multi-project builds simply because larger builds are more likely to implement their own custom tasks and plugins.

Over time, buildSrc will grow into a more general capability of executing multiple dependent builds in a single Gradle invocation.

(*) Sharing classes across builds is possible but more involved. In particular, you'll need to publish the classes to a repository, and consuming builds have to explicitly import them from there, similar to when sharing production libraries between builds.

settings.gradle has the include section that lists the projects in the build

plugins provide different tasks that can be available to the project. 
for example, the java application plugin provides the application group tasks in which run is one of them so that you can use 
gradle :app:run if app is the subproject which has the java-application plugin added

also, the module which has java-application plugin added can use the application {} syntax to add the main class.

dependencies section in the gradle file gives the various other modules on which the current module is dependent on

if you run ./gradlew :app:tasks , gradle lists all the tasks that are available to run. It has a big list which is confusing to
the users. tasks itself is a task in gradle. so we can configure this task to list only a limited set of display groups.

we did this as part of the java base plugin. the same thing can be extended to the root level also. 

if we say ./gradlew :tasks the gradle system lists all the projects tasks. if any display groups are setup, those rules are 
followed as well. If we say ./gradlew :tasks --all , we get all the tasks that can be applied to all modules of the project.

if we want to configure the tasks displayed for the global project leve, we have to configure build.gradle at the root project leve.
the recommendation is to use the build.gradle file just for this purpose only

read about the difference between life cycle tasks and actionable tasks in gradle

actionable tasks work on the input and output. inputs and outputs tell gradle about the dependencies of the tasks.
incremental build is possible due to the gradle knowing about the inputs and outputs. if the inputs dont change, gradle can
get the results from the previous run or from build cache.

we try to do a actionable task in the project to build the application jar ourselves which is provided by gradle built in
ideally any actionable tasks should be tied up to lifecycle tasks and the end users should call only lifecycle tasks.

In our example, the task packageApp which is a clone of assemble should be tied up to build lifecycle

also check the usage of run.sh where we used lib/* for -cp input

https://docs.oracle.com/en/java/javase/21/docs/specs/man/java.html gives the provision of * for class path entires
