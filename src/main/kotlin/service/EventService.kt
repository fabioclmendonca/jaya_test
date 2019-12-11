package service

import json.EventPostJson
import json.EventResponseJson


interface EventService {
    fun save(issueEventPost: EventPostJson): Boolean
    fun getEvents(): List<EventResponseJson>
    fun getEvent(eventNum : Int): EventResponseJson?
}