package json

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonProperty

@JsonIgnoreProperties(ignoreUnknown = true)
data class EventResponseJson(
    @JsonProperty("action", required = true) val action: String,
    @JsonProperty("created_at", required = true) val created_at: String
)