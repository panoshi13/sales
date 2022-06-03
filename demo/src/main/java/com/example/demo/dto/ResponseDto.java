package com.example.demo.dto;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class ResponseDto implements Serializable {
    private static final long serialVersionUID = 6126679969361342429L;

    private String codRespuesta;
    private String mensaje;

    public ResponseDto() {
    }

    public ResponseDto(String codRespuesta, String mensaje) {
        this.codRespuesta = codRespuesta;
        this.mensaje = mensaje;
    }

    public static ResponseDto ok() {
        ResponseDto responseDto = new ResponseDto();
        responseDto.setMensaje("TRANSACCION EXITOSA");
        responseDto.setCodRespuesta("200");
        return responseDto;
    }

    public static ResponseDto error() {
        ResponseDto responseDto = new ResponseDto();
        responseDto.setMensaje("Error");
        responseDto.setCodRespuesta("500");
        return responseDto;
    }
}
