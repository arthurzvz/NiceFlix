package br.com.niceflix.niceflix.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "streaming")
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Streaming {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
}
