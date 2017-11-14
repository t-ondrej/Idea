
package dto;

import com.fasterxml.jackson.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.io.Serializable;
import java.net.URI;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * = IDEA0 format definition =
 * <p>
 * Keys use !CamelCase, however to avoid confusion, they must be case insensitively unique within their parent object. When parsing, keys "ID", "id", "iD" and "Id" must be considered as equivalent.
 * <p>
 * Each definition line is in form KEY: TYPE, followed by an explanation line, where type can be basic JSON type (in ''italics''), syntactically restricted type (with reference to [[#Types|Types]] chapter), or array of former two (order is important). Types define expected syntax, however their content may be further syntactically or semantically restricted according to particular key explanation.
 * <p>
 * The keys ''Format'', ''ID'', ''!DetectTime'' and ''Category'' are mandatory, rest of the keys is optional (nonexistent key indicates that information is not applicable or unknown).
 * <p>
 * As human language may be ambiguous inadvertently or by omission, when in doubt, consult [[IDEA/Schema|JSON schema]].
 */
@SuppressWarnings("JavaDoc")
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "Format",
        "ID",
        "AltNames",
        "CorrelID",
        "AggrID",
        "PredID",
        "RelID",
        "CreateTime",
        "DetectTime",
        "EventTime",
        "CeaseTime",
        "WinStartTime",
        "WinEndTime",
        "ConnCount",
        "FlowCount",
        "PacketCount",
        "ByteCount",
        "Category",
        "Ref",
        "Confidence",
        "Description",
        "Note",
        "SourceDto",
        "TargetDto",
        "AttachDto",
        "NodeDto"
})
public class EventDto implements Serializable {

    /**
     * Must contain string "IDEA0". (Trailing zero denotes draft version, after review/discussion and specification finalisation the name will change.)
     * (Required)
     */
    @JsonProperty("Format")
    @JsonPropertyDescription("Must contain string \"IDEA0\". (Trailing zero denotes draft version, after review/discussion and specification finalisation the name will change.)")
    @NotNull
    private Format format;
    /**
     * String, containing reasonably globally unique identifier. UUID version 4 (random) or 5 (SHA-1) is recommended. As IDs are meant to be used at other mediums, transfer protocols and formats (an example being query string fields in URL), they are allowed to contain only reasonably safe subset of characters. May thus contain only alphanumeric, dot, minus sign and underscore and must not be empty.
     * (Required)
     */
    @JsonProperty("ID")
    @JsonPropertyDescription("String, containing reasonably globally unique identifier. UUID version 4 (random) or 5\u00a0(SHA-1) is recommended. As IDs are meant to be used at other mediums, transfer protocols and formats (an example being query string fields in URL), they are allowed to contain only reasonably safe subset of characters. May thus contain only alphanumeric, dot, minus sign and underscore and must not be empty.")
    @Pattern(regexp = "^[a-zA-Z0-9._-]+$")
    @NotNull
    private String iD;
    /**
     * Array of alternative identifiers.
     */
    @JsonProperty("AltNames")
    @JsonPropertyDescription("Array of alternative identifiers.")
    @Valid
    private List<String> altNames = null;
    /**
     * Array of correlated messages identifiers.
     */
    @JsonProperty("CorrelID")
    @JsonPropertyDescription("Array of correlated messages identifiers.")
    @Valid
    private List<String> correlID = null;
    /**
     * Array of aggregated messages identifiers.
     */
    @JsonProperty("AggrID")
    @JsonPropertyDescription("Array of aggregated messages identifiers.")
    @Valid
    private List<String> aggrID = null;
    /**
     * Array of obsoleted messages identifiers.
     */
    @JsonProperty("PredID")
    @JsonPropertyDescription("Array of obsoleted messages identifiers.")
    @Valid
    private List<String> predID = null;
    /**
     * Array of related messages identifiers.
     */
    @JsonProperty("RelID")
    @JsonPropertyDescription("Array of related messages identifiers.")
    @Valid
    private List<String> relID = null;
    /**
     * String, containing timestamp conforming to [[http://tools.ietf.org/html/rfc3339|RFC 3339]].
     */
    @JsonProperty("CreateTime")
    @JsonPropertyDescription("String, containing timestamp conforming to [[http://tools.ietf.org/html/rfc3339|RFC 3339]].")
    @Pattern(regexp = "^[0-9]{4}-[0-9]{2}-[0-9]{2}[Tt ][0-9]{2}:[0-9]{2}:[0-9]{2}(?:\\.[0-9]+)?(?:[Zz]|(?:[+-][0-9]{2}:[0-9]{2}))?$")
    private Date createTime;
    /**
     * String, containing timestamp conforming to [[http://tools.ietf.org/html/rfc3339|RFC 3339]].
     * (Required)
     */
    @JsonProperty("DetectTime")
    @JsonPropertyDescription("String, containing timestamp conforming to [[http://tools.ietf.org/html/rfc3339|RFC 3339]].")
    @Pattern(regexp = "^[0-9]{4}-[0-9]{2}-[0-9]{2}[Tt ][0-9]{2}:[0-9]{2}:[0-9]{2}(?:\\.[0-9]+)?(?:[Zz]|(?:[+-][0-9]{2}:[0-9]{2}))?$")
    @NotNull
    private Date detectTime;
    /**
     * String, containing timestamp conforming to [[http://tools.ietf.org/html/rfc3339|RFC 3339]].
     */
    @JsonProperty("EventTime")
    @JsonPropertyDescription("String, containing timestamp conforming to [[http://tools.ietf.org/html/rfc3339|RFC 3339]].")
    @Pattern(regexp = "^[0-9]{4}-[0-9]{2}-[0-9]{2}[Tt ][0-9]{2}:[0-9]{2}:[0-9]{2}(?:\\.[0-9]+)?(?:[Zz]|(?:[+-][0-9]{2}:[0-9]{2}))?$")
    private Date eventTime;
    /**
     * String, containing timestamp conforming to [[http://tools.ietf.org/html/rfc3339|RFC 3339]].
     */
    @JsonProperty("CeaseTime")
    @JsonPropertyDescription("String, containing timestamp conforming to [[http://tools.ietf.org/html/rfc3339|RFC 3339]].")
    @Pattern(regexp = "^[0-9]{4}-[0-9]{2}-[0-9]{2}[Tt ][0-9]{2}:[0-9]{2}:[0-9]{2}(?:\\.[0-9]+)?(?:[Zz]|(?:[+-][0-9]{2}:[0-9]{2}))?$")
    private Date ceaseTime;
    /**
     * String, containing timestamp conforming to [[http://tools.ietf.org/html/rfc3339|RFC 3339]].
     */
    @JsonProperty("WinStartTime")
    @JsonPropertyDescription("String, containing timestamp conforming to [[http://tools.ietf.org/html/rfc3339|RFC 3339]].")
    @Pattern(regexp = "^[0-9]{4}-[0-9]{2}-[0-9]{2}[Tt ][0-9]{2}:[0-9]{2}:[0-9]{2}(?:\\.[0-9]+)?(?:[Zz]|(?:[+-][0-9]{2}:[0-9]{2}))?$")
    private Date winStartTime;
    /**
     * String, containing timestamp conforming to [[http://tools.ietf.org/html/rfc3339|RFC 3339]].
     */
    @JsonProperty("WinEndTime")
    @JsonPropertyDescription("String, containing timestamp conforming to [[http://tools.ietf.org/html/rfc3339|RFC 3339]].")
    @Pattern(regexp = "^[0-9]{4}-[0-9]{2}-[0-9]{2}[Tt ][0-9]{2}:[0-9]{2}:[0-9]{2}(?:\\.[0-9]+)?(?:[Zz]|(?:[+-][0-9]{2}:[0-9]{2}))?$")
    private Date winEndTime;
    /**
     * JSON "number" with no fractional and exponential part.
     */
    @JsonProperty("ConnCount")
    @JsonPropertyDescription("JSON \"number\" with no fractional and exponential part.")
    private Integer connCount;
    /**
     * JSON "number" with no fractional and exponential part.
     */
    @JsonProperty("FlowCount")
    @JsonPropertyDescription("JSON \"number\" with no fractional and exponential part.")
    private Integer flowCount;
    /**
     * JSON "number" with no fractional and exponential part.
     */
    @JsonProperty("PacketCount")
    @JsonPropertyDescription("JSON \"number\" with no fractional and exponential part.")
    private Integer packetCount;
    /**
     * JSON "number" with no fractional and exponential part.
     */
    @JsonProperty("ByteCount")
    @JsonPropertyDescription("JSON \"number\" with no fractional and exponential part.")
    private Integer byteCount;
    /**
     * Array of event categories.
     * (Required)
     */
    @JsonProperty("Category")
    @JsonPropertyDescription("Array of event categories.")
    @Valid
    @NotNull
    private List<String> category = null;
    /**
     * Array of references.
     */
    @JsonProperty("Ref")
    @JsonPropertyDescription("Array of references.")
    @Valid
    private List<URI> ref = null;
    /**
     * Confidence of detector in its own reliability of this particular detection. (0 – surely false, 1 – no doubts). If key is not presented, detector does not know (or has no capability to estimate the confidence).
     */
    @JsonProperty("Confidence")
    @JsonPropertyDescription("Confidence of detector in its own reliability of this particular detection. (0 \u2013 surely false, 1 \u2013 no doubts). If key is not presented, detector does not know (or has no capability to estimate the confidence).")
    @DecimalMin("0")
    @DecimalMax("1")
    private Double confidence;
    /**
     * Short free text human readable description.
     */
    @JsonProperty("Description")
    @JsonPropertyDescription("Short free text human readable description.")
    private String description;
    /**
     * Free text human readable addidional note, possibly longer description of incident if not obvious.
     */
    @JsonProperty("Note")
    @JsonPropertyDescription("Free text human readable addidional note, possibly longer description of incident if not obvious.")
    private String note;
    /**
     * Array of sourceDto or targetDto descriptions.
     */
    @JsonProperty("SourceDto")
    @JsonPropertyDescription("Array of sourceDto or targetDto descriptions.")
    @Valid
    private List<SourceDto> sourceDto = null;
    /**
     * Array of sourceDto or targetDto descriptions.
     */
    @JsonProperty("TargetDto")
    @JsonPropertyDescription("Array of sourceDto or targetDto descriptions.")
    @Valid
    private List<TargetDto> targetDto = null;
    /**
     * Array of attachment descriptions.
     */
    @JsonProperty("AttachDto")
    @JsonPropertyDescription("Array of attachment descriptions.")
    @Valid
    private List<AttachDto> attachDto = null;
    /**
     * Array of detector descriptions.
     */
    @JsonProperty("NodeDto")
    @JsonPropertyDescription("Array of detector descriptions.")
    @Valid
    private List<NodeDto> nodes = null;
    @JsonIgnore
    @Valid
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();
    private final static long serialVersionUID = -793500735731519752L;

    /**
     * No args constructor for use in serialization
     */
    public EventDto() {
    }

    /**
     * @param createTime
     * @param packetCount
     * @param correlID
     * @param byteCount
     * @param description
     * @param winStartTime
     * @param note
     * @param flowCount
     * @param winEndTime
     * @param connCount
     * @param format
     * @param confidence
     * @param ceaseTime
     * @param aggrID
     * @param iD
     * @param altNames
     * @param ref
     * @param nodeDto
     * @param category
     * @param sourceDto
     * @param attachDto
     * @param predID
     * @param relID
     * @param targetDto
     * @param eventTime
     * @param detectTime
     */
    public EventDto(Format format, String iD, List<String> altNames, List<String> correlID, List<String> aggrID, List<String> predID, List<String> relID, Date createTime, Date detectTime, Date eventTime, Date ceaseTime, Date winStartTime, Date winEndTime, Integer connCount, Integer flowCount, Integer packetCount, Integer byteCount, List<String> category, List<URI> ref, Double confidence, String description, String note, List<SourceDto> sourceDto, List<TargetDto> targetDto, List<AttachDto> attachDto, List<NodeDto> nodes) {
        super();
        this.format = format;
        this.iD = iD;
        this.altNames = altNames;
        this.correlID = correlID;
        this.aggrID = aggrID;
        this.predID = predID;
        this.relID = relID;
        this.createTime = createTime;
        this.detectTime = detectTime;
        this.eventTime = eventTime;
        this.ceaseTime = ceaseTime;
        this.winStartTime = winStartTime;
        this.winEndTime = winEndTime;
        this.connCount = connCount;
        this.flowCount = flowCount;
        this.packetCount = packetCount;
        this.byteCount = byteCount;
        this.category = category;
        this.ref = ref;
        this.confidence = confidence;
        this.description = description;
        this.note = note;
        this.sourceDto = sourceDto;
        this.targetDto = targetDto;
        this.attachDto = attachDto;
        this.nodes = nodes;

    }

    /**
     * Must contain string "IDEA0". (Trailing zero denotes draft version, after review/discussion and specification finalisation the name will change.)
     * (Required)
     */
    @JsonProperty("Format")
    public Format getFormat() {
        return format;
    }

    /**
     * Must contain string "IDEA0". (Trailing zero denotes draft version, after review/discussion and specification finalisation the name will change.)
     * (Required)
     */
    @JsonProperty("Format")
    public void setFormat(Format format) {
        this.format = format;
    }

    /**
     * String, containing reasonably globally unique identifier. UUID version 4 (random) or 5 (SHA-1) is recommended. As IDs are meant to be used at other mediums, transfer protocols and formats (an example being query string fields in URL), they are allowed to contain only reasonably safe subset of characters. May thus contain only alphanumeric, dot, minus sign and underscore and must not be empty.
     * (Required)
     */
    @JsonProperty("ID")
    public String getID() {
        return iD;
    }

    /**
     * String, containing reasonably globally unique identifier. UUID version 4 (random) or 5 (SHA-1) is recommended. As IDs are meant to be used at other mediums, transfer protocols and formats (an example being query string fields in URL), they are allowed to contain only reasonably safe subset of characters. May thus contain only alphanumeric, dot, minus sign and underscore and must not be empty.
     * (Required)
     */
    @JsonProperty("ID")
    public void setID(String iD) {
        this.iD = iD;
    }

    /**
     * Array of alternative identifiers.
     */
    @JsonProperty("AltNames")
    public List<String> getAltNames() {
        return altNames;
    }

    /**
     * Array of alternative identifiers.
     */
    @JsonProperty("AltNames")
    public void setAltNames(List<String> altNames) {
        this.altNames = altNames;
    }

    /**
     * Array of correlated messages identifiers.
     */
    @JsonProperty("CorrelID")
    public List<String> getCorrelID() {
        return correlID;
    }

    /**
     * Array of correlated messages identifiers.
     */
    @JsonProperty("CorrelID")
    public void setCorrelID(List<String> correlID) {
        this.correlID = correlID;
    }

    /**
     * Array of aggregated messages identifiers.
     */
    @JsonProperty("AggrID")
    public List<String> getAggrID() {
        return aggrID;
    }

    /**
     * Array of aggregated messages identifiers.
     */
    @JsonProperty("AggrID")
    public void setAggrID(List<String> aggrID) {
        this.aggrID = aggrID;
    }

    /**
     * Array of obsoleted messages identifiers.
     */
    @JsonProperty("PredID")
    public List<String> getPredID() {
        return predID;
    }

    /**
     * Array of obsoleted messages identifiers.
     */
    @JsonProperty("PredID")
    public void setPredID(List<String> predID) {
        this.predID = predID;
    }

    /**
     * Array of related messages identifiers.
     */
    @JsonProperty("RelID")
    public List<String> getRelID() {
        return relID;
    }

    /**
     * Array of related messages identifiers.
     */
    @JsonProperty("RelID")
    public void setRelID(List<String> relID) {
        this.relID = relID;
    }

    /**
     * String, containing timestamp conforming to [[http://tools.ietf.org/html/rfc3339|RFC 3339]].
     */
    @JsonProperty("CreateTime")
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * String, containing timestamp conforming to [[http://tools.ietf.org/html/rfc3339|RFC 3339]].
     */
    @JsonProperty("CreateTime")
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * String, containing timestamp conforming to [[http://tools.ietf.org/html/rfc3339|RFC 3339]].
     * (Required)
     */
    @JsonProperty("DetectTime")
    public Date getDetectTime() {
        return detectTime;
    }

    /**
     * String, containing timestamp conforming to [[http://tools.ietf.org/html/rfc3339|RFC 3339]].
     * (Required)
     */
    @JsonProperty("DetectTime")
    public void setDetectTime(Date detectTime) {
        this.detectTime = detectTime;
    }

    /**
     * String, containing timestamp conforming to [[http://tools.ietf.org/html/rfc3339|RFC 3339]].
     */
    @JsonProperty("EventTime")
    public Date getEventTime() {
        return eventTime;
    }

    /**
     * String, containing timestamp conforming to [[http://tools.ietf.org/html/rfc3339|RFC 3339]].
     */
    @JsonProperty("EventTime")
    public void setEventTime(Date eventTime) {
        this.eventTime = eventTime;
    }

    /**
     * String, containing timestamp conforming to [[http://tools.ietf.org/html/rfc3339|RFC 3339]].
     */
    @JsonProperty("CeaseTime")
    public Date getCeaseTime() {
        return ceaseTime;
    }

    /**
     * String, containing timestamp conforming to [[http://tools.ietf.org/html/rfc3339|RFC 3339]].
     */
    @JsonProperty("CeaseTime")
    public void setCeaseTime(Date ceaseTime) {
        this.ceaseTime = ceaseTime;
    }

    /**
     * String, containing timestamp conforming to [[http://tools.ietf.org/html/rfc3339|RFC 3339]].
     */
    @JsonProperty("WinStartTime")
    public Date getWinStartTime() {
        return winStartTime;
    }

    /**
     * String, containing timestamp conforming to [[http://tools.ietf.org/html/rfc3339|RFC 3339]].
     */
    @JsonProperty("WinStartTime")
    public void setWinStartTime(Date winStartTime) {
        this.winStartTime = winStartTime;
    }

    /**
     * String, containing timestamp conforming to [[http://tools.ietf.org/html/rfc3339|RFC 3339]].
     */
    @JsonProperty("WinEndTime")
    public Date getWinEndTime() {
        return winEndTime;
    }

    /**
     * String, containing timestamp conforming to [[http://tools.ietf.org/html/rfc3339|RFC 3339]].
     */
    @JsonProperty("WinEndTime")
    public void setWinEndTime(Date winEndTime) {
        this.winEndTime = winEndTime;
    }

    /**
     * JSON "number" with no fractional and exponential part.
     */
    @JsonProperty("ConnCount")
    public Integer getConnCount() {
        return connCount;
    }

    /**
     * JSON "number" with no fractional and exponential part.
     */
    @JsonProperty("ConnCount")
    public void setConnCount(Integer connCount) {
        this.connCount = connCount;
    }

    /**
     * JSON "number" with no fractional and exponential part.
     */
    @JsonProperty("FlowCount")
    public Integer getFlowCount() {
        return flowCount;
    }

    /**
     * JSON "number" with no fractional and exponential part.
     */
    @JsonProperty("FlowCount")
    public void setFlowCount(Integer flowCount) {
        this.flowCount = flowCount;
    }

    /**
     * JSON "number" with no fractional and exponential part.
     */
    @JsonProperty("PacketCount")
    public Integer getPacketCount() {
        return packetCount;
    }

    /**
     * JSON "number" with no fractional and exponential part.
     */
    @JsonProperty("PacketCount")
    public void setPacketCount(Integer packetCount) {
        this.packetCount = packetCount;
    }

    /**
     * JSON "number" with no fractional and exponential part.
     */
    @JsonProperty("ByteCount")
    public Integer getByteCount() {
        return byteCount;
    }

    /**
     * JSON "number" with no fractional and exponential part.
     */
    @JsonProperty("ByteCount")
    public void setByteCount(Integer byteCount) {
        this.byteCount = byteCount;
    }

    /**
     * Array of event categories.
     * (Required)
     */
    @JsonProperty("Category")
    public List<String> getCategory() {
        return category;
    }

    /**
     * Array of event categories.
     * (Required)
     */
    @JsonProperty("Category")
    public void setCategory(List<String> category) {
        this.category = category;
    }

    /**
     * Array of references.
     */
    @JsonProperty("Ref")
    public List<URI> getRef() {
        return ref;
    }

    /**
     * Array of references.
     */
    @JsonProperty("Ref")
    public void setRef(List<URI> ref) {
        this.ref = ref;
    }

    /**
     * Confidence of detector in its own reliability of this particular detection. (0 – surely false, 1 – no doubts). If key is not presented, detector does not know (or has no capability to estimate the confidence).
     */
    @JsonProperty("Confidence")
    public Double getConfidence() {
        return confidence;
    }

    /**
     * Confidence of detector in its own reliability of this particular detection. (0 – surely false, 1 – no doubts). If key is not presented, detector does not know (or has no capability to estimate the confidence).
     */
    @JsonProperty("Confidence")
    public void setConfidence(Double confidence) {
        this.confidence = confidence;
    }

    /**
     * Short free text human readable description.
     */
    @JsonProperty("Description")
    public String getDescription() {
        return description;
    }

    /**
     * Short free text human readable description.
     */
    @JsonProperty("Description")
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * Free text human readable addidional note, possibly longer description of incident if not obvious.
     */
    @JsonProperty("Note")
    public String getNote() {
        return note;
    }

    /**
     * Free text human readable addidional note, possibly longer description of incident if not obvious.
     */
    @JsonProperty("Note")
    public void setNote(String note) {
        this.note = note;
    }

    /**
     * Array of sourceDto or targetDto descriptions.
     */
    @JsonProperty("Source")
    public List<SourceDto> getSourceDto() {
        return sourceDto;
    }

    /**
     * Array of sourceDto or targetDto descriptions.
     */
    @JsonProperty("Source")
    public void setSourceDto(List<SourceDto> sourceDto) {
        this.sourceDto = sourceDto;
    }

    /**
     * Array of sourceDto or targetDto descriptions.
     */
    @JsonProperty("Target")
    public List<TargetDto> getTargetDto() {
        return targetDto;
    }

    /**
     * Array of sourceDto or targetDto descriptions.
     */
    @JsonProperty("Target")
    public void setTargetDto(List<TargetDto> targetDto) {
        this.targetDto = targetDto;
    }

    /**
     * Array of attachment descriptions.
     */
    @JsonProperty("Attach")
    public List<AttachDto> getAttachDto() {
        return attachDto;
    }

    /**
     * Array of attachment descriptions.
     */
    @JsonProperty("Attach")
    public void setAttachDto(List<AttachDto> attachDto) {
        this.attachDto = attachDto;
    }

    /**
     * Array of detector descriptions.
     */
    @JsonProperty("Node")
    public List<NodeDto> getNodes() {
        return nodes;
    }

    /**
     * Array of detector descriptions.
     */
    @JsonProperty("Node")
    public void setNodes(List<NodeDto> nodes) {
        this.nodes = nodes;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

    public enum Format {

        IDEA_0("IDEA0");
        private final String value;
        private final static Map<String, Format> CONSTANTS = new HashMap<String, Format>();

        static {
            for (Format c : values()) {
                CONSTANTS.put(c.value, c);
            }
        }

        private Format(String value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return this.value;
        }

        @JsonValue
        public String value() {
            return this.value;
        }

        @JsonCreator
        public static Format fromValue(String value) {
            Format constant = CONSTANTS.get(value);
            if (constant == null) {
                throw new IllegalArgumentException(value);
            } else {
                return constant;
            }
        }

    }

}
