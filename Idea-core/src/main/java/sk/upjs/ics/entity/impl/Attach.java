package sk.upjs.ics.entity.impl;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import sk.upjs.ics.entity.IEntity;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.net.URI;
import java.util.List;

@Entity
@Table(name = "Attach")
public class Attach implements IEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "\"IDATTACH\"", unique = true)
    private Long id;

    @JsonProperty("Content")
    @ApiModelProperty(notes = "Attachment content.")
    @Column(name = "\"CONTENT\"")
    private String content;

    @JsonProperty("ContentCharset")
    @ApiModelProperty(notes = "Character set name may consist of alphanumeric, dot, colon, minus sign, underscore and parentheses (round brackets).")
    @Column(name = "\"CONTENTCHARSET\"")
    private String contentCharset;

    @JsonProperty("ContentEncoding")
    @ApiModelProperty(notes = "May contain only string \"base64\" (however note that key can be nonexistent, which means native encoding).")
    @Column(name = "\"CONTENTENCODING\"")
    private String contentEncoding;

    @JsonProperty("ContentID")
    @Type(type = "jsonStringArray")
    @ApiModelProperty(notes = "Array of external content IDs.")
    @Column(name = "\"CONTENTID\"")
    private List<String> contentId;

    @JsonProperty("ContentType")
    @Column(name = "\"CONTENTTYPE\"")
    @ApiModelProperty(notes = "Internet media type without parameters. Format is type and subtype, separated by slash, where type can contain only alphanumeric, underscore and minus sign, and subtype can contain only alphanumeric, plus and minus sign, underscore and dot.")
    private String contentType;

    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "\"EVENTID\"", referencedColumnName = "\"IDEVENT\"")
    private Event event;

    @JsonProperty("ExternalUri")
    @Type(type = "jsonStringArray")
    @ApiModelProperty(notes = "Array of external URIs.")
    @Column(name = "\"EXTERNALURI\"")
    private List<String> externalUri;

    @JsonProperty("FileName")
    @Type(type = "jsonStringArray")
    @ApiModelProperty(notes = "Array of filenames.")
    @Column(name = "\"FILENAME\"")
    private List<String> fileName;

    @JsonProperty("Handle")
    @ApiModelProperty(notes = "String value unique among all \"Handle\" element values. May contain only alphanumeric or underscore, must not start with number and must not be empty.")
    @Column(name = "\"HANDLE\"")
    private String handle;

    @JsonProperty("Hash")
    @ApiModelProperty(notes = "Array of checksums.")
    @Type(type = "jsonStringArray")
    @Column(name = "\"HASH\"")
    private List<URI> hash;

    @JsonProperty("Note")
    @ApiModelProperty(notes = "Free text human readable additional note.")
    @Column(name = "\"NOTE\"")
    private String note;

    @JsonProperty("Ref")
    @Type(type = "jsonStringArray")
    @ApiModelProperty(notes = "Array of references.")
    @Column(name = "\"REF\"")
    private List<URI> ref;

    @JsonProperty("Size")
    @ApiModelProperty(notes = "JSON \"number\" with no fractional and exponential part.")
    @Column(name = "\"SIZE\"")
    private Integer size;

    @JsonProperty("Type")
    @Type(type = "jsonStringArray")
    @ApiModelProperty(notes = "Array of attachment type tags.")
    @Column(name = "\"TYPE\"")
    private List<String> type;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getContentCharset() {
        return contentCharset;
    }

    public void setContentCharset(String contentCharset) {
        this.contentCharset = contentCharset;
    }

    public String getContentEncoding() {
        return contentEncoding;
    }

    public void setContentEncoding(String contentEncoding) {
        this.contentEncoding = contentEncoding;
    }

    public List<String> getContentId() {
        return contentId;
    }

    public void setContentId(List<String> contentID) {
        this.contentId = contentID;
    }

    public String getContentType() {
        return contentType;
    }

    public void setContentType(String contentType) {
        this.contentType = contentType;
    }

    public Event getEvent() {
        return event;
    }

    public void setEvent(Event event) {
        this.event = event;
    }

    public List<String> getExternalUri() {
        return externalUri;
    }

    public void setExternalUri(List<String> externalUri) {
        this.externalUri = externalUri;
    }

    public List<String> getFileName() {
        return fileName;
    }

    public void setFileName(List<String> fileName) {
        this.fileName = fileName;
    }

    public String getHandle() {
        return handle;
    }

    public void setHandle(String handle) {
        this.handle = handle;
    }

    public List<URI> getHash() {
        return hash;
    }

    public void setHash(List<URI> hash) {
        this.hash = hash;
    }

    public List<URI> getRef() {
        return ref;
    }

    public void setRef(List<URI> ref) {
        this.ref = ref;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public Integer getSize() {
        return size;
    }

    public void setSize(Integer size) {
        this.size = size;
    }

    public List<String> getType() {
        return type;
    }

    public void setType(List<String> type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "Attach{" +
                "id=" + id +
                '}';
    }
}
