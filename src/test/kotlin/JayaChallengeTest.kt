import io.javalin.Javalin
import org.junit.jupiter.api.*
import org.junit.jupiter.api.Assertions.assertEquals

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class JayaChallengeTest {

    private lateinit var app: Javalin
    private val url = "http://localhost:4567"

    @BeforeAll
    fun setUp() {
        app = JayaChallenge().run()
    }

    @AfterAll
    fun tearDown() {
        app.stop()
    }

    @Test
    fun `Assert Success Response From Payload Service`() {
        println("Assert Success Response From Payload Service")
        val payload = javaClass.getResourceAsStream("issue_body.json")!!
        val response = khttp.post(
                url = "$url/payload",
                data = payload
        )
        assertEquals(200, response.statusCode)
        assertEquals("Payload saved", response.jsonObject["response"])
    }

    @Test
    fun `Assert Error Response From Payload Service`() {
        println("Assert Unknown Response From Payload Service")
        val payload = javaClass.getResourceAsStream("ping_body.json")!!
        val response = khttp.post(
                url = "$url/payload",
                data = payload
        )
        assertEquals(555, response.statusCode)
        assertEquals("Error saving payload.", response.jsonObject["response"])
    }

    @Test
    fun `Assert Error 404`(){
        println("Assert Error 404")
        val response = khttp.post(
            url = "$url/unknown/path"
        )
        assertEquals(404, response.statusCode)
    }

    @Test
    fun `Success Get Event By Id Response`() {
        println("Assert Get Event By Id Response")
        val payload = javaClass.getResourceAsStream("issue_body.json")!!
        khttp.post(
            url = "$url/payload",
            data = payload
        )
        val response = khttp.get(
            url = "$url/issues/5/events"
        )
        assertEquals(200, response.statusCode)
        assertEquals(5, response.jsonObject["number"])
    }

    @Test
    fun `Assert Get Event By Id With Empty Response`() {
        println("Assert Get Event By Id With Empty Response")
        val response = khttp.get(
            url = "$url/issues/5/events"
        )
        assertEquals(200, response.statusCode)
        assertEquals("Id doesn't exist.", response.jsonObject["response"])
    }
}
