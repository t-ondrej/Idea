package entity.impl;

import entity.IEntity;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by Tomas on 8.11.2017.
 */

@Entity
@Table(name = "EVENT", schema = "events")
public class Event implements IEntity {

    @Id
    @Column(name = "\"IDEVENT\"")
    private String id;

    @Type(type = "jsonStringArray")
    @Column(name = "\"AGGRID\"")
    private String aggrID;

    @Type(type = "jsonStringArray")
    @Column(name = "\"ALTNAMES\"")
    private String altnames;

    @Column(name = "\"BYTECOUNT\"")
    private int byteCount;

    @Type(type = "jsonStringArray")
    @Column(name = "\"CATEGORY\"")
    private List<String> category;

    @Column(name = "\"CEASETIME\"")
    private Date ceaseTime;

    @Column(name = "\"CONFIDENCE\"")
    private int confidence;

    @Column(name = "\"CONNCOUNT\"")
    private int connCount;

    @Type(type = "jsonStringArray")
    @Column(name = "\"CORRELID\"")
    private String correlID;

    @Column(name = "\"CREATETIME\"")
    private Date createTime;

    @Column(name = "\"DESCRIPTION\"")
    private String description;

    @Column(name = "\"DETECTTIME\"")
    private Date detectTime;

    @Column(name = "\"EVENTTIME\"")
    private Date eventTime;

    @Column(name = "\"FLOWCOUNT\"")
    private int flowCount;

    @Column(name = "\"FORMAT\"")
    private String format;

    @Column(name = "\"NOTE\"")
    private String note;

    @Column(name = "\"PACKETCOUNT\"")
    private int packetCount;

    @Type(type = "jsonStringArray")
    @Column(name = "\"PREDID\"")
    private String predID;

    @Type(type = "jsonStringArray")
    @Column(name = "\"REF\"")
    private String ref;

    @Type(type = "jsonStringArray")
    @Column(name = "\"RELID\"")
    private String relID;

    @Column(name = "\"WINENDTIME\"")
    private Date winEndTime;

    @Column(name = "\"WINSTARTTIME\"")
    private Date winStartTime;

    @OneToMany(mappedBy = "event", cascade = CascadeType.ALL)
    private List<Attach> attachs = new ArrayList<>();

    @OneToMany(mappedBy = "event", cascade = CascadeType.ALL)
    private List<Node> nodes = new ArrayList<>();

    @OneToMany(mappedBy = "event", cascade = CascadeType.ALL)
    private List<Source> sources = new ArrayList<>();

    @OneToMany(mappedBy = "event", cascade = CascadeType.ALL)
    private List<Target> targets = new ArrayList<>();

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getAggrID() {
        return aggrID;
    }

    public void setAggrID(String aggrID) {
        this.aggrID = aggrID;
    }

    public String getAltnames() {
        return altnames;
    }

    public void setAltnames(String altnames) {
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

    public String getCorrelID() {
        return correlID;
    }

    public void setCorrelID(String correlID) {
        this.correlID = correlID;
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

    public String getPredID() {
        return predID;
    }

    public void setPredID(String predID) {
        this.predID = predID;
    }

    public String getRef() {
        return ref;
    }

    public void setRef(String ref) {
        this.ref = ref;
    }

    public String getRelID() {
        return relID;
    }

    public void setRelID(String relID) {
        this.relID = relID;
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
