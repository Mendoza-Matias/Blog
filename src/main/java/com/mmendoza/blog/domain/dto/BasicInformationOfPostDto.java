package com.mmendoza.blog.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class BasicInformationOfPostDto {
    private Integer id;
    private String title;
    private String subtitle;
    private LocalDate datePublished;
}
