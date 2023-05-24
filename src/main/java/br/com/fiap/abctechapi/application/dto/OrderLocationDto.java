package br.com.fiap.abctechapi.application.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.PastOrPresent;
import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class OrderLocationDto {

    private Double latitude;
    private Double longitude;

    @PastOrPresent
    @JsonProperty("dateTime")
    private Date date;


    public OrderLocationDto(String ruaA, String number, String sãoPaulo, String sp, String brasil) {
    }
}
