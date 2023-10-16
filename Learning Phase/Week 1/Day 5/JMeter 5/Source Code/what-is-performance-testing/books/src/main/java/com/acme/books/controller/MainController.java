package com.acme.books.controller;

import com.acme.books.controller.dto.ReviewDTO;
import com.acme.books.model.Book;
import com.acme.books.model.CustomUser;
import com.acme.books.model.Review;
import com.acme.books.model.Users;
import com.acme.books.repository.BookRepository;
import com.acme.books.repository.ReviewRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.security.Principal;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import java.util.List;

@Controller
public class MainController {
    private Logger logger = LoggerFactory.getLogger(MainController.class);

    @Autowired
    private BookRepository bookRepository;
    @Autowired
    private ReviewRepository reviewRepository;

    @GetMapping("/")
    public String index(Model model) {
        logger.debug("Entering \"/\" path");
        long max = bookRepository.count();

        // Get three book IDs
        Set<Long> ids = new HashSet<>();
        ids.add(6L);
        ids.add(10L);
        ids.add(15L);

        List<Book> books = bookRepository.findAllById(ids);
        model.addAttribute("books", books);

        return "index";
    }

    @GetMapping("/login")
    public String login() {
        logger.debug("Entering \"/login\" path");
        return "login";
    }

    @GetMapping("/books")
    public String getBooks(@PageableDefault(size = 12) Pageable pageable,
                               Model model) {
        logger.debug("Entering \"/books\" path");
        Page<Book> page = bookRepository.findAll(pageable);
        model.addAttribute("page", page);
        return "books";
    }

    @GetMapping("/books/category/{categoryId}")
    public String getBooksFromCategory(@PageableDefault(size = 12) Pageable pageable,
                                       @PathVariable("categoryId") int categoryId,
                           Model model) {
        logger.debug("Entering \"/books/category/" + categoryId + " \" path");
        Page<Book> page = bookRepository.findAllByCategoryId(categoryId, pageable);
        model.addAttribute("page", page);
        return "books";
    }

    @GetMapping("/books/{bookId}")
    public String getBook(@PageableDefault(size = 10, sort = "registered", direction = Sort.Direction.DESC) Pageable pageable,
                          @PathVariable("bookId") long bookId,
                           Model model,
                          Principal principal) {
        logger.debug("Entering \"/books/" + bookId + " \" path");
        Book book = bookRepository.findById(bookId).get();
        book.setAverageReview(reviewRepository.getRatingBookId(bookId));

        Page<Review> page = reviewRepository.findAllByBookId(bookId, pageable);

        model.addAttribute("book", book);
        model.addAttribute("page", page);

        if (!model.containsAttribute("review")) {
            ReviewDTO reviewDTO = new ReviewDTO();;
            if(principal != null) {
                CustomUser user = (CustomUser)((UsernamePasswordAuthenticationToken) principal).getPrincipal();
                List<Review> list = reviewRepository.findByBookIdAndUserId(bookId, user.getId());
                if(list != null && !list.isEmpty()) {
                    Review review = list.get(0);
                    reviewDTO.setRating(review.getRating());
                    reviewDTO.setTitle(review.getTitle());
                    reviewDTO.setReview(review.getReview());
                }
            }
            model.addAttribute("review", reviewDTO);
        }

        return "book";
    }

    @PostMapping("/books/{bookId}/review")
    public String postBookReview(@Valid @ModelAttribute("review") ReviewDTO reviewDTO,
                                 BindingResult result,
                                 RedirectAttributes attr,
                                 @PathVariable("bookId") long bookId,
                                 Principal principal) {
        logger.debug("Entering \"/books/" + bookId + "/review \" path");
        String redirect = "redirect:/books/" + bookId + "#reviews";

        if (result.hasErrors()) {
            attr.addFlashAttribute("org.springframework.validation.BindingResult.review", result);
            attr.addFlashAttribute("review", reviewDTO);
        } else {
            Review review = new Review();
            if(principal != null) {
                CustomUser user = (CustomUser)((UsernamePasswordAuthenticationToken) principal).getPrincipal();
                List<Review> list = reviewRepository.findByBookIdAndUserId(bookId, user.getId());
                if(list != null && !list.isEmpty()) {
                    review = list.get(0);
                }
                review.setTitle(reviewDTO.getTitle());
                review.setReview(reviewDTO.getReview());
                review.setRating(reviewDTO.getRating());
                review.setRegistered(new Date());
                review.setBook(new Book(bookId));
                review.setUser(new Users(user.getId()));

                reviewRepository.save(review);
            }
        }

        return redirect;
    }

}
