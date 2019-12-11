package handler

import io.javalin.Context
import json.EventPostJson
import org.koin.standalone.KoinComponent
import org.koin.standalone.inject
import service.EventService
import java.lang.Exception

object EventHandler : KoinComponent {

    private val eventService by inject<EventService>()

    fun payload(ctx: Context) {
        ctx.json("Hello World")
        try {
            val event = ctx.bodyAsClass(EventPostJson::class.java)
            when(eventService.save(event)) {
                true -> ctx.json("Payload saved.")
                else -> throw Exception()
            }
        } catch (e: Exception){
            ctx.json("Error to save Payload.")
            e.printStackTrace()
        }
    }

    fun getEvents(ctx: Context) {
        val events = eventService.getEvents()
        ctx.json(events)
    }

    fun getEvent(ctx: Context){
        val eventNum = ctx.pathParam("id").toInt()
        val event = eventService.getEvent(eventNum)
        when(event){
            null -> ctx.json("Id doesn't exist")
            else -> ctx.json(event)
        }

    }

}