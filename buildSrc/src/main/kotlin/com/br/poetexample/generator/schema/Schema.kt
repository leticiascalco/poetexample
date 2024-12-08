package com.br.poetexample.generator.schema

data class Schema(
    val `class`: String,
    val formats: List<Format>
)

data class Format(
    val name: String,
    val fields: List<Field>
)

data class Field(
    val name: String,
    val dataType: String,
    val length: Int
)
