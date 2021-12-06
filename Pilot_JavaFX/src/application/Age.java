package application;

import java.time.Duration;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Period;
import java.util.Date;
import java.time.format.DateTimeFormatter;

public class Age {
	private String dob;
	private String today;
	private String years;
	private String months;
	private String weeks;
	private String days;
	private String hours;
	private String minutes;
	private String yearMonths;
	private String yearDays;
	private String nextMonths;
	private String nextDays;
	private String nextBirthday;
	
	Age(String dob,String today){
		this.dob = dob;
		this.today = today;
	}
	
	void setDob(String dob) {
		this.dob = dob;
	}
	void setToday(String today) {
		this.today = today;
	}
	void calculate() throws ParseException {
		LocalDate birth = LocalDate.parse(dob);
		LocalDate today = LocalDate.parse(this.today);
		years = String.valueOf(java.time.temporal.ChronoUnit.YEARS.between(birth,today));
		months = String.valueOf(java.time.temporal.ChronoUnit.MONTHS.between(birth,today));
		weeks = String.valueOf(java.time.temporal.ChronoUnit.WEEKS.between(birth,today));
		days = String.valueOf(java.time.temporal.ChronoUnit.DAYS.between(birth,today));
		hours = String.valueOf(java.time.temporal.ChronoUnit.DAYS.between(birth,today)*24);
		minutes = String.valueOf(java.time.temporal.ChronoUnit.DAYS.between(birth,today)*24*60);

		Period diff = Period.between(birth,today);
		yearMonths = String.valueOf(diff.getMonths());
		yearDays = String.valueOf(diff.getDays());

		Period diff_2 = Period.between(today,birth.plusYears(java.time.temporal.ChronoUnit.YEARS.between(birth,today)+1));
		nextMonths = String.valueOf(diff_2.getMonths());
		nextDays = String.valueOf(diff_2.getDays());
		
		String inputDate = "16/08/2022";
        SimpleDateFormat format1 = new SimpleDateFormat("dd/MM/yyyy");
        Date dt1 = format1.parse(inputDate);
        DateFormat format2 = new SimpleDateFormat("EEEE");
        //String finalDay = format2.format(dt1);
        nextBirthday = format2.format(dt1);
	}
	
	String getYears() {
		return years;
	}
	String getMonths() {
		return months;
	}
	String getWeeks() {
		return weeks;
	}
	String getDays() {
		return days;
	}
	String getHours() {
		return hours;
	}
	String getMinutes() {
		return minutes;
	}
	String getYearMonths() {
		return yearMonths;
	}
	String getYearDays() {
		return yearDays;
	}
	String getNextMonth() {
		return nextMonths;
	}
	String getNextDays() {
		return nextDays;
	}
	String getBirthday() {
		return nextBirthday;
	}
}
