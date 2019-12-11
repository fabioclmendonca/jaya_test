package endPoint

import handler.EventHandler
import io.javalin.apibuilder.ApiBuilder.*
import io.javalin.apibuilder.EndpointGroup

class EventEndPoint : EndpointGroup {

    override fun addEndpoints() {
        post("/payload", EventHandler::payload)
        path("/issues"){
            get("/events", EventHandler::getEvents)
            get("/:id/events", EventHandler::getEvent)
        }
    }
}
