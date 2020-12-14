package com.alfresco.api.v1.dto;

import lombok.*;

import java.io.Serializable;

@Getter @Setter
@Builder
@AllArgsConstructor @NoArgsConstructor
public class ErrorDto implements Serializable {
    private String message;
}
