package edu.mum.cs.cs525.labs.skeleton.design.pattern.composite;

public class Application {

    public static void main(String[] args) {
//		Hire ceo = new Manager();
//
//		TotalBudgetConsumer budgetConsumer = new TotalBudgetConsumer();
//
//		ceo.process(budgetConsumer);
//
//		System.out.println(budgetConsumer.getTotalBudget());


        // Creating employees
        Employee emp1 = new Employee("John", "", 50000);
        Employee emp2 = new Employee("Jane", "", 60000);

        // Creating managers
        Manager mgr1 = new Manager("Alice", "", 100000);
        Manager mgr2 = new Manager("Bob", "", 120000);

        // Adding subordinates to managers
        mgr1.addPerson(emp1);
        mgr2.addPerson(emp2);
        mgr1.addPerson(mgr2); // Bob works under Alice

        // CEO (top-level manager)
        Manager ceo = new Manager("CEO", "", 200000);
        ceo.addPerson(mgr1);

        // Counting hires
        HireCounterConsumer counter = new HireCounterConsumer();
        ceo.process(counter);
        System.out.println("Total number of hires: " + counter.getCount());

        // Calculating total salary
        SalaryCalculatorConsumer salaryCalculator = new SalaryCalculatorConsumer();
        ceo.process(salaryCalculator);
        System.out.println("Total salary of hires: $" + salaryCalculator.getTotalSalary());

    }

}
