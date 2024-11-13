package com.example.kiemtra.entity;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDate;

@Entity
@Data
@Table(name = "favorites") // Tên bảng phù hợp với CSDL
public class Favorite {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "FavoriteId") // Tên cột phù hợp với CSDL
    private int favoriteId;

    @Column(name = "LikedDate")
    private LocalDate likedDate;

    @ManyToOne
    @JoinColumn(name = "VideoId", nullable = false) // Ràng buộc với bảng `videos`
    private Video video;

    @ManyToOne
    @JoinColumn(name = "Username", nullable = false) // Ràng buộc với bảng `users`
    private User user;
}
