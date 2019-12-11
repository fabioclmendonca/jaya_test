import endPoint.EventEndPoint
import io.javalin.Javalin
import org.koin.standalone.KoinComponent
import module.eventModule
import org.koin.standalone.inject
import org.koin.standalone.StandAloneContext.startKoin
import org.jetbrains.exposed.sql.Database
import org.jetbrains.exposed.sql.transactions.transaction
import org.jetbrains.exposed.sql.SchemaUtils.create
import model.Event

class JayaChallenge : KoinComponent {

    private val eventEndPoint by inject<EventEndPoint>()

    fun run() = Javalin.create().apply {
        startKoin(listOf(eventModule))
        routes { eventEndPoint.addEndpoints() }
        Database.connect("jdbc:h2:mem:test;DB_CLOSE_DELAY=-1", driver = "org.h2.Driver")
        transaction { create(Event.table) }
    }.start(4567)
}

fun main(args: Array<String>) {
    JayaChallenge().run()
}