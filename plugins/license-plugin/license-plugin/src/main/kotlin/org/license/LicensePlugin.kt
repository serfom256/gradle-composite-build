package org.license

import org.gradle.api.Project
import org.gradle.api.Plugin
import org.gradle.api.DefaultTask
import org.gradle.api.tasks.Input
import org.gradle.api.tasks.TaskAction
import java.io.File
import java.io.InputStream
import java.nio.charset.Charset


class LicensePlugin: Plugin<Project> {
    override fun apply(project: Project) {
        project.tasks.register("license", LicenseTask::class.java) { task -> // You have to specify task group and description
            task.description = "add a license header to source code" 
            task.group = "license plugin"
        }
    }
}

abstract class LicenseTask : DefaultTask() {
    @Input
    val licenseFile = project.layout.settingsDirectory.asFile.path

    @TaskAction
    fun action() {
        println(File(licenseFile).parentFile)
        val licenseText = File(File(licenseFile).parentFile, "plugin-license.txt").readText()
        project.layout.settingsDirectory.asFile.walk().forEach {
            if (it.extension == "java") {
                var ins: InputStream = it.inputStream()
                var content = ins.readBytes().toString(Charset.defaultCharset())
                if(!content.startsWith(licenseText)){
                    it.writeText(licenseText + content)
                }
            }
        }
    }
}
