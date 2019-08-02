package com.zuzana.expensetrackerbe.controllers;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.YearMonth;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.zuzana.expensetrackerbe.models.Expense;
import com.zuzana.expensetrackerbe.repositories.ExpenseRepo;

@CrossOrigin
@RestController
public class ExpenseController {
	
	
	
	@Autowired
	private ExpenseRepo repo;
	
	@GetMapping("/expenses")
	List<Expense> getExpenses() {
		//System.out.println(firstDayOfCurrMonth);
		LocalDate today = LocalDate.now();
		LocalDate firstDayOfCurrMonth = today.withDayOfMonth(1);
		return repo.findByDateGreaterThanEqual(firstDayOfCurrMonth);
	}
	
	@GetMapping("/expenses/{year}/{month}")
	List<Expense> getExpenses(@PathVariable("year") int year, @PathVariable("month") int month) {
		YearMonth yearmonth = YearMonth.of(year, month);
		LocalDate firstDay = yearmonth.atDay(1);
		LocalDate lastDay = yearmonth.atEndOfMonth();
		return repo.findByDateBetween(firstDay, lastDay);
	}
	
	@PostMapping("/expenses")
	Expense addExpense(@RequestBody Expense exp) {
		return repo.save(exp);
	}
	
	@PutMapping("/expenses/{id}")
	Expense updateExpense(@RequestBody Expense exp) {
		return repo.save(exp);
	}
	
	@DeleteMapping("/expenses/{id}")
	void deleteExpense(@PathVariable int id) {
		repo.deleteById(id);
	}

}
