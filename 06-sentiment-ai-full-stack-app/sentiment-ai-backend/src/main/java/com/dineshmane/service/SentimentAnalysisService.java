package com.dineshmane.service;

import com.dineshmane.entity.Feedback;

public interface SentimentAnalysisService {
    Feedback analyzeFeedback(String content);
}
