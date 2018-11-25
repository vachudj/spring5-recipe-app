package com.springframework.controllers;

import com.springframework.domain.Category;
import com.springframework.domain.UnitOfMeasure;
import com.springframework.repositories.CategoryRepository;
import com.springframework.repositories.UnitOfMeasureRepository;
import com.springframework.services.RecipeService;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Optional;

import static org.slf4j.LoggerFactory.getLogger;

@Slf4j
@Controller
public class IndexController {

    private static final Logger logger = getLogger(IndexController.class);

    private final RecipeService recipeService;

    public IndexController(RecipeService recipeService) {
        this.recipeService = recipeService;
    }

    @RequestMapping({"", "/", "/index"})
    public String getIndexPage(Model model) {
        log.debug("Creating Index Page");
        model.addAttribute("recipes", recipeService.getRecipes());

        return "index";
    }
}
