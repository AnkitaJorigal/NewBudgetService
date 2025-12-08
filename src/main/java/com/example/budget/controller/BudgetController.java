package com.example.budget.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.budget.Entity.Budget;
import com.example.budget.repository.BudgetRepository;

@RestController
@RequestMapping("/api/budgets")
public class BudgetController {
	private final BudgetRepository repo;

	public BudgetController(BudgetRepository repo) {
		this.repo = repo;
	}

	@PostMapping
	public Budget create(@RequestBody Budget b) {
		return repo.save(b);
	}

	@GetMapping("/{category}")
	public ResponseEntity<Budget> getByCategory(@PathVariable String category) {
		return repo.findByCategory(category).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
	}
}