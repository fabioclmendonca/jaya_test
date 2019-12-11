package model

import org.jetbrains.exposed.dao.*

class Event(id: EntityID<Int>) : IntEntity(id) {

    companion object : IntEntityClass<Event>(EventTable)

    var action by EventTable.action
    var created_at by EventTable.created_at
}

object EventTable : IdTable<Int>("event") {
    override val id = integer("id").primaryKey().entityId()
    val action = varchar("action", 50)
    val created_at = datetime("created_at")
}

