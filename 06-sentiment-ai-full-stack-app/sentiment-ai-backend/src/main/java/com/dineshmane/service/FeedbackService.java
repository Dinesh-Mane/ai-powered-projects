package com.dineshmane.service;

import com.dineshmane.entity.Feedback;
import org.springframework.stereotype.Service;

import java.util.List;

public interface FeedbackService {

    List<Feedback> getAllFeedbacks();

    Feedback saveFeedback(Feedback feedback);

}
