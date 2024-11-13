package com.example.kiemtra.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.ToString;

import java.util.List;

@Entity
@Data
@Table(name = "category") // Tên bảng phù hợp với CSDL
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CategoryId") // Tên cột phù hợp với CSDL
    private int categoryId;

    @Column(name = "CategoryName", nullable = false)
    private String categoryName;

    @Column(name = "CategoryCode", nullable = false, unique = true)
    private String categoryCode;

    @Column(name = "Images")
    private String images;

    @Column(name = "Status")
    private boolean status;

//    @OneToMany(mappedBy = "category", cascade = CascadeType.ALL, orphanRemoval = true)
    @OneToMany(mappedBy = "category", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @ToString.Exclude
    private List<Video> videos;
}
