package com.br.poetexample.application.core.usecase

import com.br.poetexample.application.core.mapper.AssingmentCommercialMessageMapper
import com.br.poetexample.application.core.model.AssingmentCommercialMessage
import org.springframework.stereotype.Service

@Service
class TrancodeService {

    fun generateTrancode(): String {
        val message = AssingmentCommercialMessage(
            productId = null,
            flgPerson = "Y",
            originChannel = "01",
            agency = "5678",
            segment = "A",
            legacyNumber = "98765432",
            managerFunctional = "0001"
        )
        return AssingmentCommercialMessageMapper.toTrancodeString(message)
    }
}
