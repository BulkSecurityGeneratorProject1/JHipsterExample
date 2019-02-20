package co.edu.udistrital.ejemplo.service.dto;
import javax.validation.constraints.*;
import java.io.Serializable;
import java.util.Objects;

/**
 * A DTO for the Discount entity.
 */
public class DiscountDTO implements Serializable {

    private Long id;

    @NotNull
    private Double value;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Double getValue() {
        return value;
    }

    public void setValue(Double value) {
        this.value = value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        DiscountDTO discountDTO = (DiscountDTO) o;
        if (discountDTO.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), discountDTO.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "DiscountDTO{" +
            "id=" + getId() +
            ", value=" + getValue() +
            "}";
    }
}
