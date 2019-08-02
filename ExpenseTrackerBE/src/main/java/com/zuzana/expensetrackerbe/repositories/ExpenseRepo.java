package com.zuzana.expensetrackerbe.repositories;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.zuzana.expensetrackerbe.models.Expense;

public interface ExpenseRepo extends JpaRepository<Expense, Integer> {
	
	List<Expense> findByDateGreaterThanEqual(LocalDate firstDayOfCurrMonth);
	
	List<Expense> findByDateBetween(LocalDate start, LocalDate end);
	
	@Query(value="select e.category.id, sum(e.amount) from Expense e where e.date >= ?1 group by e.category.id")
	List<Object[]> getExpenseSummaryByCategory(LocalDate firstDayOfCurrMonth);
	
	@Query(value="select e.category.id, sum(e.amount) from Expense e where e.date between ?1 and ?2 group by e.category.id")
	List<Object[]> getExpenseSummaryByCategoryAndMonth(LocalDate start, LocalDate end);
	
}
