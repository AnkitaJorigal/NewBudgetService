package com.example.budget.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.budget.Entity.Budget;

public interface BudgetRepository extends JpaRepository<Budget, Long> {
	Optional<Budget> findByCategory(String category);
}