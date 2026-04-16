package com.jb.reportapp.runner;

import com.jb.reportapp.entity.CitizenPlan;
import com.jb.reportapp.repository.CitizenPlanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

@Component
public class DataLoader implements ApplicationRunner {

    @Autowired
    private CitizenPlanRepository citizenPlanRepository;

    @Override
    public void run(ApplicationArguments args) throws Exception {

        citizenPlanRepository.deleteAll();

        // ================= CASH PLAN =================
        CitizenPlan c1 = new CitizenPlan();
        c1.setCitizenName("Rahul Sharma");
        c1.setGender("Male");
        c1.setPlanName("Cash");
        c1.setPlanStatus("Approved");
        c1.setPlanStartDate(LocalDate.now());
        c1.setPlanEndDate(LocalDate.now().plusMonths(6));
        c1.setBenefitAmount(5000.00);

        CitizenPlan c2 = new CitizenPlan();
        c2.setCitizenName("Priya Verma");
        c2.setGender("Female");
        c2.setPlanName("Cash");
        c2.setPlanStatus("Denied");
        c2.setDenialReason("Income exceeds limit");

        CitizenPlan c3 = new CitizenPlan();
        c3.setCitizenName("Amit Patel");
        c3.setGender("Male");
        c3.setPlanName("Cash");
        c3.setPlanStatus("Terminated");
        c3.setPlanStartDate(LocalDate.now().minusMonths(5));
        c3.setPlanEndDate(LocalDate.now().plusMonths(1));
        c3.setBenefitAmount(6000.00);
        c3.setTerminationDate(LocalDate.now());
        c3.setTerminationReason("Got Job");

// ================= FOOD PLAN =================
        CitizenPlan c4 = new CitizenPlan();
        c4.setCitizenName("Sneha Reddy");
        c4.setGender("Female");
        c4.setPlanName("Food");
        c4.setPlanStatus("Approved");
        c4.setPlanStartDate(LocalDate.now());
        c4.setPlanEndDate(LocalDate.now().plusMonths(6));
        c4.setBenefitAmount(4000.00);

        CitizenPlan c5 = new CitizenPlan();
        c5.setCitizenName("Rohit Kumar");
        c5.setGender("Male");
        c5.setPlanName("Food");
        c5.setPlanStatus("Denied");
        c5.setDenialReason("Duplicate Application");

        CitizenPlan c6 = new CitizenPlan();
        c6.setCitizenName("Anjali Singh");
        c6.setGender("Female");
        c6.setPlanName("Food");
        c6.setPlanStatus("Terminated");
        c6.setPlanStartDate(LocalDate.now().minusMonths(4));
        c6.setPlanEndDate(LocalDate.now().plusMonths(2));
        c6.setBenefitAmount(4500.00);
        c6.setTerminationDate(LocalDate.now());
        c6.setTerminationReason("Policy Violation");

// ================= MEDICAL PLAN =================
        CitizenPlan c7 = new CitizenPlan();
        c7.setCitizenName("Vikram Desai");
        c7.setGender("Male");
        c7.setPlanName("Medical");
        c7.setPlanStatus("Approved");
        c7.setPlanStartDate(LocalDate.now());
        c7.setPlanEndDate(LocalDate.now().plusMonths(6));
        c7.setBenefitAmount(20000.00);

        CitizenPlan c8 = new CitizenPlan();
        c8.setCitizenName("Neha Gupta");
        c8.setGender("Female");
        c8.setPlanName("Medical");
        c8.setPlanStatus("Denied");
        c8.setDenialReason("Age not eligible");

        CitizenPlan c9 = new CitizenPlan();
        c9.setCitizenName("Arjun Nair");
        c9.setGender("Male");
        c9.setPlanName("Medical");
        c9.setPlanStatus("Terminated");
        c9.setPlanStartDate(LocalDate.now().minusMonths(6));
        c9.setPlanEndDate(LocalDate.now());
        c9.setBenefitAmount(18000.00);
        c9.setTerminationDate(LocalDate.now());
        c9.setTerminationReason("Recovered");

// ================= EDUCATION PLAN =================
        CitizenPlan c10 = new CitizenPlan();
        c10.setCitizenName("Kavya Iyer");
        c10.setGender("Female");
        c10.setPlanName("Education");
        c10.setPlanStatus("Approved");
        c10.setPlanStartDate(LocalDate.now());
        c10.setPlanEndDate(LocalDate.now().plusYears(2));
        c10.setBenefitAmount(30000.00);

        CitizenPlan c11 = new CitizenPlan();
        c11.setCitizenName("Suresh Yadav");
        c11.setGender("Male");
        c11.setPlanName("Education");
        c11.setPlanStatus("Denied");
        c11.setDenialReason("Low marks");

        CitizenPlan c12 = new CitizenPlan();
        c12.setCitizenName("Pooja Mishra");
        c12.setGender("Female");
        c12.setPlanName("Education");
        c12.setPlanStatus("Terminated");
        c12.setPlanStartDate(LocalDate.now().minusMonths(8));
        c12.setPlanEndDate(LocalDate.now().plusMonths(4));
        c12.setBenefitAmount(25000.00);
        c12.setTerminationDate(LocalDate.now());
        c12.setTerminationReason("Dropped course");

// ================= EMPLOYMENT PLAN =================
        CitizenPlan c13 = new CitizenPlan();
        c13.setCitizenName("Manoj Tiwari");
        c13.setGender("Male");
        c13.setPlanName("Employment");
        c13.setPlanStatus("Approved");
        c13.setPlanStartDate(LocalDate.now());
        c13.setPlanEndDate(LocalDate.now().plusMonths(6));
        c13.setBenefitAmount(7000.00);

        CitizenPlan c14 = new CitizenPlan();
        c14.setCitizenName("Ayesha Khan");
        c14.setGender("Female");
        c14.setPlanName("Employment");
        c14.setPlanStatus("Denied");
        c14.setDenialReason("Not eligible");

        CitizenPlan c15 = new CitizenPlan();
        c15.setCitizenName("Imran Sheikh");
        c15.setGender("Male");
        c15.setPlanName("Employment");
        c15.setPlanStatus("Terminated");
        c15.setPlanStartDate(LocalDate.now().minusMonths(3));
        c15.setPlanEndDate(LocalDate.now().plusMonths(3));
        c15.setBenefitAmount(8000.00);
        c15.setTerminationDate(LocalDate.now());
        c15.setTerminationReason("Got Govt Job");

// ================= EXTRA =================
        CitizenPlan c16 = new CitizenPlan();
        c16.setCitizenName("Divya Jain");
        c16.setGender("Female");
        c16.setPlanName("Cash");
        c16.setPlanStatus("Approved");
        c16.setPlanStartDate(LocalDate.now());
        c16.setPlanEndDate(LocalDate.now().plusMonths(6));
        c16.setBenefitAmount(5500.00);

        CitizenPlan c17 = new CitizenPlan();
        c17.setCitizenName("Sunil Patil");
        c17.setGender("Male");
        c17.setPlanName("Food");
        c17.setPlanStatus("Approved");
        c17.setPlanStartDate(LocalDate.now());
        c17.setPlanEndDate(LocalDate.now().plusMonths(6));
        c17.setBenefitAmount(4200.00);

        CitizenPlan c18 = new CitizenPlan();
        c18.setCitizenName("Ritika Das");
        c18.setGender("Female");
        c18.setPlanName("Medical");
        c18.setPlanStatus("Approved");
        c18.setPlanStartDate(LocalDate.now());
        c18.setPlanEndDate(LocalDate.now().plusMonths(6));
        c18.setBenefitAmount(22000.00);

        CitizenPlan c19 = new CitizenPlan();
        c19.setCitizenName("Naveen Kumar");
        c19.setGender("Male");
        c19.setPlanName("Education");
        c19.setPlanStatus("Approved");
        c19.setPlanStartDate(LocalDate.now());
        c19.setPlanEndDate(LocalDate.now().plusYears(1));
        c19.setBenefitAmount(28000.00);

        CitizenPlan c20 = new CitizenPlan();
        c20.setCitizenName("Bhavna Shah");
        c20.setGender("Female");
        c20.setPlanName("Employment");
        c20.setPlanStatus("Approved");
        c20.setPlanStartDate(LocalDate.now());
        c20.setPlanEndDate(LocalDate.now().plusMonths(6));
        c20.setBenefitAmount(7500.00);

        List<CitizenPlan> list = Arrays.asList(c1, c2, c3, c4, c5, c6, c7, c8, c9, c10, c11, c12, c13, c14, c15, c16, c17, c18, c19, c20);
        citizenPlanRepository.saveAll(list);
    }
}
