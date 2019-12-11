package repository

import org.jetbrains.exposed.sql.transactions.transaction
import org.joda.time.DateTime
import json.EventPostJson
import json.EventResponseJson
import model.Event
import model.LastResponse


class EventRepositoryImpl : EventRepository {

    override fun save(eventPostJson: EventPostJson) = transaction {
        Event.new(eventPostJson.hook_id) {
            this.created_at = DateTime(eventPostJson.created_at)
            this.updated_at = DateTime(eventPostJson.updated_at)
            this.last_response_code = eventPostJson.last_response.code
        }.flush()
    }

    override fun getEvents() = transaction {
        Event.all().map {
            EventResponseJson(it.action, it.created_at.toString())
        }
    }

    override fun getEvent(eventNum : Int) = transaction {
        when(val ev = Event.findById(eventNum)){
            null -> ev
            else -> EventResponseJson(ev.action, ev.created_at.toString())
        }
    }
}