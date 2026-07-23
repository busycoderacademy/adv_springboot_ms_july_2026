package com.bankapp.dto;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class ErrorInfoDto {
    private String timestamp;
    private int status;
    private String error;
    private String path;
    private String toContact;
}
