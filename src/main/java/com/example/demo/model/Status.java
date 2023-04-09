package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Status {

    @Builder.Default
    @JsonProperty("message")
    private String message= "SUCCESS";

    @Builder.Default
    @JsonProperty("code")
    private String code= "200";

    @Builder.Default
    @JsonProperty("message")
    private Boolean success= true;
}
