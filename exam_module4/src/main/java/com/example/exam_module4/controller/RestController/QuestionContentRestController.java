package com.example.exam_module4.controller.RestController;

import com.example.exam_module4.model.QuestionContent;
import com.example.exam_module4.service.IQuestionContentService;
import com.example.exam_module4.service.IQuestionTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.HashMap;
import java.util.Map;

@RestController
public class QuestionContentRestController {

    @Autowired
    private IQuestionContentService iQuestionContentService;

    @Autowired
    private IQuestionTypeService iQuestionTypeService;

    @PostMapping(value = "/create")
    public ResponseEntity<?> create(@Valid @RequestBody QuestionContent questionContent) {
        iQuestionContentService.save(questionContent);
        Sort sort = Sort.by("date_create").ascending();
        questionContent.setQuestionType(iQuestionTypeService.findById(questionContent.getQuestionType().getId()));
        Page<QuestionContent> list = iQuestionContentService.findAll(PageRequest.of(0, 100, sort));
        return new ResponseEntity<>(list, HttpStatus.CREATED);
    }

    @GetMapping(value = "/delete/{idDelete}")
    public ResponseEntity<?> delete(@PathVariable Integer idDelete) {
        iQuestionContentService.remove(idDelete);
        Sort sort = Sort.by("date_create").ascending();
        Page<QuestionContent> list = iQuestionContentService.findAll(PageRequest.of(0, 100, sort));
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @GetMapping(value = "/search/{key}/{questionTypeSearch}")
    public ResponseEntity<?> search(@PathVariable String key,@PathVariable int questionTypeSearch) {
        System.out.println(questionTypeSearch);
        Sort sort = Sort.by("date_create").ascending();
        Page<QuestionContent> list = iQuestionContentService.searchByTitle(key,questionTypeSearch, PageRequest.of(0, 100, sort));
        if (!list.isEmpty()){
            return new ResponseEntity<>(list, HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }


    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Map<String, String> handleValidationExceptions(
            MethodArgumentNotValidException ex) {
        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getAllErrors().forEach((error) -> {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            errors.put(fieldName, errorMessage);
        });
        return errors;
    }

}
