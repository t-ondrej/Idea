package sk.upjs.ics.entity.impl;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import sk.upjs.ics.entity.IEntity;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by Tomas on 8.11.2017.
 */

@Entity
@Table(name = "Event")
public class Event implements IEntity {

    @JsonProperty("ID")
    @Id
    @ApiModelProperty(notes = "String, containing reasonably globally unique identifier. UUID version 4 (random) or 5 (SHA-1) is recommended. As IDs are meant to be used at other mediums, transfer protocols and formats (an example being query string fields in URL), they are allowed to contain only reasonably safe subset of characters. May thus contain only alphanumeric, dot, minus sign and underscore and must not be empty.", required = true)
    @Column(name = "\"IDEVENT\"")
    private String id;

    @JsonProperty("AggrID")
    @Type(type = "jsonStringArray")
    @ApiModelProperty(notes = "Array of aggregated messages identifiers.")
    @Column(name = "\"AGGRID\"")
    private List<String> aggrId = new ArrayList<>();

    @JsonProperty("AltNames")
    @Type(type = "jsonStringArray")
    @ApiModelProperty(notes = "Array of alternative identifiers.")
    @Column(name = "\"ALTNAMES\"")
    private List<String> altnames = new ArrayList<>();

    @JsonProperty("ByteCount")
    @ApiModelProperty(notes = "JSON \"number\" with no fractional and exponential part.")
    @Column(name = "\"BYTECOUNT\"")
    private int byteCount;

    @JsonProperty("Category")
    @Type(type = "jsonStringArray")
    @ApiModelProperty(notes = "Array of event categories.", required = true)
    @Column(name = "\"CATEGORY\"")
    private List<String> category = new ArrayList<>();

    @JsonProperty("CeaseTime")
    @ApiModelProperty(notes = "String, containing timestamp conforming to [[http://tools.ietf.org/html/rfc3339|RFC 3339]].")
    @Column(name = "\"CEASETIME\"")
    private Date ceaseTime;

    @JsonProperty("Confidence")
    @ApiModelProperty(notes = "Confidence of detector in its own reliability of this particular detection. (0 – surely false, 1 – no doubts). If key is not presented, detector does not know (or has no capability to estimate the confidence).")
    @Column(name = "\"CONFIDENCE\"")
    private int confidence;

    @JsonProperty("ConnCount")
    @ApiModelProperty(notes = "JSON \"number\" with no fractional and exponential part.")
    @Column(name = "\"CONNCOUNT\"")
    private int connCount;

    @JsonProperty("CorrelID")
    @Type(type = "jsonStringArray")
    @ApiModelProperty(notes = "Array of correlated messages identifiers.")
    @Column(name = "\"CORRELID\"")
    private List<String> correlId = new ArrayList<>();

    @JsonProperty("CreateTime")
    @ApiModelProperty(notes = "String, containing timestamp conforming to [[http://tools.ietf.org/html/rfc3339|RFC 3339]].")
    @Column(name = "\"CREATETIME\"")
    private Date createTime;

    @JsonProperty("Description")
    @ApiModelProperty(notes = "Short free text human readable description.")
    @Column(name = "\"DESCRIPTION\"")
    private String description;

    @JsonProperty("DetectTime")
    @ApiModelProperty(notes = "String, containing timestamp conforming to [[http://tools.ietf.org/html/rfc3339|RFC 3339]].", required = true)
    @Column(name = "\"DETECTTIME\"")
    private Date detectTime;

    @JsonProperty("EventTime")
    @ApiModelProperty(notes = "String, containing timestamp conforming to [[http://tools.ietf.org/html/rfc3339|RFC 3339]].")
    @Column(name = "\"EVENTTIME\"")
    private Date eventTime;

    @JsonProperty("FlowCount")
    @ApiModelProperty(notes = "JSON \"number\" with no fractional and exponential part.")
    @Column(name = "\"FLOWCOUNT\"")
    private int flowCount;

    @JsonProperty("Format")
    @ApiModelProperty(notes = "Must contain string \"IDEA0\". (Trailing zero denotes draft version, after review/discussion and specification finalisation the name will change.)", required = true)
    @Column(name = "\"FORMAT\"")
    private String format;

    @JsonProperty("Note")
    @ApiModelProperty(notes = "Free text human readable addidional note, possibly longer description of incident if not obvious.")
    @Column(name = "\"NOTE\"")
    private String note;

    @JsonProperty("PacketCount")
    @ApiModelProperty(notes = "JSON \"number\" with no fractional and exponential part.")
    @Column(name = "\"PACKETCOUNT\"")
    private int packetCount;

    @JsonProperty("PredID")
    @Type(type = "jsonStringArray")
    @ApiModelProperty(notes = "Array of obsoleted messages identifiers.")
    @Column(name = "\"PREDID\"")
    private List<String> predId = new ArrayList<>();

    @JsonProperty("Ref")
    @Type(type = "jsonStringArray")
    @ApiModelProperty(notes = "Array of references.")
    @Column(name = "\"REF\"")
    private List<String> ref = new ArrayList<>();

    @JsonProperty("RelID")
    @Type(type = "jsonStringArray")
    @ApiModelProperty(notes = "Array of related messages identifiers.")
    @Column(name = "\"RELID\"")
    private List<String> relId = new ArrayList<>();

    @JsonProperty("WinEndTime")
    @ApiModelProperty(notes = "String, containing timestamp conforming to [[http://tools.ietf.org/html/rfc3339|RFC 3339]].")
    @Column(name = "\"WINENDTIME\"")
    private Date winEndTime;

    @JsonProperty("WinStartTime")
    @ApiModelProperty(notes = "String, containing timestamp conforming to [[http://tools.ietf.org/html/rfc3339|RFC 3339]].")
    @Column(name = "\"WINSTARTTIME\"")
    private Date winStartTime;

    @JsonProperty("Attach")
    @JsonManagedReference
    @OneToMany(mappedBy = "event", cascade = CascadeType.ALL)
    private List<Attach> attachs = new ArrayList<>();

    @JsonProperty("Node")
    @JsonManagedReference
    @OneToMany(mappedBy = "event", cascade = CascadeType.ALL)
    private List<Node> nodes = new ArrayList<>();

    @JsonProperty("Source")
    @JsonManagedReference
    @OneToMany(mappedBy = "event", cascade = CascadeType.ALL)
    private List<Source> sources = new ArrayList<>();

    @JsonProperty("Target")
    @JsonManagedReference
    @OneToMany(mappedBy = "event", cascade = CascadeType.ALL)
    private List<Target> targets = new ArrayList<>();

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public List<String> getAggrId() {
        return aggrId;
    }

    public void setAggrId(List<String> aggrID) {
        this.aggrId = aggrID;
    }

    public List<String> getAltnames() {
        return altnames;
    }

    public void setAltnames(List<String> altnames) {
        this.altnames = altnames;
    }

    public int getByteCount() {
        return byteCount;
    }

    public void setByteCount(int byteCount) {
        this.byteCount = byteCount;
    }

    public List<String> getCategory() {
        return this.category;
    }

    public void setCategory(List<String> category) {
        this.category = category;
    }

    public Date getCeaseTime() {
        return ceaseTime;
    }

    public void setCeaseTime(Date ceaseTime) {
        this.ceaseTime = ceaseTime;
    }

    public int getConfidence() {
        return confidence;
    }

    public void setConfidence(int confidence) {
        this.confidence = confidence;
    }

    public int getConnCount() {
        return connCount;
    }

    public void setConnCount(int connCount) {
        this.connCount = connCount;
    }

    public List<String> getCorrelID() {
        return correlId;
    }

    public void setCorrelID(List<String> correlID) {
        this.correlId = correlID;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getDetectTime() {
        return detectTime;
    }

    public void setDetectTime(Date detectTime) {
        this.detectTime = detectTime;
    }

    public Date getEventTime() {
        return eventTime;
    }

    public void setEventTime(Date eventTime) {
        this.eventTime = eventTime;
    }

    public int getFlowCount() {
        return flowCount;
    }

    public void setFlowCount(int flowCount) {
        this.flowCount = flowCount;
    }

    public String getFormat() {
        return format;
    }

    public void setFormat(String format) {
        this.format = format;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public int getPacketCount() {
        return packetCount;
    }

    public void setPacketCount(int packetCount) {
        this.packetCount = packetCount;
    }

    public List<String> getPredId() {
        return predId;
    }

    public void setPredId(List<String> predID) {
        this.predId = predID;
    }

    public List<String> getRef() {
        return ref;
    }

    public void setRef(List<String> ref) {
        this.ref = ref;
    }

    public List<String> getRelId() {
        return relId;
    }

    public void setRelId(List<String> relID) {
        this.relId = relID;
    }

    public Date getWinEndTime() {
        return winEndTime;
    }

    public void setWinEndTime(Date winEndTime) {
        this.winEndTime = winEndTime;
    }

    public Date getWinStartTime() {
        return winStartTime;
    }

    public void setWinStartTime(Date winStartTime) {
        this.winStartTime = winStartTime;
    }

    public List<Attach> getAttachs() {
        return attachs;
    }

    public void setAttachs(List<Attach> attachs) {
        this.attachs = attachs;
    }

    public List<Node> getNodes() {
        return nodes;
    }

    public void setNodes(List<Node> nodes) {
        this.nodes = nodes;
    }

    public List<Source> getSources() {
        return sources;
    }

    public void setSources(List<Source> sources) {
        this.sources = sources;
    }

    public List<Target> getTargets() {
        return targets;
    }

    public void setTargets(List<Target> targets) {
        this.targets = targets;
    }

    @Override
    public String toString() {
        return "Event{" +
                "id='" + id + '\'' +
                '}';
    }
}
