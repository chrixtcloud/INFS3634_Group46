package com.example.group46;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class CompanyDB {

    public static Company getCompanyById(int companyID){
        return companies.get(companyID);
    }

    public static ArrayList<Company> getAllCompanies() {
        return new ArrayList<Company>((List) Arrays.asList(companies.values().toArray()));
    }


    // You can ignore everything below this for now.
    private static final HashMap<Integer, Company> companies = new HashMap<>();
    static {
        companies.put(1, new Company( 1, "Goldman Sachs", R.drawable.goldmansachs));
        companies.put(2, new Company(2, "JPMorgan Chase", R.drawable.jpmorgan));
        companies.put(3, new Company (3, "Lazard", R.drawable.lazard));
        companies.put(4, new Company (4, "Morgan Stanley", R.drawable.morgan));
        companies.put(5, new Company (5, "Citigroup",  R.drawable.citi));
        companies.put(6, new Company( 6, "Credit Suisse", R.drawable.creditsuisse));
        companies.put(7, new Company (7, "Deutsche Bank",  R.drawable.deutsche));
        companies.put(8, new Company (8, "UBS", R.drawable.ubs));

    }
}