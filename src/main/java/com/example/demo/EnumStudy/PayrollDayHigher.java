package com.example.demo.EnumStudy;

/**
 * 该类是计算某人薪资的的升级版，除了双休日之外
 * 某一天也是休假日，忘记写case的情况时，导致薪资计算
 * 有问题的情况；
 * 该类使用策略枚举的方式，强制选择一种加班报酬策略；
 * 这种想法就是把加班工资计算移到一个私有的嵌套枚举中，
 * 将这个策略枚举（strategy enum）的实例传到PayrollDay中，
 * 就不需要switch语句或特定于常量的方法实现了；
 */
 enum PayrollDayHigher {
    MONDAY(PayType.WEEKDAY),
    TUESDAY(PayType.WEEKDAY),
    WEDNESDAY(PayType.WEEKDAY),
    THURSDAY(PayType.WEEKDAY),
    FRIDAY(PayType.WEEKDAY),
    SATURDAY(PayType.WEEKEND),
    SUNDAY(PayType.WEEKEND);

    private final PayType payType;

    PayrollDayHigher(PayType payType) {
        this.payType = payType;
    }

    double pay(double hours, double payRate){
        return payType.pay(hours,payRate);
    }

    /* The Strategy enum type*/
    private enum  PayType{
        WEEKDAY{
            @Override
            double overtimePay(double hours, double payRate) {
                return hours <= HOURS_PER_SHIFT ? 0 :
                        (hours - HOURS_PER_SHIFT) * payRate / 2;
            }
        },
        WEEKEND{
            @Override
            double overtimePay(double hours, double payRate) {
                return hours * payRate / 2;
            }
        };

        private static final  int HOURS_PER_SHIFT = 8;

        abstract double overtimePay(double hrs, double payRate);

        double pay(double hoursworked, double payRate){
            double basePay = hoursworked * payRate;
            return basePay + overtimePay(hoursworked, payRate);
        }

    }
}
