package com.pluralsight;

import java.io.BufferedWriter;
import java.io.FileWriter;

public class ContractDataManager {
    private final String FILE_NAME = "contracts.csv";

    public void saveContract(Contract contract){
        try {
            String contractType;
            if (contract instanceof SalesContract){
                contractType = "SALES";
            } else {
                contractType = "LEASE";
            }

            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(FILE_NAME, true));

            bufferedWriter.write(contractType + "|"

            );

        }catch (Exception ex){
            System.err.println("Error in ContractDataManager...");
        }
    }
}
