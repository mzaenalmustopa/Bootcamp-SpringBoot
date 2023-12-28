package mzaaenalmustopa.springwebmvc.controller;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class TodoController {

    private List<String> todos = new ArrayList<>();

    @PostMapping(
            path = "/todo",
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public List<String> addTodo(@RequestParam(name = "todo")String todo){
        todos.add(todo);
        return todos;
    }

    @GetMapping(
            path = "/todo",
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public List<String> addTodo(){
        return todos;
    }
}
