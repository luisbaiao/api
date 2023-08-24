package br.com.baiao.api.controller;


import br.com.baiao.api.model.Review;
import br.com.baiao.api.services.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/review")
public class ReviewController {

    @Autowired
    ReviewService reviewService;

    @PostMapping("/")
    public void adicionarReview(@RequestBody Review review){
        reviewService.salvarReview(review);
    }

    @DeleteMapping("/{id}")
    public void removerReview(@PathVariable Long id){
        reviewService.removerReview(id);
    }
}
