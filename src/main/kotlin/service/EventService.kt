package service

import json.EventPostJson
import json.EventResponseJson


interface EventService {
    fun save(eventPostJson: EventPostJson): Boolean
    fun getEvents(): List<EventResponseJson>
    fun getEvent(eventNum : Int): EventResponseJson?
}