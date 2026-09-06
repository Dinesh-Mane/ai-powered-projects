package com.dineshmane.controller;

import com.dineshmane.entity.Feedback;
import com.dineshmane.service.FeedbackService;
import com.dineshmane.service.SentimentAnalysisService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/feedback")
@CrossOrigin(origins = "http://localhost:5173/")
@RequiredArgsConstructor
public class FeedbackController {

    private final FeedbackService feedbackService;
    private final SentimentAnalysisService sentimentAnalysisService;

    @GetMapping
    public ResponseEntity<List<Feedback>> getAllFeedbacks(){
        List<Feedback> feedbacks = feedbackService.getAllFeedbacks();
        return ResponseEntity.status(HttpStatus.OK).body(feedbacks);
    }

    @PostMapping
    public ResponseEntity<Feedback> saveFeedback(@RequestBody String content){
        Feedback feedback = sentimentAnalysisService.analyzeFeedback(content);
        Feedback saved = feedbackService.saveFeedback(feedback);
        return ResponseEntity.status(HttpStatus.CREATED).body(saved);
    }
}
