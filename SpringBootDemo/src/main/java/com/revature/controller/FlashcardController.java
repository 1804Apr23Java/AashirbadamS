package com.revature.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.revature.beans.Flashcard;

import com.revature.repository.FlashcardDao;

@RestController
@RequestMapping(value="/api")
public class FlashcardController {

	@Autowired
	FlashcardDao fd;

	@GetMapping("/allFlashcards")
	public ResponseEntity<List<Flashcard>> getAllFlashcards() {
		return new ResponseEntity<>(fd.findAll(), HttpStatus.OK);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<Flashcard> getFlashcardById(@PathVariable int id) {
		ResponseEntity<Flashcard> resp = new ResponseEntity<>(fd.findFlashcardById(id), HttpStatus.OK);
		return resp;
	}
	@RequestMapping(value = "/{question}", method = RequestMethod.GET)
	public ResponseEntity<Flashcard> findFlashcardByQuestion(@PathVariable String question) {
		ResponseEntity<Flashcard> resp = new ResponseEntity<>(fd.findFlashcardByQuestion(question), HttpStatus.OK);
		return resp;
	}

	


}
