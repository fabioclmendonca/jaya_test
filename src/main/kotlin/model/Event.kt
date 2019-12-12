package model

import org.jetbrains.exposed.dao.*
import java.util.*

class Event(id: EntityID<UUID>) : UUIDEntity(id) {

    companion object : UUIDEntityClass<Event>(EventTable)

    var action by EventTable.action
    var issue by Issue referencedOn EventTable.issueId
}

object EventTable : UUIDTable("Event") {
    val action = varchar("action", 50)
    val issueId = reference("issue_id", IssueTable)
}

