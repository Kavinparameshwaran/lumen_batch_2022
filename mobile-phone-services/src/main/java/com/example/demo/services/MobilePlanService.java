package com.example.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.MobilePlan;
import com.example.demo.exceptions.ElementNotFoundException;
import com.example.demo.repos.PlanRespository;

@Service
public class MobilePlanService {
	private PlanRespository repo;

	@Autowired
	public MobilePlanService(PlanRespository repo) {
		super();
		this.repo = repo;
	}

	public List<MobilePlan> findAll() {
		return this.repo.findAll();
	}

	public MobilePlan add(MobilePlan plan) {
		return this.repo.save(plan);
	}

	public MobilePlan findById(int id) {
		String message = new StringBuilder("Element with Guven Id ").append(id).append(" Not Found").toString();
		return this.repo.findById(id).orElseThrow(() -> new RuntimeException(message));

	}

	public MobilePlan update(MobilePlan entity) {
		return this.repo.save(entity);
	}

	public MobilePlan remove(int id) {
		MobilePlan element = this.findById(id);
		this.repo.deleteById(id);
		return element;
	}

	public List<MobilePlan> findByPlanName(String planName) {
		return this.repo.findByPlanName(planName);
	}

	public List<MobilePlan> getCostGreaterThan(double amount) {
		return this.repo.getCostGreaterThan(amount);
	}

	public int updateValidity(String updatedValidity, String planName) {
		return this.repo.updateValidity(updatedValidity, planName);
	}

}
