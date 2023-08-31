package br.com.baiao.api.services;



import br.com.baiao.api.model.Review;
import br.com.baiao.api.repository.ProductRepository;
import br.com.baiao.api.repository.ReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReviewService {

    @Autowired
    ReviewRepository repositorio;

    @Autowired
    ProductRepository productRepository;

    public List<Review> retornarTodasAsReview(){
        return repositorio.findAll();
    }
    public Review retornarReviewPorId(Long id){
        return repositorio.findById(id).orElseThrow();
    }
    public void salvarReview(Review review){
        review.setProduct(productRepository.findById(review.getProduct().getId()).orElseThrow());
        repositorio.save(review);
    }

    public void removerReview(Long id){
        repositorio.deleteById(id);
    }

}
