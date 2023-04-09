package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Status {

    @JsonProperty("message")
    private String message= "SUCCESS";

    @JsonProperty("code")
    private String code= "200";

    @JsonProperty("message")
    private Boolean success= true;
}
