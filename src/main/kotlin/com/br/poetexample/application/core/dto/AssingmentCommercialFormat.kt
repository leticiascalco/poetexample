package com.br.poetexample.application.core.dto

import kotlin.Long
import kotlin.String

public data class IdProdToEValues(
  public val productId: Long?,
) {
  public fun toFormattedString(): String = buildString {
  append(productId?.toString()?.padStart(4, '0') ?: "0".repeat(4))
  }
}

public data class FlgPersoEValues(
  public val flgPerson: String?,
) {
  public fun toFormattedString(): String = buildString {
  append(flgPerson?.toString()?.padStart(1, '0') ?: " ")
  }
}

public data class NewCanalEValues(
  public val originChannel: String?,
) {
  public fun toFormattedString(): String = buildString {
  append(originChannel?.toString()?.padStart(2, '0') ?: "  ")
  }
}

public data class AgenciaEValues(
  public val agency: String?,
) {
  public fun toFormattedString(): String = buildString {
  append(agency?.toString()?.padStart(4, '0') ?: "    ")
  }
}

public data class SegmentoEValues(
  public val segment: String?,
) {
  public fun toFormattedString(): String = buildString {
  append(segment?.toString()?.padStart(1, '0') ?: " ")
  }
}

public data class IdPropFieValues(
  public val legacyNumber: String?,
) {
  public fun toFormattedString(): String = buildString {
  append(legacyNumber?.toString()?.padStart(8, '0') ?: "        ")
  }
}
