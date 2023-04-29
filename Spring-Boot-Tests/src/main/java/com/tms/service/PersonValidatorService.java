package com.tms.service;

import com.tms.dto.PersonDto;
import org.springframework.stereotype.Service;

import static java.util.Objects.isNull;
import static org.apache.commons.lang3.StringUtils.isBlank;

@Service
public class PersonValidatorService {

    public boolean isValid(PersonDto personDto) {

        if (isNull(personDto)) {
            return false;
        }

        if (isBlank(personDto.getUsername())) {
            return false;
        }

        return true;

    }

}
