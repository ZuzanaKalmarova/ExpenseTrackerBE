package com.zuzana.expensetrackerbe.controllers;

import java.time.LocalDate;
import java.time.YearMonth;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.zuzana.expensetrackerbe.models.Category;
import com.zuzana.expensetrackerbe.models.Summary;
import com.zuzana.expensetrackerbe.repositories.CategoryRepo;
import com.zuzana.expensetrackerbe.repositories.ExpenseRepo;

@CrossOrigin
@RestController
public class SummaryController {
	
	
	
	@Autowired
	private CategoryRepo catRepo;
	
	@Autowired
	private ExpenseRepo expRepo;
	
	@GetMapping("/summary")
	List<Summary> getSummary() {
		LocalDate today = LocalDate.now();
		LocalDate start = today.withDayOfMonth(1);
		LocalDate end = today.withDayOfMonth(today.lengthOfMonth());
		return getSumm(start, end);
	}
	
	@GetMapping("/summary/{year}/{month}")
	List<Summary> getSummary(@PathVariable("year") int year, @PathVariable("month") int month) {
		YearMonth yearmonth = YearMonth.of(year, month);
		LocalDate start = yearmonth.atDay(1);
		LocalDate end = yearmonth.atEndOfMonth();
		return getSumm(start, end);
	}
	
	String calculateType(double val) {
		if (val <= 80) {
			return "success";
		} else if (val < 100) {
			return "warning";
		} else {
			return "danger";
		}
	}
	
	Map<Integer, Double> getExpSummByCat(LocalDate start, LocalDate end) {
		//LocalDate firstDayOfCurrMonth = LocalDate.now().withDayOfMonth(1);
		List<Object[]> res = expRepo.getExpenseSummaryByCategoryAndMonth(start, end);
		Map<Integer, Double> resMap = new HashMap<>();
		for(Object[] o : res) {
			resMap.put((Integer)o[0], (Double)o[1]);
		}
		return resMap;
	}
	
	List<Summary> getSumm(LocalDate start, LocalDate end) {
		List<Summary> summ = new ArrayList<>();
		List<Category> catList = catRepo.findAll();
		Map<Integer, Double> sumByCat = getExpSummByCat(start, end);
		double totBudget = 0;
		double totExp = 0;
		
		for (Category cat : catList) {
			Summary s = new Summary();
			double budget = cat.getBudget();
			totBudget += budget;
			double expSum = 0;
			try {
			expSum = sumByCat.get(cat.getId());
			} catch(NullPointerException e) {}
			totExp += expSum;
			s.setTitle(cat.getName());
			s.setValue(Math.round(expSum*100/budget));
			s.setType(calculateType(s.getValue()));
			summ.add(s);
		}
		
		Summary tot = new Summary();
		tot.setTitle("Total");
		tot.setValue(Math.round(totExp*100/totBudget));
		tot.setType(calculateType(tot.getValue()));
		summ.add(tot);
		return summ;
	}

}
