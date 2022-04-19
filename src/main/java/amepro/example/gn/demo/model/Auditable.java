package amepro.example.gn.demo.model;


import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import javax.persistence.Temporal;
import java.util.Date;
import static javax.persistence.TemporalType.TIMESTAMP;

@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public abstract class Auditable<T> {

    @Column(name = "created_date", updatable = false)
    @Temporal(TIMESTAMP)
    @CreatedBy
    protected Date creationDate;

    @Column(name = "lastMod_date")
    @LastModifiedDate
    @Temporal(TIMESTAMP)
    protected Date lastModifiedDate;

    @CreatedBy
    @Column(name="created_by")
    protected T createdBy;

    @LastModifiedBy
    @Column(name="modified_by")
    protected T modifiedBy;

    public Auditable() {
    }

    public Auditable(Date creationDate, Date lastModifiedDate, T createdBy, T modifiedBy) {
        this.creationDate = creationDate;
        this.lastModifiedDate = lastModifiedDate;
        this.createdBy = createdBy;
        this.modifiedBy = modifiedBy;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public Date getLastModifiedDate() {
        return lastModifiedDate;
    }

    public void setLastModifiedDate(Date lastModifiedDate) {
        this.lastModifiedDate = lastModifiedDate;
    }

    public T getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(T createdBy) {
        this.createdBy = createdBy;
    }

    public T getModifiedBy() {
        return modifiedBy;
    }

    public void setModifiedBy(T modifiedBy) {
        this.modifiedBy = modifiedBy;
    }

    @Override
    public String toString() {
        return "Auditable{" +
                "creationDate=" + creationDate +
                ", lastModifiedDate=" + lastModifiedDate +
                ", createdBy=" + createdBy +
                ", modifiedBy=" + modifiedBy +
                '}';
    }
}
