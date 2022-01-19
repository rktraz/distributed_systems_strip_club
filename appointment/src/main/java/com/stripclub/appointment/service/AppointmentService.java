package com.stripclub.appointment.service;

import com.stripclub.appointment.api.dto.AppUserServiceDto;
import com.stripclub.appointment.api.dto.ServiceType;
import com.stripclub.appointment.api.dto.User;
import com.stripclub.appointment.repo.AppointmentRepository;
import com.stripclub.appointment.repo.model.Appointment;
import com.stripclub.appointment.request.ServiceTypeRequest;
import com.stripclub.appointment.request.UserRequest;
import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class AppointmentService {
    private final AppointmentRepository appointmentRepository;

    public List<Appointment> fetchAll() {
        return appointmentRepository.findAll();
    }

    public Long create(long idUser, long idService, long status) throws IllegalArgumentException {

        final Appointment appointment = new Appointment(idUser, idService, status);
        final Appointment savedAppointment = appointmentRepository.save(appointment);
        return savedAppointment.getIdAppointment();
    }

    public AppUserServiceDto fetchById(long id) throws IllegalArgumentException {
        final Optional<Appointment> maybeAppointment = appointmentRepository.findById(id);
        if (maybeAppointment.isEmpty()) throw new IllegalArgumentException("Appointment not found");
        Appointment newAppointment = maybeAppointment.get();
        User newUser = UserRequest.getUserById(newAppointment.getIdUser());
        ServiceType newServiceType = ServiceTypeRequest.getServiceTypeById(newAppointment.getIdService());
        return new AppUserServiceDto(newAppointment.getIdUser(), newUser.getFirstname(), newUser.getLastname()
                , newUser.getPhoneNumber(), newAppointment.getIdService(), newServiceType.getServiceType(),
                newServiceType.getServicePrice(),newAppointment.getStatus());
    }

    public void updateAppointment(long idAppointment, long status) throws IllegalArgumentException {
        final Optional<Appointment> maybeAppointment = appointmentRepository.findById(idAppointment);

        if (maybeAppointment.isEmpty())
            throw new IllegalArgumentException("Invalid Appointment ID");

        final Appointment appointment = maybeAppointment.get();
        if (status != 0) appointment.setStatus(status);
        appointmentRepository.save(appointment);
    }

    public void deleteAppointment(long id) {
        appointmentRepository.deleteById(id);
    }


}


