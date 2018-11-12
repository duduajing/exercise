package com.example.demo.EnumStudy;

/**
 * 该类是计算某人在某天的薪资，包括基本工资和加班工资，
 * 基本工资是正常工作日8小时所产生的薪资，
 * 加班工资是正常工作日超过8小时所产生的加班工资及
 * 双休日所产生的加班工资
 *
 */
public enum PayrollDay {
    MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY,
    SATURDAY, SUNDAY;

    private static final int HOURS_PER_SHIFT = 8;

    double pay(double hoursworked, double payRate){
        double basePay = hoursworked * payRate;

        double overtimepay;
        switch (this){
            case SATURDAY:case SUNDAY:
                overtimepay = hoursworked * payRate /2;
            default:
                overtimepay = hoursworked <= HOURS_PER_SHIFT ? 0 :(hoursworked - HOURS_PER_SHIFT)*payRate/2;
            break;

        }
        return basePay+overtimepay;
    }
}
