package com.br.poetexample.generator.utils

import com.squareup.kotlinpoet.TypeName
import com.squareup.kotlinpoet.asTypeName

fun String.toTypeName(): TypeName = when (this) {
    "kotlin.Long?" -> Long::class.asTypeName().copy(nullable = true)
    "kotlin.Long" -> Long::class.asTypeName()
    "kotlin.String?" -> String::class.asTypeName().copy(nullable = true)
    "kotlin.String" -> String::class.asTypeName()
    else -> throw IllegalArgumentException("Unsupported type: $this")
}
