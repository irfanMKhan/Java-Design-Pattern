package edu.mum.cs.cs525.labs.skeleton.design.pattern.composite;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public class Manager extends Hire {
	
	private Double bonus=0d;
	
	private List<Hire> team = new ArrayList<>();

	public Manager(String name, String email, double salary) {
		super(name, email, salary);
	}

	public boolean addPerson(Hire hire) {
		return team.add(hire);
	}

	@Override
	public Double getBudget() {
		Double budget = 0.0;
		budget += getSalary();
		return budget;
	}

	public Double getBonus() {
		return bonus;
	}

	public void setBonus(Double bonus) {
		this.bonus = bonus;
	}
	
	public Double getSalary() {
		return bonus + super.getSalary();
	}

	@Override
	public void process(Consumer<Hire> action) {
		action.accept(this);
		
		for(Hire hire : team) {
			hire.process(action);
		}
		
	}
}
