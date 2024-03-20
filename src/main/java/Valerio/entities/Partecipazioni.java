package Valerio.entities;

import jakarta.persistence.*;

@Entity
public class Partecipazioni {
    @Id
    @GeneratedValue
    private long id;

    @ManyToOne
    private Persona persona;

    @ManyToOne
    private Evento evento;

    @Column
    @Enumerated(EnumType.STRING)
    private StatoEvento statoEvento;
}
