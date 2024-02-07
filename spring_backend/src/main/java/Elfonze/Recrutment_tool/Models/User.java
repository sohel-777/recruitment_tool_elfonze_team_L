package Elfonze.Recrutment_tool.Models;

import jakarta.persistence.*;
import lombok.*;


@Data //give getters and setters
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "user")
public class User {

   // private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name="name")
    private String userName;

    @Column(name = "organization")
    private String organization;

    @Column(unique = true)
    private String email;

    @Column(unique = true)
    private String password;

    @Column(name = "role")
    private String role;

}
