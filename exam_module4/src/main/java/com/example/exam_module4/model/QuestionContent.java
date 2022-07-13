package com.example.exam_module4.model;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity(name = "question_content")
public class QuestionContent {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotBlank(message = "Tiêu đề Không được trống")
    private String title;

    @NotBlank(message = "Nội dung Không được trống")
    private String content;

    private String answer;

    @Column(name = "date_create")
    private String dateCreate;

    private String status = "Chờ phản hồi";

    @ManyToOne
    @JoinColumn(name = "id_question_type")
    private QuestionType questionType;

    public QuestionContent() {
    }

    public QuestionContent(Integer id, String title, String content, String answer, String dateCreate, String status, QuestionType questionType) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.answer = answer;
        this.dateCreate = dateCreate;
        this.status = status;
        this.questionType = questionType;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public String getDateCreate() {
        return dateCreate;
    }

    public void setDateCreate(String dateCreate) {
        this.dateCreate = dateCreate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public QuestionType getQuestionType() {
        return questionType;
    }

    public void setQuestionType(QuestionType questionType) {
        this.questionType = questionType;
    }
}
