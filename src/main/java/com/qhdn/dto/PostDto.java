package com.qhdn.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class PostDto {

    private String  title;

    private String content;

    private String imageName;

    private Date addedDate;

    private CategoryDto category;

    private AccountDto account;

    private Set<CommentDto> comments = new HashSet<>();
}
