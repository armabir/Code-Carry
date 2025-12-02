package com.example.hibernatejpa.model;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Embeddable
@Data
@NoArgsConstructor
@AllArgsConstructor
public class AuditInfo {
    private String createdBy;
    private String createdAt;
    private String UpdatedAt;
}
