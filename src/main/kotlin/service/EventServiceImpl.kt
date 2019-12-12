package service

import json.EventPostJson
import repository.EventRepository


class EventServiceImpl(private val eventRepository: EventRepository) : EventService {

    override fun save(eventPostJson: EventPostJson) = eventRepository.save(eventPostJson)

    override fun getEvents() = eventRepository.getEvents()

    override fun getEvent(eventNum : Int) = eventRepository.getEvent(eventNum)

}