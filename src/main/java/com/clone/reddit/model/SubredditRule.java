package com.clone.reddit.model;

import jakarta.persistence.*;
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
public class SubredditRule {

    @Id
    @GeneratedValue(strategy = AUTO)
    private Long id;
    private String rule;
    @ManyToOne
    @JoinColumn(name = "subredditId", referencedColumnName = "id")
    private Subreddit subreddit;
    @Column(nullable = false, updatable = false)
    @CreationTimestamp
    private Date created_at;

}
