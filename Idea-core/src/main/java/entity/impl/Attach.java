package entity.impl;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonProperty;
import entity.IEntity;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.net.URI;
import java.util.List;

@Entity
@Table(name = "Attach", schema = "events")
public class Attach implements IEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "\"IDATTACH\"", unique = true)
    private Long id;

    @JsonProperty("Content")
    @Column(name = "\"CONTENT\"")
    private String content;

    @JsonProperty("ContentCharset")
    @Column(name = "\"CONTENTCHARSET\"")
    private String contentCharset;

    @JsonProperty("ContentEncoding")
    @Column(name = "\"CONTENTENCODING\"")
    private String contentEncoding;

    @JsonProperty("ContentID")
    @Type(type = "jsonStringArray")
    @Column(name = "\"CONTENTID\"")
    private List<String> contentID;

    @JsonProperty("ContentType")
    @Column(name = "\"CONTENTTYPE\"")
    private String contentType;

    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "\"EVENTID\"", referencedColumnName = "\"IDEVENT\"")
    private Event event;

    @JsonProperty("ExternalUri")
    @Type(type = "jsonStringArray")
    @Column(name = "\"EXTERNALURI\"")
    private List<String> externalUri;

    @JsonProperty("FileName")
    @Type(type = "jsonStringArray")
    @Column(name = "\"FILENAME\"")
    private List<String> fileName;

    @JsonProperty("Handle")
    @Column(name = "\"HANDLE\"")
    private String handle;

    @JsonProperty("Hash")
    @Type(type = "jsonStringArray")
    @Column(name = "\"HASH\"")
    private List<URI> hash;

    @JsonProperty("Note")
    @Column(name = "\"NOTE\"")
    private String note;

    @JsonProperty("Ref")
    @Type(type = "jsonStringArray")
    @Column(name = "\"REF\"")
    private List<URI> ref;

    @JsonProperty("Size")
    @Column(name = "\"SIZE\"")
    private Integer size;

    @JsonProperty("Type")
    @Type(type = "jsonStringArray")
    @Column(name = "\"TYPE\"")
    private List<String> type;

    public Long getID() {
        return id;
    }

    public void setID(Long ID) {
        this.id = ID;
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

    public List<String> getContentID() {
        return contentID;
    }

    public void setContentID(List<String> contentID) {
        this.contentID = contentID;
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
