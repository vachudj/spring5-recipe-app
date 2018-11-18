package com.springframework.controllers;

import com.springframework.domain.Category;
import com.springframework.domain.UnitOfMeasure;
import com.springframework.repositories.CategoryRepository;
import com.springframework.repositories.UnitOfMeasureRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Optional;

import static org.slf4j.LoggerFactory.getLogger;

@Controller
public class IndexController {

    private static final Logger logger = getLogger(IndexController.class);

    private final CategoryRepository categoryRepository;

    private final UnitOfMeasureRepository unitOfMeasureRepository;

    public IndexController(CategoryRepository categoryRepository, UnitOfMeasureRepository unitOfMeasureRepository) {
        this.categoryRepository = categoryRepository;
        this.unitOfMeasureRepository = unitOfMeasureRepository;
    }

    @RequestMapping({"", "/", "/index"})
    public String getIndexPage() {
        Optional<Category> categoryOptional = categoryRepository.findByDescription("American");
        Optional<UnitOfMeasure> unitOfMeasureOptional = unitOfMeasureRepository.findByDescription("Teaspoon");

        logger.info("Cat id is: " + categoryOptional.get().getId());
        logger.info("UOM id is: " + unitOfMeasureOptional.get().getId());

        return "index";
    }
}
