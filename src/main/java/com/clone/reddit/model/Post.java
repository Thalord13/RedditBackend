package com.clone.reddit.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.util.Date;

import static jakarta.persistence.GenerationType.AUTO;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Post {

    @Id
    @GeneratedValue(strategy = AUTO)
    private Long id;
    private String title;
    private String body;
    @Column(nullable = false, updatable = false)
    @CreationTimestamp
    private Date created_at;

}
