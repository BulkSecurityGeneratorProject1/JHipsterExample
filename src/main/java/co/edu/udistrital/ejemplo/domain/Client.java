package co.edu.udistrital.ejemplo.domain;


import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;
import javax.validation.constraints.*;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import java.util.Objects;

/**
 * A Client.
 */
@Entity
@Table(name = "client")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class Client implements Serializable {

    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Column(name = "name", nullable = false)
    private String name;

    @OneToMany(mappedBy = "client")
    @Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
    private Set<Address> addresses = new HashSet<>();
    @OneToMany(mappedBy = "client")
    @Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
    private Set<Telephone> telephones = new HashSet<>();
    @OneToMany(mappedBy = "client")
    @Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
    private Set<Invoice> invoices = new HashSet<>();
    // jhipster-needle-entity-add-field - JHipster will add fields here, do not remove
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public Client name(String name) {
        this.name = name;
        return this;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Address> getAddresses() {
        return addresses;
    }

    public Client addresses(Set<Address> addresses) {
        this.addresses = addresses;
        return this;
    }

    public Client addAddresses(Address address) {
        this.addresses.add(address);
        address.setClient(this);
        return this;
    }

    public Client removeAddresses(Address address) {
        this.addresses.remove(address);
        address.setClient(null);
        return this;
    }

    public void setAddresses(Set<Address> addresses) {
        this.addresses = addresses;
    }

    public Set<Telephone> getTelephones() {
        return telephones;
    }

    public Client telephones(Set<Telephone> telephones) {
        this.telephones = telephones;
        return this;
    }

    public Client addTelephones(Telephone telephone) {
        this.telephones.add(telephone);
        telephone.setClient(this);
        return this;
    }

    public Client removeTelephones(Telephone telephone) {
        this.telephones.remove(telephone);
        telephone.setClient(null);
        return this;
    }

    public void setTelephones(Set<Telephone> telephones) {
        this.telephones = telephones;
    }

    public Set<Invoice> getInvoices() {
        return invoices;
    }

    public Client invoices(Set<Invoice> invoices) {
        this.invoices = invoices;
        return this;
    }

    public Client addInvoices(Invoice invoice) {
        this.invoices.add(invoice);
        invoice.setClient(this);
        return this;
    }

    public Client removeInvoices(Invoice invoice) {
        this.invoices.remove(invoice);
        invoice.setClient(null);
        return this;
    }

    public void setInvoices(Set<Invoice> invoices) {
        this.invoices = invoices;
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
        Client client = (Client) o;
        if (client.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), client.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "Client{" +
            "id=" + getId() +
            ", name='" + getName() + "'" +
            "}";
    }
}
