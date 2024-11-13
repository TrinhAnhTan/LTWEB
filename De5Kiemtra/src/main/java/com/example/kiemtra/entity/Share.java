package com.example.kiemtra.entity;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDate;

@Entity
@Data
@Table(name = "shares") // Tên bảng phù hợp với CSDL
public class Share {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ShareId") // Tên cột phù hợp với CSDL
    private int shareId;

    @Column(name = "Emails")
    private String emails;

    @Column(name = "SharedDate")
    private LocalDate sharedDate;

    @ManyToOne
    @JoinColumn(name = "Username", nullable = false) // Ràng buộc với bảng `users`
    private User user;

    @ManyToOne
    @JoinColumn(name = "VideoId", nullable = false) // Ràng buộc với bảng `videos`
    private Video video;
}
