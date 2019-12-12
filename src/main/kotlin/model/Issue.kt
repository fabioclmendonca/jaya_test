package model

import org.jetbrains.exposed.dao.*

class Issue(id: EntityID<Int>) : IntEntity(id) {

    companion object : IntEntityClass<Issue>(IssueTable)

    var createdAt by IssueTable.createdAt
}

object IssueTable : IdTable<Int>("Issue") {
    override val id = integer("number").primaryKey().entityId()
    val createdAt = datetime("created_at")
}


