package com.ff.quizservice.dto;

import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;

@Data
@Builder
public class Response {
    @Id
    private String id;
    private String questionId;
    private String answer;
}
