package com.br.poetexample.generator.builder

import com.br.poetexample.generator.schema.Format
import com.br.poetexample.generator.utils.toTypeName
import com.squareup.kotlinpoet.*

fun buildTrancodeClass(format: Format): TypeSpec {
    val classBuilder = TypeSpec.classBuilder(format.name)
        .addModifiers(KModifier.DATA)
        .primaryConstructor(
            FunSpec.constructorBuilder()
                .apply {
                    format.fields.forEach { field ->
                        addParameter(
                            ParameterSpec.builder(field.name, field.dataType.toTypeName())
                                .build()
                        )
                    }
                }
                .build()
        )

    format.fields.forEach { field ->
        classBuilder.addProperty(
            PropertySpec.builder(field.name, field.dataType.toTypeName())
                .initializer(field.name)
                .build()
        )
    }

    classBuilder.addFunction(
        FunSpec.builder("toFormattedString")
            .returns(String::class)
            .addCode(
                buildString {
                    append("return buildString {\n")
                    format.fields.forEach { field ->
                        val defaultValue = if (field.dataType.contains("Long")) {
                            "\"0\".repeat(${field.length})"
                        } else {
                            "\"${" ".repeat(field.length)}\""
                        }
                        append("append(${field.name}?.toString()?.padStart(${field.length}, '0') ?: $defaultValue)\n")
                    }
                    append("}")
                }
            )
            .build()
    )

    return classBuilder.build()
}
