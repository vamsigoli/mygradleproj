package mygradleproj.tasks

import org.gradle.api.DefaultTask
import org.gradle.api.provider.Property
import org.gradle.api.tasks.Input
import org.gradle.api.tasks.OutputFile
import org.gradle.api.tasks.TaskAction

abstract class CreateAFileTask extends DefaultTask {
    @Input
    abstract Property<String> getFileText()

    @Input
    final String fileName = "myfile.txt"

    @OutputFile
    final File myFile = new File(fileName)

    @TaskAction
    void action() {
        myFile.createNewFile()
        myFile.text = fileText.get()

    }

}
