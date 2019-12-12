package json

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonProperty

@JsonIgnoreProperties(ignoreUnknown = true)
data class EventResponseJson(
    @JsonProperty("number", required = true) val number: Int,
    @JsonProperty("action", required = true) val action: String,
    @JsonProperty("created_at", required = true) val createdAt: String
)

