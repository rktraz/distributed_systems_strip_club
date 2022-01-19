package com.stripclub.appointment.repo.model;
import javax.persistence.*;

@Entity
@Table(name = "appointment")
public class Appointment {
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    @Column(name = "id_appointment")
    private long idAppointment;

    @Column(name = "id_user")
    private long idUser;

    @Column(name = "id_service")
    private long idService;

    @Column(name = "status")
    private long status;

    public long getIdAppointment() {
        return idAppointment;
    }

    public void setIdAppointment(long idAppointment) {
        this.idAppointment = idAppointment;
    }

    public long getIdUser() {
        return idUser;
    }

    public void setIdUser(long idUser) {
        this.idUser = idUser;
    }

    public long getIdService() {
        return idService;
    }

    public void setIdService(long idService) {
        this.idService = idService;
    }

    public long getStatus() {
        return status;
    }

    public void setStatus(long status) {
        this.status = status;
    }
    public Appointment(){

    }
    public Appointment(long idUser, long idService, long status) {
        this.idUser = idUser;
        this.idService = idService;
        this.status = status;
    }
}
