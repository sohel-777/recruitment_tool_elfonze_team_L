package Elfonze.Recrutment_tool.Models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;


@Data //give getters and setters
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "user")
public class User implements UserDetails {
   // private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(unique = true, name="name")
    private String userName;

    @Column(name = "organization")
    private String organization;

    private String email;

    @Column(unique = true)
    private String password;

    @Column(name = "role")
    private String role;

    private String profile;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
     return null;
    }

    @Override
    public String getUsername() {
     return this.userName;
    }

    @Override
    public boolean isAccountNonExpired() {
     return true;
    }

    @Override
    public boolean isAccountNonLocked() {
     return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
     return true;
    }

    @Override
    public boolean isEnabled() {
     return true;
    }

 //one user may have many roles


}
