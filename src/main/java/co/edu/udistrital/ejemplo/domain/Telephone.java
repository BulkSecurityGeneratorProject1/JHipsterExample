package co.edu.udistrital.ejemplo.domain;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;
import javax.validation.constraints.*;

import java.io.Serializable;
import java.util.Objects;

/**
 * A Telephone.
 */
@Entity
@Table(name = "telephone")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class Telephone implements Serializable {

    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Column(name = "jhi_number", nullable = false)
    private Long number;

    @ManyToOne
    @JsonIgnoreProperties("telephones")
    private Client client;

    // jhipster-needle-entity-add-field - JHipster will add fields here, do not remove
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getNumber() {
        return number;
    }

    public Telephone number(Long number) {
        this.number = number;
        return this;
    }

    public void setNumber(Long number) {
        this.number = number;
    }

    public Client getClient() {
        return client;
    }

    public Telephone client(Client client) {
        this.client = client;
        return this;
    }

    public void setClient(Client client) {
        this.client = client;
    }
    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here, do not remove

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Telephone telephone = (Telephone) o;
        if (telephone.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), telephone.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "Telephone{" +
            "id=" + getId() +
            ", number=" + getNumber() +
            "}";
    }
}
