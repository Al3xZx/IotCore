package com.github.al3xzx.iotcore.model.dto;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;

@Data
@Builder
public class UserDTO {

    private String id;

    private LocalDate creationDate;
}