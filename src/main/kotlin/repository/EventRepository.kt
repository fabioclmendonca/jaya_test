package repository
import json.EventPostJson
import json.EventResponseJson

interface EventRepository {
    fun save(eventPostJson: EventPostJson): Boolean
    fun getEvents(): List<EventResponseJson>
    fun getEvent(eventNum : Int): EventResponseJson?

}
