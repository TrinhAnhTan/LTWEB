package com.example.kiemtra.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.ToString;

import java.util.List;

@Entity
@Data
@Table(name = "videos") // Tên bảng phù hợp với CSDL
public class Video {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "VideoId") // Tên cột phù hợp với CSDL
    private int videoId;

    @Column(name = "Title", nullable = false)
    private String title;

    @Column(name = "Poster")
    private String poster;

    @Column(name = "Views")
    private int views;

    @Column(name = "Description")
    private String description;

    // Ánh xạ cột kiểu BIT thành byte
    @Column(name = "Active", nullable = false, columnDefinition = "TINYINT(1) DEFAULT 1")
    private byte active;

    @ManyToOne
    @JoinColumn(name = "CategoryId", nullable = false) // Ràng buộc với bảng `category`
    private Category category;

    @OneToMany(mappedBy = "video", cascade = CascadeType.ALL, orphanRemoval = true)
    @ToString.Exclude
    private List<Favorite> favorites;

    @OneToMany(mappedBy = "video", cascade = CascadeType.ALL, orphanRemoval = true)
    @ToString.Exclude
    private List<Share> shares;

    @Transient
    private int shareCount;

    // Getter và Setter cho `active` để làm việc với boolean
    public boolean isActive() {
        return active == 1;
    }

    public void setActive(boolean isActive) {
        this.active = (byte) (isActive ? 1 : 0);
    }
}
