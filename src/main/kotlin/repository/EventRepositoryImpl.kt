package repository

import org.jetbrains.exposed.sql.transactions.transaction
import org.joda.time.DateTime
import json.EventPostJson
import json.EventResponseJson
import model.Event
import org.jetbrains.exposed.sql.SqlExpressionBuilder.eq


class EventRepositoryImpl : EventRepository {

    override fun save(eventPostJson: EventPostJson) = transaction {
        Event.new(eventPostJson.id) {
            this.action = eventPostJson.action
            this.created_at = DateTime.now()
        }.flush()
    }

    override fun getEvents() = transaction {
        Event.all().map {
            EventResponseJson(it.action, it.created_at.toString())
        }
    }

    override fun getEvent(event_id : Int) = transaction {
        val ev = Event.findById(event_id)
        when(ev){
            null -> ev
            else -> EventResponseJson(ev.action, ev.created_at.toString())
        }

    }
}
