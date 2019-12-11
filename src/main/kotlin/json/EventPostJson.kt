package json

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonProperty

@JsonIgnoreProperties(ignoreUnknown = true)
data class EventPostJson(
    @JsonProperty("hook_id", required = true) val hook_id: Int,
    @JsonProperty("created_at", required = true) val created_at: String,
    @JsonProperty("updated_at", required = true) val updated_at: String,
    @JsonProperty("last_response", required = true) val last_response: LastResponseJson
)

@JsonIgnoreProperties(ignoreUnknown = true)
data class LastResponseJson(
    @JsonProperty("code", required = true) val code: Int?,
    @JsonProperty("status", required = true) val status: String,
    @JsonProperty("message", required = true) val message: String?
)

