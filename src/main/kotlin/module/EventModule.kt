package module

import org.koin.dsl.module.module
import endPoint.EventEndPoint
import repository.EventRepository
import repository.EventRepositoryImpl
import service.EventService
import service.EventServiceImpl

val eventModule = module("module.eventModule") {
    single { EventEndPoint() }
    single<EventService> { EventServiceImpl(get()) }
    single<EventRepository> { EventRepositoryImpl() }
}
