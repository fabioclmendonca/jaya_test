package json

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonProperty

@JsonIgnoreProperties(ignoreUnknown = true)
data class IssuePostJson(
    @JsonProperty("number", required = true) val number: Int,
    @JsonProperty("created_at", required = true) val createdAt: String
)

