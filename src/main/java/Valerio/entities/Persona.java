package Valerio.entities;

import jakarta.persistence.*;

import java.util.Date;
import java.util.List;

@Entity
public class Persona {
    @Id
    @GeneratedValue
    private long id;

    @Column(name = "nome")
    private String nome;

    @Column(name = "cognome")
    private Date cognome;

    @Column(name = "email")
    private String email;

    @Column(name = "sesso")
    @Enumerated(EnumType.STRING)
    private Sesso sesso;

    @OneToMany(mappedBy = "persona")
    private List<Partecipazioni> listaPartecipazioni;

}
