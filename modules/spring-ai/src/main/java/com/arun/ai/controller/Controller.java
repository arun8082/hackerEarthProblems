package com.arun.ai.controller;

import com.arun.ai.dto.BookDetail;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.ai.chat.model.ChatResponse;
import org.springframework.ai.chat.prompt.Prompt;
import org.springframework.ai.chat.prompt.PromptTemplate;
import org.springframework.ai.converter.BeanOutputConverter;
import org.springframework.ai.openai.OpenAiChatModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {

    @Autowired
    private OpenAiChatModel aiModel;

    @GetMapping("/joke")
    public String getJoke(String topic) {
        PromptTemplate promptTemplate = new PromptTemplate("""
                Please act as a funny person and  create a joke on the given {topic}?
                Please be mindful and sensitive about the content though.
               """);
        promptTemplate.add("topic", topic);
        ChatResponse response = aiModel.call(promptTemplate.create());
        return response.getResult().getOutput().getText();
    }


    @GetMapping("/books")
    public String getBooks(String category, String year){
        PromptTemplate promptTemplate = new PromptTemplate("""
              Please provide me best book for the given {category} and the {year}.
              Please do provide a summary of the book as well, the information should be\s
              limited and not much in depth. Please provide the details in the JSON format
              containing this information : category, book, year, review, author, summary
               """);
        promptTemplate.add("category", category);
        promptTemplate.add("year", year);
        ChatResponse response = aiModel.call(promptTemplate.create());
        return response.getResult().getOutput().getText();
    }

    @GetMapping("/booksJson")
    public BookDetail getBooksJson(String category, String year){
        BeanOutputConverter<BookDetail> beanOutputConverter = new BeanOutputConverter<>(BookDetail.class);
        PromptTemplate promptTemplate = new PromptTemplate("""
              Please provide me best book for the given {category} and the {year}.
              Please do provide a summary of the book as well, the information should be\s
              limited and not much in depth. Please provide the details in the JSON format
              containing this information : category, book, year, review, author, summary
               """);
        promptTemplate.add("category", category);
        promptTemplate.add("year", year);

        ChatResponse response = aiModel.call(promptTemplate.create());
        return beanOutputConverter.convert(response.getResult().getOutput().getText());
    }
}
