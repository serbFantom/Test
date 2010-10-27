package com.serb.sorting.opreg_test;

import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import java.io.Serializable;

/**
 * Created by sbezugliy
 * Date: 30.09.2009
 */
public class TNB implements Serializable {
    private long oid;
    private String name;
    private String portingId;
    private String contactPersonAdministrativ;
    private String contactPersonTechnical;
    private String exchange;
    private String show;
    private String status;

    public TNB() {
    }

    public TNB(TNB proxy) {
        if (proxy != null) {
            this.oid = proxy.getOid();
        }
    }

    public long getOid() {
        return oid;
    }

    public void setOid(long oid) {
        this.oid = oid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPortingId() {
        return portingId;
    }

    public void setPortingId(String portingId) {
        this.portingId = portingId;
    }

    public String getContactPersonAdministrativ() {
        return contactPersonAdministrativ;
    }

    public void setContactPersonAdministrativ(String contactPersonAdministrativ) {
        this.contactPersonAdministrativ = contactPersonAdministrativ;
    }

    public String getContactPersonTechnical() {
        return contactPersonTechnical;
    }

    public void setContactPersonTechnical(String contactPersonTechnical) {
        this.contactPersonTechnical = contactPersonTechnical;
    }

    public String getExchange() {
        return exchange;
    }

    public void setExchange(String exchange) {
        this.exchange = exchange;
    }

    public String getShow() {
        return show;
    }

    public void setShow(String show) {
        this.show = show;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().
                append(oid).
                append(name).
                append(portingId).
                append(contactPersonAdministrativ).
                append(contactPersonTechnical).
                append(exchange).
                append(show).
                append(status).
                toHashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return this == obj || obj instanceof TNB && this.equals((TNB) obj);
    }

    public boolean equals(TNB that) {
        return this == that || new EqualsBuilder().
                append(this.oid, that.oid).
                append(this.name, that.name).
                append(this.portingId, that.portingId).
                append(this.contactPersonAdministrativ, that.contactPersonAdministrativ).
                append(this.contactPersonTechnical, that.contactPersonTechnical).
                append(this.exchange, that.exchange).
                append(this.show, that.show).
                append(this.status, that.status).
                isEquals();
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.SIMPLE_STYLE).
                append("OID", oid).
                append("Name", name).
                append("Porting Id", portingId).
                append("Contact Person Administrativ", contactPersonAdministrativ).
                append("Contact Person Technical", contactPersonTechnical).
                append("Substitution", exchange).
                append("Show", show).
                append("Status", status).
                toString();

    }

    /**
     * TNB is active in case of substitution = "Y"
     * @return boolean, if TNB is active, then "true", else - "false"
     */
    public boolean isActive() {
        return this.exchange.equalsIgnoreCase("yes");
    }
}

