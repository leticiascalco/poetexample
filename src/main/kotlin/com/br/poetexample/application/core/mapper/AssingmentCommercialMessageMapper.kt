package com.br.poetexample.application.core.mapper

import com.br.poetexample.application.core.dto.*
import com.br.poetexample.application.core.model.AssingmentCommercialMessage

object AssingmentCommercialMessageMapper {

    private const val XFILLER_LENGTH = 492

    fun toTrancodeString(message: AssingmentCommercialMessage): String {

        val idProdToEValues = IdProdToEValues(
            productId = message.productId
        )
        val flgPersoEValues = FlgPersoEValues(
            flgPerson = message.flgPerson
        )
        val newCanalEValues = NewCanalEValues(
            originChannel = message.originChannel
        )
        val agenciaEValues = AgenciaEValues(
            agency = message.agency
        )
        val segmentoEValues = SegmentoEValues(
            segment = message.segment
        )
        val idPropFieValues = IdPropFieValues(
            legacyNumber = message.legacyNumber
        )

        val managerFunctionalContent = message.managerFunctional?.takeIf { it.isNotBlank() } ?: ""
        val xFillerContent = managerFunctionalContent.padEnd(XFILLER_LENGTH).take(managerFunctionalContent.length)
        val remainingFiller = " ".repeat(XFILLER_LENGTH - managerFunctionalContent.length)

        return buildString {
            append(idProdToEValues.toFormattedString())
            append(flgPersoEValues.toFormattedString())
            append(newCanalEValues.toFormattedString())
            append(agenciaEValues.toFormattedString())
            append(segmentoEValues.toFormattedString())
            append(idPropFieValues.toFormattedString())
            append(xFillerContent)
            append(remainingFiller)
        }
    }
}
