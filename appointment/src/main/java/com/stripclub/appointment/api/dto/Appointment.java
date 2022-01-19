package com.stripclub.appointment.api.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public final class Appointment {
    private long idUser;
    private long idService;
    private long status;

}
;