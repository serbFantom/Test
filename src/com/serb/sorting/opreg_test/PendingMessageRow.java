package com.serb.sorting.opreg_test;

/**
 * Created by sbezugliy
 * Date: 30.09.2009
 */
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import java.io.Serializable;
import java.util.Date;

/**
 * User: bratc
 * Date: Aug 19, 2009
 * Time: 1:57:24 PM
 */
public class PendingMessageRow implements Serializable {
    private long oid;
    private String type;
    private long number1;
    private long number2;
    private Date portingDate;
    private String mediaName;
    private Date mediaDate;
    private int errorId;
    private PendingMessageRowStatus status;
    private Date created;

    private TNB orignTnb;
    private TNB tnbReceiving;
    private TNB tnbReleasing;

    //private MessageRow mediaLine;

    public long getOid() {
        return oid;
    }

    public void setOid(long oid) {
        this.oid = oid;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public long getNumber1() {
        return number1;
    }

    public void setNumber1(long number1) {
        this.number1 = number1;
    }

    public long getNumber2() {
        return number2;
    }

    public void setNumber2(long number2) {
        this.number2 = number2;
    }

    public Date getPortingDate() {
        return portingDate;
    }

    public void setPortingDate(Date portingDate) {
        this.portingDate = portingDate;
    }

    public String getMediaName() {
        return mediaName;
    }

    public void setMediaName(String mediaName) {
        this.mediaName = mediaName;
    }

    public Date getMediaDate() {
        return mediaDate;
    }

    public void setMediaDate(Date mediaDate) {
        this.mediaDate = mediaDate;
    }

    public int getErrorId() {
        return errorId;
    }

    public void setErrorId(int errorId) {
        this.errorId = errorId;
    }

    public PendingMessageRowStatus getStatus() {
        return status;
    }

    public void setStatus(PendingMessageRowStatus status) {
        this.status = status;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public TNB getOrignTnb() {
        return orignTnb;
    }

    public void setOrignTnb(TNB orignTnb) {
        this.orignTnb = orignTnb;
    }

    public TNB getTnbReceiving() {
        return tnbReceiving;
    }

    public void setTnbReceiving(TNB tnbReceiving) {
        this.tnbReceiving = tnbReceiving;
    }

    public TNB getTnbReleasing() {
        return tnbReleasing;
    }

    public void setTnbReleasing(TNB tnbReleasing) {
        this.tnbReleasing = tnbReleasing;
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().
                append(oid).
                append(type).
                append(orignTnb).
                append(number1).
                append(number2).
                append(tnbReceiving).
                append(tnbReleasing).
                append(portingDate).
                append(mediaName).
                append(mediaDate).
                append(errorId).
                append(status).
/*                append(mediaLine).*/
                append(created).
                toHashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return this == obj || obj instanceof PendingMessageRow && this.equals((PendingMessageRow) obj);
    }

    public boolean equals(PendingMessageRow that) {
        return this == that || new EqualsBuilder().
                append(this.oid, that.oid).
                append(this.type, that.type).
                append(this.orignTnb, that.orignTnb).
                append(this.number1, that.number1).
                append(this.number2, that.number2).
                append(this.tnbReceiving, that.tnbReceiving).
                append(this.tnbReleasing, that.tnbReleasing).
                append(this.portingDate, that.portingDate).
                append(this.mediaName, that.mediaName).
                append(this.mediaDate, that.mediaDate).
                append(this.errorId, that.errorId).
                append(this.status, that.status).
/*                append(this.mediaLine, that.mediaLine).*/
                append(this.created, that.created).
                isEquals();
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.DEFAULT_STYLE).
                append("OID", oid).
                append("Type", type).
                append("Orign TNB", orignTnb).
                append("Number1", number1).
                append("Number2", number2).
                append("TNB Receiving", tnbReceiving).
                append("TNB Releasing", tnbReleasing).
                append("Porting Date", portingDate).
                append("Media Name", mediaName).
                append("Media Date", mediaDate).
                append("Error ID", errorId).
                append("Status", status).
/*                append("Media Line", mediaLine).*/
                append("Created Date", created).
                toString();
    }

    public String getParsedMessageType() {
        return type;
    }
}

/*public class PendingMessageRow {
}*/
