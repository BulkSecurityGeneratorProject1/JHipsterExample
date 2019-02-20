package co.edu.udistrital.ejemplo.service.dto;
import javax.validation.constraints.*;
import java.io.Serializable;
import java.util.Objects;

/**
 * A DTO for the Telephone entity.
 */
public class TelephoneDTO implements Serializable {

    private Long id;

    @NotNull
    private Long number;


    private Long clientId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getNumber() {
        return number;
    }

    public void setNumber(Long number) {
        this.number = number;
    }

    public Long getClientId() {
        return clientId;
    }

    public void setClientId(Long clientId) {
        this.clientId = clientId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        TelephoneDTO telephoneDTO = (TelephoneDTO) o;
        if (telephoneDTO.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), telephoneDTO.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "TelephoneDTO{" +
            "id=" + getId() +
            ", number=" + getNumber() +
            ", client=" + getClientId() +
            "}";
    }
}
