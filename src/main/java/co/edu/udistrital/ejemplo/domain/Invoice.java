package co.edu.udistrital.ejemplo.domain;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;
import javax.validation.constraints.*;

import java.io.Serializable;
import java.util.Objects;

/**
 * A Invoice.
 */
@Entity
@Table(name = "invoice")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class Invoice implements Serializable {

    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Column(name = "item_count", nullable = false)
    private Long itemCount;

    @NotNull
    @Column(name = "sub_total", nullable = false)
    private Double subTotal;

    @ManyToOne
    @JsonIgnoreProperties("invoices")
    private Client client;

    @OneToOne
    @JoinColumn(unique = true)
    private Discount discount;

    // jhipster-needle-entity-add-field - JHipster will add fields here, do not remove
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getItemCount() {
        return itemCount;
    }

    public Invoice itemCount(Long itemCount) {
        this.itemCount = itemCount;
        return this;
    }

    public void setItemCount(Long itemCount) {
        this.itemCount = itemCount;
    }

    public Double getSubTotal() {
        return subTotal;
    }

    public Invoice subTotal(Double subTotal) {
        this.subTotal = subTotal;
        return this;
    }

    public void setSubTotal(Double subTotal) {
        this.subTotal = subTotal;
    }

    public Client getClient() {
        return client;
    }

    public Invoice client(Client client) {
        this.client = client;
        return this;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Discount getDiscount() {
        return discount;
    }

    public Invoice discount(Discount discount) {
        this.discount = discount;
        return this;
    }

    public void setDiscount(Discount discount) {
        this.discount = discount;
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
        Invoice invoice = (Invoice) o;
        if (invoice.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), invoice.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "Invoice{" +
            "id=" + getId() +
            ", itemCount=" + getItemCount() +
            ", subTotal=" + getSubTotal() +
            "}";
    }
}
