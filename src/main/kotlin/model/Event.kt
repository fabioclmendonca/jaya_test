package model

import org.jetbrains.exposed.dao.*

class Event(id: EntityID<Int>) : IntEntity(id) {

    companion object : IntEntityClass<Event>(EventTable)

    var created_at by EventTable.created_at
    var updated_at by EventTable.updated_at
    var last_response by EventTable.last_response
}

object EventTable : IdTable<Int>("event") {

    override val id = integer("hook_id").primaryKey().entityId()
    val created_at = datetime("created_at")
    val updated_at = datetime("updated_at")
    val last_response = reference("last_response", LastResponseTable)
}

