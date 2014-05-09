
/**
 * IsEmployeeWorkingAtThisBusinessSkeleton.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.6.2  Built on : Apr 17, 2012 (05:33:49 IST)
 */
    package org.example.www.isemployeeworkingatthisbusiness;
    /**
     *  IsEmployeeWorkingAtThisBusinessSkeleton java skeleton for the axisService
     */
    public class IsEmployeeWorkingAtThisBusinessSkeleton{
        
         
        /**
         * Auto generated method signature
         * 
                                     * @param dniIdAndBusinessId 
             * @return bool 
         */
        
                 public org.example.www.bool.BoolE isEmployeeWorkingAtThisBusiness
                  (
                  org.example.www.dniandbusiness.DniIdAndBusinessIdE dniIdAndBusinessId
                  )
            {
                	 org.example.www.bool.Bool bool = new org.example.www.bool.Bool();
                	 bool.setBool(true);
                	 org.example.www.bool.BoolE devolver = new org.example.www.bool.BoolE();
                   	 devolver.setBool(bool);
                	 return devolver;
                //TODO : fill this with the necessary business logic
                //throw new  java.lang.UnsupportedOperationException("Please implement " + this.getClass().getName() + "#isEmployeeWorkingAtThisBusiness");
        }
     
    }
    