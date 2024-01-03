package com.fleet.api.entities;

import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "users")
@Getter
@Setter
@EqualsAndHashCode
public class UserEntity {

    @Column( name = "name" )
    private String name;

    @Column( name = "nif" )
    private Integer nif;

    @Id // TODO: id deve ser o primeiro atributo da entidade por ser PK
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    // TODO; se esta usando lombok isso não faz sentido
    public void setId(Long id) {
        this.id = id;
    }

    // isso tambem nao
    public Long getId() {
        return id;
    }
}
