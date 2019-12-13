package repository

import org.jetbrains.exposed.sql.transactions.transaction
import org.joda.time.DateTime
import json.EventPostJson
import json.EventResponseJson
import model.Event
import model.Issue
import model.EventTable
import java.lang.Exception

class EventRepositoryImpl : EventRepository {

    override fun save(eventPostJson: EventPostJson) = transaction {
        val issue = Issue.findById(eventPostJson.issue.number)?.apply {
            createdAt = DateTime(eventPostJson.issue.createdAt)
        } ?: Issue.new(eventPostJson.issue.number) {
            this.createdAt = DateTime(eventPostJson.issue.createdAt)
        }
        Event.new {
            this.action = eventPostJson.action
            this.issue = issue
        }.flush()
    }

    override fun getEvents() = transaction {
        Event.all().map {
            EventResponseJson(it.issue.id.value, it.action, it.issue.createdAt.toString())
        }
    }

    override fun getEvent(eventNum : Int) = transaction {
        try{
            Event.find { EventTable.issueId eq eventNum }.map {
                EventResponseJson(it.issue.id.value, it.action, it.issue.createdAt.toString())
            }.last()
        }catch (ex: Exception){
            null
        }
    }
}