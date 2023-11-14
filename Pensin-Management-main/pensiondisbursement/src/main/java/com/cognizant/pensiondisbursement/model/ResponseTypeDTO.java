package com.cognizant.pensiondisbursement.model;

import java.io.Serializable;
import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ResponseTypeDTO implements Serializable {
	
	private static final long serialVersionUID = -2307425779840174124L;
	
    @JsonProperty("errorMessage")
    private String errMsg;
    
    @JsonProperty("errorDetails")
    private HttpStatus errDetail;
    
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd hh:mm:ss")
    @JsonProperty("timestamp")
    private LocalDateTime timestamp;
   
    @JsonProperty("status")
    private Integer status;

}
