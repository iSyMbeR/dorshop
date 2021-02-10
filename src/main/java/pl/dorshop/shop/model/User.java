package pl.dorshop.shop.model;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Enumerated(EnumType.STRING)
    private UserType userType;
    @Column(unique = true)
    private String email;
    private String password;
    private String firstName;
    private String lastName;
    private String address;
    private String phone;
    @OneToMany
    private List<Product> productList;
}
