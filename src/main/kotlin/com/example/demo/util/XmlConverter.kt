package com.example.demo.util

import com.fasterxml.jackson.core.type.TypeReference
import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import org.springframework.stereotype.Component
import org.thymeleaf.context.Context
import org.thymeleaf.spring5.SpringTemplateEngine
import java.util.*


@Component
class XmlConverter(val engine: SpringTemplateEngine) {

    fun buildSOAP(varName: String, templateName: String, model: Any): String {
        val mapper = jacksonObjectMapper()
        val dataAsMap = mapper.convertValue(model, object: TypeReference<Map<String, String>>() {})
        val context = Context(Locale.GERMANY)
        context.setVariable(varName, dataAsMap)
        return engine.process(templateName, context)
    }
}