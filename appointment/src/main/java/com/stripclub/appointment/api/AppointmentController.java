package com.stripclub.appointment.api;
import com.stripclub.appointment.api.dto.AppUserServiceDto;
import com.stripclub.appointment.service.AppointmentService;

import com.stripclub.appointment.repo.model.Appointment;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/appointments")
public class AppointmentController {

    private final AppointmentService appointmentService;

    @GetMapping
    public ResponseEntity<List<Appointment>> index() {
        final List<Appointment> appointments = appointmentService.fetchAll();
        return ResponseEntity.ok(appointments);
    }

    @GetMapping("/{id}")
    public ResponseEntity<AppUserServiceDto> show(@PathVariable long id) {
        try {
            final AppUserServiceDto appUserServiceDto = appointmentService.fetchById(id);
            return ResponseEntity.ok(appUserServiceDto);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<Void> create(@RequestBody com.stripclub.appointment.api.dto.Appointment appointment) {
        final long idUser = appointment.getIdUser();
        final long idService= appointment.getIdService();
        final long status = appointment.getStatus();
        final long appointmentId = appointmentService.create( idUser, idService, status);
        final String appointmentUri = String.format("/appointments/%d", appointmentId);

        return ResponseEntity.created(URI.create(appointmentUri)).build();
    }
    @PatchMapping("/{id}")
    public ResponseEntity<Void> change(@PathVariable long id, @RequestBody com.stripclub.appointment.api.dto.Appointment appointment) {
        final long idUser = appointment.getIdUser();
        try {
            appointmentService.updateAppointment(id,idUser);
            return ResponseEntity.noContent().build();
        } catch (IllegalArgumentException e) {
            return ResponseEntity.notFound().build();
        }
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable long id) {
        appointmentService.deleteAppointment(id);
        return ResponseEntity.noContent().build();
    }

}
