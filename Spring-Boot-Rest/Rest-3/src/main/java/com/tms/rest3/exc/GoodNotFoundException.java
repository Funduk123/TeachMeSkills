package com.tms.rest3.exc;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GoodNotFoundException extends RuntimeException {

    private String error;

}
