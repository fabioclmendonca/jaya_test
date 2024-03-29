package json

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonProperty

@JsonIgnoreProperties(ignoreUnknown = true)
data class EventPostJson(
    @JsonProperty("action", required = true) val action: String,
    @JsonProperty("issue", required = true) val issue: IssuePostJson
)


