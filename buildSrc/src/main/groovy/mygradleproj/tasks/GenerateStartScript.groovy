package mygradleproj.tasks

import org.gradle.api.DefaultTask
import org.gradle.api.file.RegularFileProperty
import org.gradle.api.provider.Property
import org.gradle.api.tasks.Input
import org.gradle.api.tasks.OutputFile
import org.gradle.api.tasks.TaskAction

abstract class GenerateStartScript extends DefaultTask {

    @Input
    abstract Property<String> getMainClass()

    @OutputFile
    abstract RegularFileProperty getScriptFile()

    @TaskAction
    void generate() {
        def mainClassStr = mainClass.get()
        def out = scriptFile.get().asFile

        println "the main class string is ${mainClassStr}"
        def script = "java -cp \'libs/*\' ${mainClassStr}"
        def scriptCode = script.toString()
        println "the script file is ${out}"
        out.write(scriptCode)
    }

}
