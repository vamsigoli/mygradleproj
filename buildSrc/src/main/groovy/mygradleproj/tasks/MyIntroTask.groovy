package mygradleproj.tasks

import org.gradle.api.DefaultTask
import org.gradle.api.tasks.TaskAction

abstract class MyIntroTask extends DefaultTask {

    @TaskAction
    void calculateSum() {
        int num1 = 5;
        int num2 = 7;

        int sum = num1 + num2;

        println "Sum : $sum"
    }
}
