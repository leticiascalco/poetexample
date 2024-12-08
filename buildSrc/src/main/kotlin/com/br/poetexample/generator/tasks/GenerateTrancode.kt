package com.br.poetexample.generator.tasks

import com.br.poetexample.generator.builder.buildTrancodeClass
import com.br.poetexample.generator.schema.Schema
import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import com.fasterxml.jackson.module.kotlin.readValue
import com.squareup.kotlinpoet.FileSpec
import org.gradle.api.DefaultTask
import org.gradle.api.tasks.TaskAction
import java.io.File

abstract class GenerateTrancode : DefaultTask() {

    @TaskAction
    fun generate() {
        val objectMapper = jacksonObjectMapper()
        val inputDir = File("${project.projectDir}/src/main/resources/templates")
        val outputDir = File("${project.projectDir}/src/main/kotlin/com/br/poetexample/application/core/dto")

        if (!outputDir.exists()) {
            outputDir.mkdirs()
        }

        inputDir.listFiles()?.forEach { file ->
            if (file.extension == "json") {

                val schema: Schema = objectMapper.readValue(file)

                val className = schema.`class`
                val packageName = "com.br.poetexample.application.core.dto"

                val fileSpec = FileSpec.builder(packageName, className)
                schema.formats.forEach { format ->
                    fileSpec.addType(buildTrancodeClass(format))
                }

                val targetFile = File(outputDir, "$className.kt")
                targetFile.writeText(fileSpec.build().toString())
            }
        }
    }
}
