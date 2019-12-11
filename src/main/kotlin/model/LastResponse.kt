package model

import org.jetbrains.exposed.dao.*

class LastResponse(id: EntityID<Int>) : IntEntity(id) {

    companion object : IntEntityClass<Event>(EventTable)

    var code by LastResponseTable.code
    var status by LastResponseTable.status
    var message by LastResponseTable.message
}

object LastResponseTable : IntIdTable("event") {
    val code = integer("code").nullable()
    val status = varchar("status", 10).nullable()
    val message = varchar("message",200).nullable()
}

