package com.example.kiemtra.entity;

import jakarta.persistence.*;
import lombok.Data;
import java.util.List;

@Entity
@Data
@Table(name = "users") // Tên bảng phù hợp với CSDL
public class User {
    @Id
    @Column(name = "Username") // Tên cột phù hợp với CSDL
    private String username;

    @Column(name = "Password", nullable = false)
    private String password;

    @Column(name = "Phone")
    private String phone;

    @Column(name = "Fullname")
    private String fullname;

    @Column(name = "Email", nullable = false, unique = true)
    private String email;

    @Column(name = "Admin")
    private boolean isAdmin;

    @Column(name = "Active")
    private boolean isActive;

    @Column(name = "Images")
    private String images;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Favorite> favorites;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Share> shares;
}
