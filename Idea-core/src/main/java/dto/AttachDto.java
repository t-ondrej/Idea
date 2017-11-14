
package dto;

import com.fasterxml.jackson.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Pattern;
import java.io.Serializable;
import java.net.URI;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * Additional attachment information and data.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "Handle",
        "FileName",
        "Type",
        "Hash",
        "Size",
        "Ref",
        "Note",
        "ContentType",
        "ContentCharset",
        "ContentEncoding",
        "Content",
        "ContentID",
        "ExternalURI"
})
public class AttachDto implements Serializable {

    /**
     * String value unique among all "Handle" element values. May contain only alphanumeric or underscore, must not start with number and must not be empty.
     */
    @JsonProperty("Handle")
    @JsonPropertyDescription("String value unique among all \"Handle\" element values. May contain only alphanumeric or underscore, must not start with number and must not be empty.")
    @Pattern(regexp = "^[a-zA-Z_][a-zA-Z0-9_]*$")
    private String handle;
    /**
     * Array of filenames.
     */
    @JsonProperty("FileName")
    @JsonPropertyDescription("Array of filenames.")
    @Valid
    private List<String> fileName = null;
    /**
     * Array of attachment type tags.
     */
    @JsonProperty("Type")
    @JsonPropertyDescription("Array of attachment type tags.")
    @Valid
    private List<String> type = null;
    /**
     * Array of checksums.
     */
    @JsonProperty("Hash")
    @JsonPropertyDescription("Array of checksums.")
    @Valid
    private List<URI> hash = null;
    /**
     * JSON "number" with no fractional and exponential part.
     */
    @JsonProperty("Size")
    @JsonPropertyDescription("JSON \"number\" with no fractional and exponential part.")
    private Integer size;
    /**
     * Array of references.
     */
    @JsonProperty("Ref")
    @JsonPropertyDescription("Array of references.")
    @Valid
    private List<URI> ref = null;
    /**
     * Free text human readable additional note.
     */
    @JsonProperty("Note")
    @JsonPropertyDescription("Free text human readable additional note.")
    private String note;
    /**
     * Internet media type without parameters. Format is type and subtype, separated by slash, where type can contain only alphanumeric, underscore and minus sign, and subtype can contain only alphanumeric, plus and minus sign, underscore and dot.
     */
    @JsonProperty("ContentType")
    @JsonPropertyDescription("Internet media type without parameters. Format is type and subtype, separated by slash, where type can contain only alphanumeric, underscore and minus sign, and subtype can contain only alphanumeric, plus and minus sign, underscore and dot.")
    @Pattern(regexp = "^[a-zA-Z0-9_-]+/[a-zA-Z0-9_+.-]+$")
    private String contentType;
    /**
     * Character set name may consist of alphanumeric, dot, colon, minus sign, underscore and parentheses (round brackets).
     */
    @JsonProperty("ContentCharset")
    @JsonPropertyDescription("Character set name may consist of alphanumeric, dot, colon, minus sign, underscore and parentheses (round brackets).")
    @Pattern(regexp = "^[a-zA-Z0-9.:_()-]+$")
    private String contentCharset;
    /**
     * May contain only string "base64" (however note that key can be nonexistent, which means native encoding).
     */
    @JsonProperty("ContentEncoding")
    @JsonPropertyDescription("May contain only string \"base64\" (however note that key can be nonexistent, which means native encoding).")
    private ContentEncoding contentEncoding;
    /**
     * Attachment content.
     */
    @JsonProperty("Content")
    @JsonPropertyDescription("Attachment content.")
    private String content;
    /**
     * Array of external content IDs.
     */
    @JsonProperty("ContentID")
    @JsonPropertyDescription("Array of external content IDs.")
    @Valid
    private List<String> contentID = null;
    /**
     * Array of external URIs.
     */
    @JsonProperty("ExternalURI")
    @JsonPropertyDescription("Array of external URIs.")
    @Valid
    private List<URI> externalURI = null;
    @JsonIgnore
    @Valid
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();
    private final static long serialVersionUID = 4320597711112461599L;

    /**
     * No args constructor for use in serialization
     */
    public AttachDto() {
    }

    /**
     * @param externalURI
     * @param handle
     * @param hash
     * @param contentType
     * @param type
     * @param contentID
     * @param size
     * @param contentCharset
     * @param content
     * @param ref
     * @param fileName
     * @param contentEncoding
     * @param note
     */
    public AttachDto(String handle, List<String> fileName, List<String> type, List<URI> hash, Integer size, List<URI> ref, String note, String contentType, String contentCharset, ContentEncoding contentEncoding, String content, List<String> contentID, List<URI> externalURI) {
        super();
        this.handle = handle;
        this.fileName = fileName;
        this.type = type;
        this.hash = hash;
        this.size = size;
        this.ref = ref;
        this.note = note;
        this.contentType = contentType;
        this.contentCharset = contentCharset;
        this.contentEncoding = contentEncoding;
        this.content = content;
        this.contentID = contentID;
        this.externalURI = externalURI;
    }

    /**
     * String value unique among all "Handle" element values. May contain only alphanumeric or underscore, must not start with number and must not be empty.
     */
    @JsonProperty("Handle")
    public String getHandle() {
        return handle;
    }

    /**
     * String value unique among all "Handle" element values. May contain only alphanumeric or underscore, must not start with number and must not be empty.
     */
    @JsonProperty("Handle")
    public void setHandle(String handle) {
        this.handle = handle;
    }

    /**
     * Array of filenames.
     */
    @JsonProperty("FileName")
    public List<String> getFileName() {
        return fileName;
    }

    /**
     * Array of filenames.
     */
    @JsonProperty("FileName")
    public void setFileName(List<String> fileName) {
        this.fileName = fileName;
    }

    /**
     * Array of attachment type tags.
     */
    @JsonProperty("Type")
    public List<String> getType() {
        return type;
    }

    /**
     * Array of attachment type tags.
     */
    @JsonProperty("Type")
    public void setType(List<String> type) {
        this.type = type;
    }

    /**
     * Array of checksums.
     */
    @JsonProperty("Hash")
    public List<URI> getHash() {
        return hash;
    }

    /**
     * Array of checksums.
     */
    @JsonProperty("Hash")
    public void setHash(List<URI> hash) {
        this.hash = hash;
    }

    /**
     * JSON "number" with no fractional and exponential part.
     */
    @JsonProperty("Size")
    public Integer getSize() {
        return size;
    }

    /**
     * JSON "number" with no fractional and exponential part.
     */
    @JsonProperty("Size")
    public void setSize(Integer size) {
        this.size = size;
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
     * Free text human readable additional note.
     */
    @JsonProperty("Note")
    public String getNote() {
        return note;
    }

    /**
     * Free text human readable additional note.
     */
    @JsonProperty("Note")
    public void setNote(String note) {
        this.note = note;
    }

    /**
     * Internet media type without parameters. Format is type and subtype, separated by slash, where type can contain only alphanumeric, underscore and minus sign, and subtype can contain only alphanumeric, plus and minus sign, underscore and dot.
     */
    @JsonProperty("ContentType")
    public String getContentType() {
        return contentType;
    }

    /**
     * Internet media type without parameters. Format is type and subtype, separated by slash, where type can contain only alphanumeric, underscore and minus sign, and subtype can contain only alphanumeric, plus and minus sign, underscore and dot.
     */
    @JsonProperty("ContentType")
    public void setContentType(String contentType) {
        this.contentType = contentType;
    }

    /**
     * Character set name may consist of alphanumeric, dot, colon, minus sign, underscore and parentheses (round brackets).
     */
    @JsonProperty("ContentCharset")
    public String getContentCharset() {
        return contentCharset;
    }

    /**
     * Character set name may consist of alphanumeric, dot, colon, minus sign, underscore and parentheses (round brackets).
     */
    @JsonProperty("ContentCharset")
    public void setContentCharset(String contentCharset) {
        this.contentCharset = contentCharset;
    }

    /**
     * May contain only string "base64" (however note that key can be nonexistent, which means native encoding).
     */
    @JsonProperty("ContentEncoding")
    public ContentEncoding getContentEncoding() {
        return contentEncoding;
    }

    /**
     * May contain only string "base64" (however note that key can be nonexistent, which means native encoding).
     */
    @JsonProperty("ContentEncoding")
    public void setContentEncoding(ContentEncoding contentEncoding) {
        this.contentEncoding = contentEncoding;
    }

    /**
     * Attachment content.
     */
    @JsonProperty("Content")
    public String getContent() {
        return content;
    }

    /**
     * Attachment content.
     */
    @JsonProperty("Content")
    public void setContent(String content) {
        this.content = content;
    }

    /**
     * Array of external content IDs.
     */
    @JsonProperty("ContentID")
    public List<String> getContentID() {
        return contentID;
    }

    /**
     * Array of external content IDs.
     */
    @JsonProperty("ContentID")
    public void setContentID(List<String> contentID) {
        this.contentID = contentID;
    }

    /**
     * Array of external URIs.
     */
    @JsonProperty("ExternalURI")
    public List<URI> getExternalURI() {
        return externalURI;
    }

    /**
     * Array of external URIs.
     */
    @JsonProperty("ExternalURI")
    public void setExternalURI(List<URI> externalURI) {
        this.externalURI = externalURI;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

    public enum ContentEncoding {

        BASE_64("base64");
        private final String value;
        private final static Map<String, ContentEncoding> CONSTANTS = new HashMap<String, ContentEncoding>();

        static {
            for (ContentEncoding c : values()) {
                CONSTANTS.put(c.value, c);
            }
        }

        private ContentEncoding(String value) {
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
        public static ContentEncoding fromValue(String value) {
            ContentEncoding constant = CONSTANTS.get(value);
            if (constant == null) {
                throw new IllegalArgumentException(value);
            } else {
                return constant;
            }
        }

    }

}
