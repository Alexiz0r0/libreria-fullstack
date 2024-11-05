package com.egg.biblioteca.model.response;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;


@Setter
@Getter
@NoArgsConstructor
public class ApiResponse {

    // private LocalDate tiempo = LocalDate.now();

    private LocalDateTime time = LocalDateTime.now();

    private String mensaje;

    private String url;

    public ApiResponse(String mensaje, String url) {
        this.mensaje = mensaje;
        this.url = url.replace("uri=", "");
    }
}
