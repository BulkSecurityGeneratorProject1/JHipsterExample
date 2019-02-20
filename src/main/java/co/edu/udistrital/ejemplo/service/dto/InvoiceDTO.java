package co.edu.udistrital.ejemplo.service.dto;
import javax.validation.constraints.*;
import java.io.Serializable;
import java.util.Objects;

/**
 * A DTO for the Invoice entity.
 */
public class InvoiceDTO implements Serializable {

    private Long id;

    @NotNull
    private Long itemCount;

    @NotNull
    private Double subTotal;


    private Long clientId;

    private Long discountId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getItemCount() {
        return itemCount;
    }

    public void setItemCount(Long itemCount) {
        this.itemCount = itemCount;
    }

    public Double getSubTotal() {
        return subTotal;
    }

    public void setSubTotal(Double subTotal) {
        this.subTotal = subTotal;
    }

    public Long getClientId() {
        return clientId;
    }

    public void setClientId(Long clientId) {
        this.clientId = clientId;
    }

    public Long getDiscountId() {
        return discountId;
    }

    public void setDiscountId(Long discountId) {
        this.discountId = discountId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        InvoiceDTO invoiceDTO = (InvoiceDTO) o;
        if (invoiceDTO.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), invoiceDTO.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "InvoiceDTO{" +
            "id=" + getId() +
            ", itemCount=" + getItemCount() +
            ", subTotal=" + getSubTotal() +
            ", client=" + getClientId() +
            ", discount=" + getDiscountId() +
            "}";
    }
}
