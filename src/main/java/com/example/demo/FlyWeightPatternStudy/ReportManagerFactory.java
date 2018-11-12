package com.example.demo.FlyWeightPatternStudy;

import java.util.HashMap;
import java.util.Map;

/**
 * 享元模式 FlyWeightFactory
 */
public class ReportManagerFactory {

    Map<String, IReportManager> financialReportManager =
            new HashMap<String, IReportManager>();

    Map<String, IReportManager> employeeReportManager =
            new HashMap<String, IReportManager>();

    IReportManager getFinancialReportManager(String tenantId){
        IReportManager r  = financialReportManager.get(tenantId);
        if(r==null){
            r = new FinancialReportManager(tenantId);
            financialReportManager.put(tenantId, r);
        }
        return r;
    }

     IReportManager getEmployeeReportManager(String tenantId){
        IReportManager r = employeeReportManager.get(tenantId);

        if(r==null){
            r = new EmployeeReportManager(tenantId);
            employeeReportManager.put(tenantId,r);
        }
        return r;
     }

    public static void main(String[] args) {
        ReportManagerFactory rmf = new ReportManagerFactory();
        IReportManager rm = rmf.getFinancialReportManager("A");

        IReportManager ee = rmf.getEmployeeReportManager("A");
        System.out.println(ee.createReport());
    }
}
